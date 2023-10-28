package expensetracker.beans;

import java.sql.Date;


public class Budget {

	private int budget_id;
	private Date budgetDate;
	private int budgetAmount;

	public Budget() {
		super();
	}

	public Budget(int budget_id, Date budgetDate, int budgetAmount) {
		super();
		this.budget_id = budget_id;
		this.budgetDate = budgetDate;
		this.budgetAmount = budgetAmount;
	}

	public Budget(Date budgetDate, int budgetAmount) {
		super();
		this.budgetDate = budgetDate;
		this.budgetAmount = budgetAmount;
	}

	public int getBudget_id() {
		return budget_id;
	}

	public void setBudget_id(int budget_id) {
		this.budget_id = budget_id;
	}

	public Date getBudgetDate() {
		return budgetDate;
	}

	public void setBudgetDate(Date budgetDate) {
		this.budgetDate = budgetDate;
	}

	public int getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(int budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	@Override
	public String toString() {
		return "Budget [budget_id=" + budget_id + ", budgetDate=" + budgetDate + ", budgetAmount=" + budgetAmount + "]\n";
	}
	
	
}
