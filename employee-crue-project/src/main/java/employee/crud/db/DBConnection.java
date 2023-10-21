package employee.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static final String dbURL = "jdbc:mysql://localhost:3306/employee_db";
	public static final String dbUsernNAme = "root";
	public static final String dbPassword = "password1";

	public static Connection getConnection() {

		System.out.println("Start getConnection()"); // Use Logger better, such as Log4j
		try {

			// Load mysql JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open Connection
			connection = DriverManager.getConnection(dbURL, dbUsernNAme, dbPassword);

			if (connection != null) {
				System.out.println("Connected Successfully!");
				return connection;
			} else {
				System.out.println("Connection Issue!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Exception in DB Connection ==> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public static Connection connection = getConnection();

	public static void main(String[] args) {

		System.out.println(DBConnection.connection);
	}

}

// Java Web Development / Jakarta EE 8 (Servlet, JSP, JDBC,MVC)
