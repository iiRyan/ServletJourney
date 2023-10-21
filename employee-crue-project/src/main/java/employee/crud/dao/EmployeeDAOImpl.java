package employee.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import employee.crud.beans.Employee;
import employee.crud.db.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Connection connection = DBConnection.connection;

	@Override
	public boolean addEmployee(Employee employee) {
		System.out.println("Start addEmployee()");

		try {

			String insertStatement = "INSERT INTO employee_db.employee (name,email,phone,address) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getAddress());

			int result = preparedStatement.executeUpdate();

			return result == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		System.out.println("Start updateEmployee()");

		try {
			String updateStatement = "UPDATE employee_db.employee SET name = ?, email= ?, phone=?,address=? WHERE id = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getAddress());
			preparedStatement.setInt(5, employee.getId());

			int result = preparedStatement.executeUpdate();

			return result == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {

		System.out.println("Strart deleteEmployee()");

		try {
			String deleteStatement = "DELETE FROM employee_db.employee WHERE id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setInt(1, employeeId);

			int result = preparedStatement.executeUpdate();

			return result == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return null;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setId(13);
		employee.setName("Abdulah");
		employee.setEmail("abdulah@gmail.com");
		employee.setPhone("966565455415");
		employee.setAddress("Riyadh");

		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

		// System.out.println(employeeDAOImpl.addEmployee(employee));
		System.out.println(employeeDAOImpl.deleteEmployee(12));

	}
}