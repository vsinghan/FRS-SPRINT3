package com.cg.flightreservationsystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.flightreservationsystem.exception.FRSException;

public class DBConnection {

	private static Connection connection;

	public static Connection getConnection() throws FRSException {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			} catch (SQLException e) {
				throw new FRSException(ExceptionMessages.MESSAGE3);
			}
		}
		return connection;
	}
}
