package com.cg.flightreservationsystem.utility;

public class DBQueries {

	public static String query1 = "INSERT INTO passenger VALUES (?, ?, ?, ?, ?)";

	public static String query2 = "INSERT INTO Ticket VALUES (?, ?, null, null, null)";

	public static String query4 = "SELECT p.id, p.name, p.age, p.mobile_no, p.email_id FROM passenger p, Ticket t WHERE p.id=t.Passenger_id AND t.Pnr=?";

	public static String query5 = "SELECT COUNT(*) as count FROM passenger";

	public static String query6 = "select Passenger_id from Ticket where Pnr=?";

	public static String query7 = "delete from ticket where Pnr=?";

	public static String query8 = "delete from passenger where id=?";
}
