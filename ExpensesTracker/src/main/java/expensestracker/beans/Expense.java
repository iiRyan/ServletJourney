package expensestracker.beans;



public class Expense {

	private int expense_id;
	private int budget_id;
	private String description;
	private int amount;
	private String bank;

	public Expense() {
		super();
	}

	public Expense(int expense_id,  String description, int amount, String bank) {
		super();
		this.expense_id = expense_id;
		this.description = description;
		this.amount = amount;
		this.bank = bank;
	}

	public Expense(String description, int amount, String bank) {
		super();
		this.description = description;
		this.amount = amount;
		this.bank = bank;
	}

	public int getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}

	public int getBudget_id() {
		return budget_id;
	}

	public void setBudget_id(int budget_id) {
		this.budget_id = budget_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Expense [expense_id=" + expense_id + ", budget_id=" + budget_id + ", description=" + description
				+ ", amount=" + amount + ", bank=" + bank + "]";
	}

	
}