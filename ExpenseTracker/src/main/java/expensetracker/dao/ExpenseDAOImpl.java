package expensetracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import expensetracker.beans.Expense;
import expensetracker.db.DBConnection;

public class ExpenseDAOImpl implements ExpenseDAO {
	public static Connection connection = DBConnection.connection;

	@Override
	public boolean addExpense(Expense expense) {
		System.out.println("Start addExpense()");

		try {
			String insertStatement = "INSERT INTO expenses_tracker.expenses (expense_type, expense_amount, expense_bank) VALUES (?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, expense.getExpense_type());
			preparedStatement.setInt(2, expense.getExpense_amount());
			preparedStatement.setString(3, expense.getExpense_bank());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateExpense(Expense expense) {
		System.out.println("Start updateExpense()");

		try {
			String updateStatement = "UPDATE expenses_tracker.expenses SET expense_type = ?, expense_amount = ?, expense_bank = ? WHERE expense_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, expense.getExpense_type());
			preparedStatement.setInt(2, expense.getExpense_amount());
			preparedStatement.setString(3, expense.getExpense_bank());
			preparedStatement.setInt(4, expense.getExpense_id());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Expense> getAllExpenses(int budget_date) {
		System.out.println("Start getAllExpenses()");

		try {
			String selectStatement = "SELECT * FROM expenses_tracker.expenses WHERE MONTH(expense_date) = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setInt(1, budget_date);

			ResultSet resultSet = preparedStatement.executeQuery();

			List<Expense> expenses = new ArrayList<Expense>();

			while (resultSet.next()) {
				Expense expense = new Expense();

				expense.setExpense_id(resultSet.getInt("expense_id"));
				expense.setExpense_type(resultSet.getString("expense_type"));
				expense.setExpense_amount(resultSet.getInt("expense_amount"));
				expense.setExpense_bank(resultSet.getString("expense_bank"));

				expenses.add(expense);
			}

			return expenses;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Expense getExpense(int expenseId) {
		System.out.println("Start getExpense()");

		try {
			String selectStatemnt = "SELECT * FROM expenses_tracker.expenses WHERE expense_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectStatemnt);
			preparedStatement.setInt(1, expenseId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Expense expense = new Expense();

			while (resultSet.next()) {
				expense.setExpense_id(resultSet.getInt("expense_id"));
				expense.setExpense_type(resultSet.getString("expense_type"));
				expense.setExpense_amount(resultSet.getInt("expense_amount"));
				expense.setExpense_bank(resultSet.getString("expense_bank"));
			}
			return expense;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deleteExpense(int expenseId) {
		System.out.println("Start deleteExpense()");
		
		try {
			String deleteStatement = "DELETE from expenses_tracker.expenses WHERE expense_id=?; ";
			PreparedStatement preparedStatement= connection.prepareStatement(deleteStatement);
			preparedStatement.setInt(1, expenseId);
			
			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}

	public static void main(String[] args) {

		Expense expense = new Expense();
		expense.setExpense_id(1);
		expense.setExpense_type("awdawd");
		expense.setExpense_amount(3423);
		expense.setExpense_bank("STCPay");

		ExpenseDAOImpl expenseDAOImpl = new ExpenseDAOImpl();

		// System.out.println(expenseDAOImpl.addExpense(expense)); //Insert
		// System.out.println(expenseDAOImpl.updateExpense(expense)); //Update
		//System.out.println(expenseDAOImpl.getAllExpenses(11));  	 //Select * 
		//System.out.println(expenseDAOImpl.getExpense(6));			//Select byId
		System.out.println(expenseDAOImpl.deleteExpense(6));		//Delete

	}
}
