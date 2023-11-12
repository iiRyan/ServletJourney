package employee.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection = null;
	
	public static Connection getConnection()
	{
		try
		{
			String dbURL = "jdbc:mysql://localhost:3306/employee_db"; // MySQL 
			String userName = "root";
			String password = "password1";
						
			
			//Load JDBC Driver
			Class.forName("com.mysql.jdbc.Driver"); //MySql Driver Class Name
			
			//Open Connection to MySql Employee DB
			connection = DriverManager.getConnection(dbURL, userName, password);
			
			//Condition to make sure connection is established.
			if( connection != null) 
			{
				System.out.println("Connected !");
			}
			else
			{
				System.out.println("Not Connected !");
			}		
			return connection;
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		DBConnection.getConnection();
	}
}
