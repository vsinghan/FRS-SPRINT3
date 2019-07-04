package com.cg.flightreservationsystem.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.flightreservationsystem.dto.PassengerDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.BookingOperations;
import com.cg.flightreservationsystem.service.impl.BookingOperationsImpl;
import com.cg.flightreservationsystem.utility.PassengerDetailsValidator;

public class Main {

	public static void main(String[] args) {

		int remainingSeats = 0, attempts = 3;
		int count = 0, input = 0;
		int noOfPassengers;
		String passengerName, passengerAge, passengerMobileNo, passengerEmailId, ticketId = "";

		Scanner scanner = new Scanner(System.in);

		BookingOperations bookingOperations = new BookingOperationsImpl();
		PassengerDetailsValidator passengerDetailsValidator = new PassengerDetailsValidator();
		try {
			remainingSeats = bookingOperations.viewAvailableSeats();
		} catch (FRSException e2) {
			System.out.println(e2.getMessage());
		}

		List<PassengerDTO> passengerList = new ArrayList<PassengerDTO>();
		System.out.println("---------------- Welcome to XYZ Air Travels Ltd. --------- ");

		for (;;) {
			System.out.println("\nPress 1 to View Available Seats");
			System.out.println("\nPress 2 to Book Ticket");
			System.out.println("\nPress 3 to Review Details");
			System.out.println("\nPress 4 to Cancel Ticket");
			System.out.println("\nPress 5 to Exit");

			try {
				input = Integer.parseInt(scanner.nextLine());
				if (input < 1 || input > 5) {
					count++;
					if (count == 3) {
						System.out.println("\nYour attempts limit is exhausted!!");
						System.out.println("\nPress Ctrl + F11 to Restart!!!");
						System.exit(0);
					} else {
						System.out.println("\nNumber should be between 1 to 5!!\n");
						System.out.println((attempts - count) + " Attempts are remaining!!\n");
						continue;
					}
				}
			} catch (NumberFormatException e) {
				count++;
				if (count == 3) {
					System.out.println("\nYour attempts limit is exhausted!!");
					System.out.println("\nPress Ctrl + F11 to Restart!!!");
					System.exit(0);
				} else {
					System.out.println("\nInvalid input!!\n");
					System.out.println((attempts - count) + " Attempts are remaining!!\n");
					continue;
				}
			}

			switch (input) {
			case 1:
				try {
					remainingSeats = bookingOperations.viewAvailableSeats();
				} catch (FRSException e1) {
					System.out.println(e1.getMessage());
				}
				System.out.println("\nSeats Available: " + remainingSeats);
				break;

			case 2:
				count = 0;
				for (;;) {
					System.out.println("\nEnter the no. of passengers: ");
					try {
						noOfPassengers = Integer.parseInt(scanner.nextLine());
						passengerDetailsValidator.isNoOfPassengersValid(noOfPassengers, remainingSeats);
						break;
					} catch (NumberFormatException e) {
						count++;
						if (count == 3) {
							System.out.println("\nYour attempts limit is exhausted!!");
							System.out.println("\nPress Ctrl + F11 to Restart!!!");
							System.exit(0);
						} else {
							System.out.println("\nInvalid input!!\n");
							System.out.println((attempts - count) + " Attempts are remaining!!\n");
							continue;
						}
					} catch (FRSException e) {
						count++;
						if (count == 3) {
							System.out.println("\nYour attempts limit is exhausted!!");
							System.out.println("\nPress Ctrl + F11 to Restart!!!");
							System.exit(0);
						} else {
							System.out.println(e.getMessage());
							System.out.println((attempts - count) + " Attempts are remaining!!");
							continue;
						}
					}
				}

				PassengerDTO passengerDTO[] = new PassengerDTO[noOfPassengers];

				count = 0;
				for (;;) {
					for (int i = 0; i < noOfPassengers; i++) {
						System.out.println("\nEnter the details of passenger " + (i + 1) + " :");

						System.out.println("\nName -  ");
						passengerName = scanner.nextLine();

						System.out.println("\nAge -  ");
						passengerAge = scanner.nextLine();

						System.out.println("\nMobile no. -  ");
						passengerMobileNo = scanner.nextLine();

						System.out.println("\nEmail ID -  ");
						passengerEmailId = scanner.nextLine();

						passengerDTO[i] = new PassengerDTO(passengerName, passengerAge, passengerMobileNo,
								passengerEmailId);

						passengerList.add(passengerDTO[i]);
					}
					try {
						List<String> tickets = bookingOperations.bookTicket(passengerList);
						System.out.println("Your Ticket is Confirmed!!");
						for (String ticket : tickets) {
							System.out.println("Yout Ticket ID is: " + ticket);
						}
						break;
					} catch (FRSException e) {
						System.out.println(e.getMessage());
						System.out.println("\nFill again all the details!!");
						count++;
						if (count == 3) {
							System.out.println("\nYour attempts limit is exhausted!!");
							System.out.println("\nPress Ctrl + F11 to Restart!!!");
							System.exit(0);
						} else {
							System.out.println((attempts - count) + " Attempts are remaining!!");
						}
					}
				}
				break;

			case 3:
				count = 0;
				for (;;) {
					System.out.println("\nEnter Your ticket ID:");
					try {
						ticketId = scanner.nextLine();
						try {
							System.out.println(bookingOperations.reviewDetails(ticketId).toString());
							break;
						} catch (FRSException e) {
							System.out.println(e.getMessage());
							count++;
							if (count == 3) {
								System.out.println("\nYour attempts limit is exhausted!!");
								break;
							} else {
								System.out.println((attempts - count) + " Attempts are remaining!!");
							}
						}
					} catch (Exception e) {
						System.out.println("\nTicket Id should be a number between 1 - 180!!!");
						count++;
						if (count == 3) {
							System.out.println("\nYour attempts limit is exhausted!!");
							break;
						} else {
							System.out.println((attempts - count) + " Attempts are remaining!!");
						}
					}
				}
				break;

			case 4:
				count = 0;
				for (;;) {
					System.out.println("\nEnter Your ticket ID:");
					try {
						ticketId = scanner.nextLine();
						try {
							bookingOperations.cancelTicket(ticketId);
							System.out.println("\nYour ticket has been cancelled!!!");
							break;
						} catch (FRSException e) {
							System.out.println(e.getMessage());
							count++;
							if (count == 3) {
								System.out.println("\nYour attempts limit is exhausted!!");
								break;
							} else {
								System.out.println((attempts - count) + " Attempts are remaining!!");
							}
						}
					} catch (Exception e) {
						System.out.println("\nTicket Id should be a number between 1 - 180!!!");
						count++;
						if (count == 3) {
							System.out.println("\nYour attempts limit is exhausted!!");
							break;
						} else {
							System.out.println((attempts - count) + " Attempts are remaining!!");
						}
					}
				}
				break;

			case 5:
				scanner.close();
				System.exit(0);

			default:
				System.out.println("\nPlease enter valid input!!!");
			}
		}
	}
}
