package com.cg.flightreservationsystem.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.flightreservationsystem.dto.PassengerDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.BookingOperations;

class BookingOperationsImplTest {

	BookingOperations detailsObj = new BookingOperationsImpl();
	List<PassengerDTO> passengerDTOs = new ArrayList<PassengerDTO>();

	@Test
	void testBookTicketWithValidName() throws FRSException {

		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "88", "9983077144", "vishuji07@gmail.com"));
		System.out.println(detailsObj.bookTicket(passengerDTOs));

		assertNotEquals("66", detailsObj.bookTicket(passengerDTOs));
	}

	@Test
	void testBookTicketWithInValidName() throws FRSException {
		passengerDTOs.add(new PassengerDTO("vishal singhaniya", "88", "9983077144", "vishuji07@gmail.com"));
		Assertions.assertThrows(FRSException.class, () -> {

			detailsObj.bookTicket(passengerDTOs);
		});
	}

	@Test
	void testBookTicketWithValidAge() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "22", "9983077144", "vishuji07@gmail.com"));
		assertNotEquals("66", detailsObj.bookTicket(passengerDTOs));
	}

	@Test
	void testBookTicketWithInValidAge() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "djj", "9983077144", "vishuji07@gmail.com"));
		Assertions.assertThrows(FRSException.class, () -> {

			detailsObj.bookTicket(passengerDTOs);
		});
	}

	@Test
	void testBookTicketWithValidMobileNo() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "88", "9983077144", "vishuji07@gmail.com"));
		assertNotEquals("66", detailsObj.bookTicket(passengerDTOs));
	}

	@Test
	void testBookTicketWithInValidMobileNo() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "22", "57983077144", "vishuji07@gmail.com"));
		Assertions.assertThrows(FRSException.class, () -> {

			detailsObj.bookTicket(passengerDTOs);
		});
	}

	@Test
	void testBookTicketWithValidEmailId() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "88", "9983077144", "vishuji07@gmail.com"));
		assertNotEquals("66", detailsObj.bookTicket(passengerDTOs));
	}

	@Test
	void testBookTicketWithInValidEmailId() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "122", "9983077144", "vishuji07@@gmail..com"));
		Assertions.assertThrows(FRSException.class, () -> {

			detailsObj.bookTicket(passengerDTOs);
		});
	}

	@Test
	void testCancelTicketWithValidId() throws FRSException {
		Assertions.assertThrows(FRSException.class, () -> {
			detailsObj.cancelTicket("57");
		});
	}

	@Test
	void testCancelTicketWithInvalidId() throws FRSException {
		Assertions.assertThrows(FRSException.class, () -> {
			detailsObj.cancelTicket("570");
		});
	}

	@Test
	void testCancelTicketWithNonIntegerInvalidId() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "22", "57983077144", "vishuji07@gmail.com"));
		Assertions.assertThrows(FRSException.class, () -> {

			detailsObj.cancelTicket("2389483**^");
		});

	}

	@Test
	void testViewAvailableSeats() throws FRSException {
		assertNotEquals(180, detailsObj.viewAvailableSeats());
	}

	@Test
	void testReviewDetailsWithInvalidId() throws FRSException {
		passengerDTOs.add(new PassengerDTO("Vishal Singhaniya", "22", "9983077144", "vishuji07@gmail.com"));
		Assertions.assertThrows(FRSException.class, () -> {

			detailsObj.reviewDetails("6778");
		});

	}

}
