package com.cg.flightreservationsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.cg.flightreservationsystem.dto.TicketDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.utility.DBConnection;
import com.cg.flightreservationsystem.utility.DBQueries;
import com.cg.flightreservationsystem.utility.ExceptionMessages;
import com.cg.flightreservationsystem.dto.FlightDTO;
import com.cg.flightreservationsystem.dto.PassengerDTO;

public class PassengerDaoImpl implements PassengerDao {

	private String pnrNo, passengerId;
	int i = 0;

	List<String> tickets = new ArrayList<>();
	// EntityManager entityManager;

	/*
	 * this persistenceUnitName is loading the driver and connecting to the database
	 */
	// String persistenceUnitName =
	// entityManager.getEntityManagerFactory().getProperties()
	// .get("hibernate.ejb.persistenceUnitName").toString();

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("booking");

	/*
	 * it manages the entities
	 */
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	Random randomNo = new Random();

	public List<String> insertPassenger(List<PassengerDTO> passengerDTOs) throws FRSException {
		// Connection connection = DBConnection.getConnection();
		// List<String> tickets = new ArrayList<>();
		// PreparedStatement preparedStatement = null;
		for (PassengerDTO passengerDTO : passengerDTOs) {
			entityTransaction.begin();
			entityManager.persist(passengerDTO);
			entityTransaction.commit();
			
			//how i will get above committed row?
			PassengerDTO passengerDTO = entityManager.find(PassengerDTO.class, passengerDTO.getId());
			String passengerId = passengerDTO.getId();
			String passengerName = passengerDTO.getName();
			
			//flightId, I will get when customer selects a flght
			FlightDTO flightDTO = entityManager.find(FlightDTO.class, flightId)
					
			TicketDTO ticketDTO = new TicketDTO();
			ticketDTO.setPassengerId(passengerId);
			//flightId, I will get when customer selectis a flght
			ticketDTO.setFlightId(flightId);
			
			entityTransaction.begin();
			entityManager.persist(ticketDTO);
			entityTransaction.commit();
			
			
		}

		PassengerDTO passengerDTO = entityManager.find(PassengerDTO.class, passengerDTO.getId());

		String passengerId = passengerDTO.getId();

		TicketDTO ticketDTO = new TicketDTO();
		
		ticketDTO.s

		// try {
		// preparedStatement = connection.prepareStatement(DBQueries.query1);
		//
		// passengerId = (randomNo.nextInt(180) + 1) + "";
		// if (passengerId.length() == 1) {
		// passengerId += "00";
		// }
		// if (passengerId.length() == 2) {
		// passengerId += "0";
		// }
		// passengerDTO.setId("PI" + passengerId);
		//
		// preparedStatement.setString(1, passengerDTO.getId());
		// preparedStatement.setString(2, passengerDTO.getName());
		// preparedStatement.setString(3, passengerDTO.getAge());
		// preparedStatement.setString(4, passengerDTO.getMobileNo());
		// preparedStatement.setString(5, passengerDTO.getEmailId());
		// i = preparedStatement.executeUpdate();
		//
		// if (i == 1) {
		// try {
		// TicketDTO ticketDTO = new TicketDTO();
		// preparedStatement = connection.prepareStatement(DBQueries.query2);
		// pnrNo = (randomNo.nextInt(180) + 1) + "";
		// ticketDTO.setPnrNo(pnrNo);
		// preparedStatement.setString(1, passengerDTO.getId());
		// preparedStatement.setString(2, ticketDTO.getPnrNo());
		// i = preparedStatement.executeUpdate();
		//
		// if (i == 1) {
		// connection.commit();
		// tickets.add(ticketDTO.getPnrNo());
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE5);
		// }
		// } catch (SQLException ex) {
		// throw new FRSException(ExceptionMessages.MESSAGE5);
		// }
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE4);
		// }
		// } catch (SQLException ex) {
		// throw new FRSException(ExceptionMessages.MESSAGE8);
		// }
		// }
		// return tickets;
	}

	public void deletePassenger(String ticketId) throws FRSException {

		TicketDTO ticketDTO = entityManager.find(TicketDTO.class, ticketId);

		String passengerId = ticketDTO.getPassengerId();

		if (ticketDTO != null) {
			entityTransaction.begin();
			entityManager.remove(ticketDTO);
			entityTransaction.commit();
		}

		PassengerDTO passengerDTO = entityManager.find(PassengerDTO.class, passengerId);

		if (passengerDTO != null) {
			entityTransaction.begin();
			entityManager.remove(passengerDTO);
			entityTransaction.commit();
		}

		// Connection connection = DBConnection.getConnection();
		//
		// try {
		// PreparedStatement preparedStatement =
		// connection.prepareStatement(DBQueries.query6);
		// preparedStatement.setString(1, ticketId);
		// ResultSet resultSet = preparedStatement.executeQuery();
		//
		// String passengerId = "";
		// if (resultSet.next()) {
		// passengerId = resultSet.getString(1);
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE9);
		// }
		//
		// preparedStatement = connection.prepareStatement(DBQueries.query7);
		// preparedStatement.setString(1, ticketId);
		// int i = preparedStatement.executeUpdate();
		// if (i == 1) {
		// preparedStatement = connection.prepareStatement(DBQueries.query8);
		// preparedStatement.setString(1, passengerId);
		// i = preparedStatement.executeUpdate();
		// if (i == 1) {
		// connection.commit();
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE10);
		// }
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE11);
		// }
		// } catch (SQLException ex) {
		// throw new FRSException(ExceptionMessages.MESSAGE8);
		// }
	}

	public PassengerDTO getPassengerInfo(String ticketId) throws FRSException {

		return entityManager.find(PassengerDTO.class, ticketId);

		// Connection connection = DBConnection.getConnection();
		// PreparedStatement preparedStatement = null;
		// try {
		// preparedStatement = connection.prepareStatement(DBQueries.query4);
		// preparedStatement.setString(1, ticketId);
		// ResultSet resultSet = preparedStatement.executeQuery();
		//
		// if (resultSet.next()) {
		// PassengerDTO dto = new PassengerDTO();
		// dto.setId(resultSet.getString("id"));
		// dto.setName(resultSet.getString("name"));
		// dto.setAge(resultSet.getString("age"));
		// dto.setMobileNo(resultSet.getString("mobile_no"));
		// dto.setEmailId(resultSet.getString("email_id"));
		//
		// return dto;
		// } else {
		// throw new FRSException(ExceptionMessages.MESSAGE9);
		// }
		// } catch (SQLException ex) {
		// throw new FRSException(ExceptionMessages.MESSAGE8);
		// }
	}

	public int getNoOfPassengers() throws FRSException {

		Connection connection = DBConnection.getConnection();
		int noOfPassengers = 0;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(DBQueries.query5);

			if (resultSet.next()) {
				noOfPassengers = resultSet.getInt(1);
			}
		} catch (SQLException ex) {
			throw new FRSException(ExceptionMessages.MESSAGE7);
		}
		return noOfPassengers;
	}
}