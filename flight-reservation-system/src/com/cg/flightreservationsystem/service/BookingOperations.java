package com.cg.flightreservationsystem.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.frs.PassengerDTO;

public interface BookingOperations {
	int CAPACITY = 180;

	PassengerDTO reviewDetails(String ticketId) throws FRSException;

	List<String> bookTicket(List<PassengerDTO> passengerList) throws FRSException;

	int viewAvailableSeats() throws FRSException;

	void cancelTicket(String ticketId) throws FRSException, SQLException;

}
