package expensestracker.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expensestracker.beans.Budget;
import expensestracker.dao.BudgetDAO;
import expensestracker.dao.BudgetDAOImpl;

@WebServlet("/budgets/*")
public class BudgetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BudgetDAO budgetDAO = null;

	public BudgetController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		budgetDAO = new BudgetDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("budgetController, doPost() Started");
		String action = request.getPathInfo();
		System.out.println("doPost, action ==>" + action);

		if (action == null) 
			
			getAllBudgets(request, response);
		 
			switch (action) {

			case "/add": {
				addNewBudget(request, response);
				break;
			}
			case "/update": {
				updateBudget(request, response);
				break;
			}
			case "/delete": {
				deleteBudget(request, response);
				break;
			}
			case "/get": {
				getBudget(request, response);
				break;
			}

			case "/list": {
				getAllBudgets(request, response);
				break;
			
			
		  }
		}
	}

	private void getBudget(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start getBudget");

		int id = Integer.parseInt(request.getParameter("BudgetId"));
		System.out.println("getBudget, Budget ID ==>" + id);

		Budget budget = budgetDAO.getBudget(id);
		System.out.println("getBudget, result is ==> " + budget);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/budgetsView.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void getAllBudgets(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Start getAllBudgets()");

		List<Budget> budgets = budgetDAO.getAllBudgets();
		System.out.println("getAllBudgets, BudgetsSize ==> " + budgets);

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/budgetsView.jsp");
			request.setAttribute("budgets", budgets);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void deleteBudget(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start deleteBudget");

		String BudgetIds = request.getParameter("BudgetId");
		System.out.println("deleteBudget, Budget ID ==>" + BudgetIds);

		StringTokenizer tokenizer = new StringTokenizer(BudgetIds, ",");

		while (tokenizer.hasMoreElements()) {
			int budgetId = Integer.parseInt(tokenizer.nextToken());
			boolean result = budgetDAO.deleteBudget(budgetId);
			System.out.println("deleteBudget, result is ==> " + result);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/budgetView.jsp");

		try {

			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void updateBudget(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Start updateBudget");

		int budget_id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		int amount = Integer.parseInt(request.getParameter("amount"));

		Budget budget = new Budget(budget_id, date, amount);
		System.out.println("updateBudget, Budget Details==>" + budget);

		boolean result = budgetDAO.updateBudget(budget);
		System.out.println("updateBudget, result is ==> " + result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/budgetsView.jsp");
		try {

			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void addNewBudget(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start addNewBudget()");

		String date = request.getParameter("month");
		int amount = Integer.parseInt(request.getParameter("amount"));

		Budget budget = new Budget(date, amount);
		System.out.println("addBudget, Budget Details ==> " + budget);
		List<Budget> budgets = budgetDAO.getAllBudgets();
		System.out.println("getAllBudgets, BudgetsSize ==> " + budgets);
		boolean result = budgetDAO.addBudget(budget);
		System.out.println("addNewBudget Result is ==> " + result);
	
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/budgetsView.jsp");
			request.setAttribute("budgets", budgets);
			dispatcher.forward(request, response);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
