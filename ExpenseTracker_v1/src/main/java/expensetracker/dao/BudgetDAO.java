package expensetracker.dao;

import java.util.List;

import expensetracker.beans.Budget;

public interface BudgetDAO {

	// 1-Insert
	public boolean addBudget(Budget budget);

	// 2-Update
	public boolean updateBudget(Budget budget);

	// 3-get allbudget
	public List<Budget> getAllBudgets();

	// 4-get single budget
	public Budget getBudget(int budgetId);

	// 5-Delete an budget
	public boolean deleteBudget(int budgetId);

}
