package com.cg.flightreservationsystem.dao;

import java.util.List;

import com.cg.flightreservationsystem.dto.PassengerDTO;
import com.cg.flightreservationsystem.exception.FRSException;

public interface PassengerDao {

	List<String> insertPassenger(List<PassengerDTO> passengerDTOs) throws FRSException;

	void deletePassenger(String ticketId) throws FRSException;

	PassengerDTO getPassengerInfo(String ticketId) throws FRSException;

	int getNoOfPassengers() throws FRSException;
}
