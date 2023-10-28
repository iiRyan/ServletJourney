package expensetracker.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expensetracker.beans.Expense;
import expensetracker.dao.ExpenseDAO;
import expensetracker.dao.ExpenseDAOImpl;

@WebServlet("/")
public class ExpenseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ExpenseDAO expenseDAO = null;

	public ExpenseController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		expenseDAO = new ExpenseDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// If Action arrives at doGet,It will be Redirected to doPost()
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("expenseController,doPost() Started");
		String action = request.getServletPath();
		System.out.println("doPost, action ==> " + action);

		switch (action) {
		
		case "/add":
		{
			addNewExpense(request, response);
			break;
		}
		case "/update":
		{
			updateExpense(request, response);
			break;	
		}
		case "/delete":
		{
			deleteExpense(request, response);
			break;
		}
		case "/get":
		{
			getExpense(request, response);
			break;
		}
		

		case "/list":
		{
			getAllExpenses(request, response);
			break;
		}
		default:
		{
			getAllExpenses(request, response);
			break;
		}
			
		}

	}

	private void getExpense(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start getExpense");

		int id = Integer.parseInt(request.getParameter("expenseId"));
		System.out.println("getExpense, Expense ID ==>" + id);

		Expense expense= expenseDAO.getExpense(id);
		System.out.println("getExpense, result is ==> " + expense);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/expensesView.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException|IOException e) {
			e.printStackTrace();
		}

	}

	private void getAllExpenses(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Start getAllExpenses()");

		//int budget_date = Integer.parseInt(request.getParameter("budget_date"));
		System.out.println("Budget Mnoth is ==> " );

		List<Expense> expenses = expenseDAO.getAllExpenses(10);
		System.out.println("getAllExpenses, expensesSize ==> " + expenses);
		
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/expensesView.jsp");
			request.setAttribute("expenses", expenses);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void deleteExpense(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start deleteExpense");

		String expenseIds = request.getParameter("expenseId");
		System.out.println("deleteExpense, Expense ID ==>" + expenseIds);

		StringTokenizer tokenizer = new StringTokenizer(expenseIds, ",");

		while (tokenizer.hasMoreElements()) {
			int employeeId = Integer.parseInt(tokenizer.nextToken());
			boolean result = expenseDAO.deleteExpense(employeeId);
			System.out.println("deleteExpense, result is ==> " + result);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");

		try {

			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void updateExpense(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Start updateExpense");

		int id = Integer.parseInt(request.getParameter("id"));
		String expenseType = request.getParameter("expense");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String bank = request.getParameter("bank");

		Expense expense = new Expense(id, expenseType, amount, bank);
		System.out.println("updateExpense, Expense Details==>" + expense);

		boolean result = expenseDAO.updateExpense(expense);
		System.out.println("updateExpense, result is ==> " + result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/expensesView.jsp");
		try {

			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void addNewExpense(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start addNewExpense()");

		String expenseType = request.getParameter("expense");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String bank = request.getParameter("bank");

		Expense expense = new Expense(expenseType, amount, bank);
		System.out.println("addExpense, Expense Details ==> " + expense);

		boolean result = expenseDAO.addExpense(expense);
		System.out.println("addNewExpense Result is ==> " + result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/expensesView.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
