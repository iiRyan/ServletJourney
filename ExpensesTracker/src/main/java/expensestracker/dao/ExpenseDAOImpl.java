package expensestracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import expensestracker.beans.Expense;
import expensestracker.db.DBConnection;

public class ExpenseDAOImpl implements ExpenseDAO {
	public static Connection connection = DBConnection.connection;

	@Override
	public boolean addExpense(Expense expense) {
		System.out.println("Start addExpense()");

		try {
			String insertStatement = "INSERT INTO expenses_tracker.expense (budget_id ,description, amount,bank) VALUES (?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, expense.getBudget_id());
			preparedStatement.setString(2, expense.getDescription());
			preparedStatement.setInt(3, expense.getAmount());
			preparedStatement.setString(4, expense.getBank());

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
			String updateStatement = "UPDATE expenses_tracker.expense SET description = ?, amount = ? ,bank = ? WHERE expense_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, expense.getDescription());
			preparedStatement.setInt(2, expense.getAmount());
			preparedStatement.setString(3, expense.getBank());
			preparedStatement.setInt(4, expense.getExpense_id());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Expense> getAllExpenses(int budget_id) {
		System.out.println("Start getAllExpenses()");

		try {
			String selectStatement = "SELECT * FROM expenses_tracker.expense WHERE budget_id = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setInt(1, budget_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			List<Expense> expenses = new ArrayList<Expense>();

			while (resultSet.next()) {
				Expense expense = new Expense();

				expense.setExpense_id(resultSet.getInt("expense_id"));
				expense.setDescription(resultSet.getString("description"));
				expense.setAmount(resultSet.getInt("amount"));
				expense.setBank(resultSet.getString("bank"));

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
			String selectStatemnt = "SELECT * FROM expenses_tracker.expense WHERE expense_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectStatemnt);
			preparedStatement.setInt(1, expenseId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Expense expense = new Expense();

			while (resultSet.next()) {
				
				expense.setExpense_id(resultSet.getInt("expense_id"));
				expense.setExpense_id(resultSet.getInt("expense_id"));
				expense.setDescription(resultSet.getString("description"));
				expense.setAmount(resultSet.getInt("amount"));
				expense.setBank(resultSet.getString("bank"));
				
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
			String deleteStatement = "DELETE from expenses_tracker.expense WHERE expense_id=?; ";
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
		expense.setBudget_id(2);
		expense.setDescription("JUN");
		expense.setAmount(5665);
		expense.setBank("Rajhi");

		ExpenseDAOImpl expenseDAOImpl = new ExpenseDAOImpl();

		 //System.out.println(expenseDAOImpl.addExpense(expense)); //Insert
		 //System.out.println(expenseDAOImpl.updateExpense(expense)); //Update
		//System.out.println(expenseDAOImpl.getAllExpenses(2));  	 //Select * 
		//System.out.println(expenseDAOImpl.getExpense(6));			//Select byId
		System.out.println(expenseDAOImpl.deleteExpense(5));		//Delete

	}
}
