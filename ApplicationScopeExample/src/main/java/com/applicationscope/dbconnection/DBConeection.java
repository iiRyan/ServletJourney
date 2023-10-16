package com.applicationscope.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConeection {

	private static Connection connection = null;

	public static Connection openConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "password1");
			return connection;
			// getServletContext().setAttribute("employee-connection-db", connection);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static boolean closeConnection() {
		try {
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// TEST UNIT
	public static void main(String[] args) {

		System.out.println(DBConeection.openConnection());
		System.out.println(DBConeection.closeConnection());
	}
}
