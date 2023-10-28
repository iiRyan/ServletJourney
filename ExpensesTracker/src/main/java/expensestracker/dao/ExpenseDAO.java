package expensestracker.dao;

import java.util.List;

import expensestracker.beans.Expense;

public interface ExpenseDAO {

	//1-Insert
	public boolean addExpense(Expense expense);
	//2-Update
	public boolean updateExpense(Expense expense);
	//3-get allExpense
	public List<Expense> getAllExpenses(int budget_id);
	//4-get single Expenses
	public Expense getExpense(int expenseId);
	//5-Delete an expense
	public boolean deleteExpense(int expenseId);
}
