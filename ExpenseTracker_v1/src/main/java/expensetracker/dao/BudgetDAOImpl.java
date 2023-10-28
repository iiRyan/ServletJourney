package expensetracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import expensetracker.beans.Budget;
import expensetracker.db.DBConnection;

public class BudgetDAOImpl implements BudgetDAO {

	public static Connection connection = DBConnection.connection;

	@Override
	public boolean addBudget(Budget budget) {
		System.out.println("Start addBudget()");

		try {
			String insertStatetemnt = "INSERT INTO expenses_tracker.budget (budget_date, budget_amount) VALUES (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatetemnt);

			preparedStatement.setDate(1, budget.getBudgetDate());
			preparedStatement.setInt(2, budget.getBudgetAmount());

			int result = preparedStatement.executeUpdate();
			// If (result == 1 )return true
			// else return false
			return result == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBudget(Budget budget) {
		System.out.println("Start updateBudget()");

		try {
			String updateStstemeant = "UPDATE expenses_tracker.budget SET budget_date =?, budget_amount = ? WHERE budget_id = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(updateStstemeant);

			preparedStatement.setDate(1, budget.getBudgetDate());
			preparedStatement.setInt(2, budget.getBudgetAmount());
			preparedStatement.setInt(3, budget.getBudget_id());

			int result = preparedStatement.executeUpdate();

			return result == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Budget> getAllBudgets() {

		System.out.println("Start getAllBudgets()");

		try {
			String selectStatement = "SELECT * from expenses_tracker.budget";
			PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Budget> budgets = new ArrayList<Budget>();
			// Convert to budget_date into Date

			while (resultSet.next()) {

				Budget budget = new Budget();

				budget.setBudget_id(resultSet.getInt("budget_id"));
				budget.setBudgetDate(resultSet.getDate("budget_date"));
				budget.setBudgetAmount(resultSet.getInt("budget_amount"));

				budgets.add(budget);
			}
			return budgets;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Budget getBudget(int budgetId) {
		System.out.println("Start getBudget()");

		try {
			String selectStatement = "SELECT * FROM expenses_tracker.budget WHERE budget_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setInt(1, budgetId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Budget budget = new Budget();
			while (resultSet.next()) {

				budget.setBudget_id(resultSet.getInt("budget_id"));
				budget.setBudgetDate(resultSet.getDate("budget_date"));
				budget.setBudgetAmount(resultSet.getInt("budget_amount"));

			}
			return budget;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deleteBudget(int budgetId) {
		System.out.println("Start deleteBudget()");
		
		try {
			String deleteStatement = "DELETE FROM expenses_tracker.budget WHERE budget_id =?;";
			PreparedStatement preparedStatement  = connection.prepareStatement(deleteStatement);
			preparedStatement.setInt(1, budgetId);
			
			int result = preparedStatement.executeUpdate();
			
			return result == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		BudgetDAOImpl budgetDAOImpl = new BudgetDAOImpl();

		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
		Budget budget = new Budget();
		budget.setBudget_id(1);
		budget.setBudgetAmount(15);
		budget.setBudgetDate(sqlDate);

//		System.out.println(budgetDAOImpl.addBudget(budget));
//		System.out.println(budgetDAOImpl.updateBudget(budget));
//		System.out.println(budgetDAOImpl.getAllBudgets());
//		System.out.println(budgetDAOImpl.getBudget(1));
		System.out.println(budgetDAOImpl.deleteBudget(5));
		
	}

}
