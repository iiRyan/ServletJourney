package employee.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import employee.crud.beans.Employee;
import employee.crud.dao.EmployeeDAO;
import employee.crud.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO employeeDAO = null;

	public EmployeeController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// initialize it in the init method to be executed once.
		employeeDAO = new EmployeeDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("EmployeeController, doPost() Started");

		String action = request.getServletPath();
		System.out.println("doPost(), Action ==> " + action);

		switch (action) {

		case "/add": {
			addNewEmployee(request, response);
			break;
		}
		case "/update": {
			updateNewEmployee(request, response);
			break;
		}
		case "/delete": {
			deleteNewEmployee(request, response);
			break;
		}
		case "/list": {
			getAllEmployee(request, response);
			break;
		}
		case "/get": {
			getEmployee(request, response);
			break;
		}
		default:
			getAllEmployee(request, response);
			break;
		}

	}

	private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start addNewEmployee()");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		Employee employee = new Employee(name, email, phone, address);
		System.out.println("addEmployee, Employee Details ==> " + employee);

		boolean result = employeeDAO.addEmployee(employee);
		System.out.println("addNewEmployeere Result is ==> " + result);

		List<Employee> employees = employeeDAO.getAllEmployees();
		System.out.println("getAllEmployees, employees size ==> " + employees.size());

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");
			request.setAttribute("employees", employees);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}

	private void updateNewEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start updateNewEmployee()");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		Employee employee = new Employee(id, name, email, phone, address);
		System.out.println("updateNewEmployee, Employee Details ==> " + employee);

		boolean result = employeeDAO.updateEmployee(employee);
		System.out.println("updateNewEmployee Result is ==> " + result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

	private void deleteNewEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start updateNewEmployee()");

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("deleteNewEmployee(), Employee ID ==> " + id);

		boolean result = employeeDAO.deleteEmployee(id);
		System.out.println("deleteNewEmployee Result is ==> " + result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}

	private void getAllEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start getAllEmployees");

		List<Employee> employees = employeeDAO.getAllEmployees();
		System.out.println("getAllEmployees, employees size ==> " + employees.size());

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");
			request.setAttribute("employees", employees);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void getEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start getEmployee()");

		int id = Integer.parseInt(request.getParameter("employeeId"));
		System.out.println("getEmployee(), Employee ID ==> " + id);

		Employee employee = employeeDAO.getEmployee(id);
		System.out.println("getEmployee Result is ==> " + employee);

		
		try {
			// To convert the "employee" object from a java object to a json object.
			ObjectMapper mapper = new ObjectMapper();
			/*
			 * define a string where we receive the jakson function’s output, which is write
			 * value as a string. By that, it outputs a json object from the java object.
			 */
			String employeeStr = mapper.writeValueAsString(employee);

			/*
			 * And because the write function in the servlet output stream is assigned an
			 * array of bytes, we convert this string to an array of bytes.
			 */
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(employeeStr.getBytes());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
