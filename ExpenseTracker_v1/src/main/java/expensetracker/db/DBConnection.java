package expensetracker.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static final String dbURL = "jdbc:mysql://localhost:3306/expenses_tracker";
	public static final String dbUsernNAme = "root";
	public static final String dbPassword = "password1";
//	public static Connection connection = null;

	public static Connection getConnection() {

		System.out.println("Start getConnection()");

		try {

			Class.forName("com.mysql.jdbc.Driver");
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
