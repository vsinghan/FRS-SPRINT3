package com.cg.flightreservationsystem.service.impl;

import java.util.List;

import com.cg.flightreservationsystem.dao.PassengerDao;
import com.cg.flightreservationsystem.dao.PassengerDaoImpl;
import com.cg.flightreservationsystem.dto.PassengerDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.BookingOperations;
import com.cg.flightreservationsystem.utility.ExceptionMessages;
import com.cg.flightreservationsystem.utility.PassengerDetailsValidator;

public class BookingOperationsImpl implements BookingOperations {

	PassengerDetailsValidator passengerDetailsValidator = new PassengerDetailsValidator();

	PassengerDao passengerDetails = new PassengerDaoImpl();

	static int nameCount = 0, ageCount = 0, mobileNoCount = 0, emailCount = 0;

	// this method will book the tickets for passengers
	@Override
	public List<String> bookTicket(List<PassengerDTO> passengerList) throws FRSException {
		for (int i = 0; i < passengerList.size(); i++) {
			String passengerName = passengerList.get(i).getName();
			String passengerAge = passengerList.get(i).getAge();
			String mobileNo = passengerList.get(i).getMobileNo();
			String emailId = passengerList.get(i).getEmailId();

			passengerDetailsValidator.isNameValid(passengerName);
			passengerDetailsValidator.isAgeValid(passengerAge);
			passengerDetailsValidator.isMobileNoValid(mobileNo);
			passengerDetailsValidator.isEmailIdValid(emailId);

		}
		List<String> tickets = passengerDetails.insertPassenger(passengerList);
		return tickets;
	}

	// this method will return no. of seats available
	@Override
	public int viewAvailableSeats() throws FRSException {
		return CAPACITY - passengerDetails.getNoOfPassengers();
	}

	// this method will cancel the ticket using ticket id
	@Override
	public void cancelTicket(String ticketId) throws FRSException {
		if (!passengerDetailsValidator.isTicketIdValid(ticketId)) {
			throw new FRSException(ExceptionMessages.MESSAGE1);
		}
		passengerDetails.deletePassenger(ticketId);
	}

	// this method will return passenger details
	@Override
	public PassengerDTO reviewDetails(String ticketId) throws FRSException {
		if (!passengerDetailsValidator.isTicketIdValid(ticketId))
			throw new FRSException(ExceptionMessages.MESSAGE1);
		PassengerDTO dto = passengerDetails.getPassengerInfo(ticketId);
		return dto;
	}
}
