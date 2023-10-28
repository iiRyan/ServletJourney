package expensestracker.beans;




public class Budget {

	private int budget_id;
	private String date;
	private int amount;

	public Budget() {
		super();
	}

	public Budget(int budget_id, String date, int amount) {
		super();
		this.budget_id = budget_id;
		this.date = date;
		this.amount = amount;
	}

	public Budget(String date, int amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	public int getBudget_id() {
		return budget_id;
	}

	public void setBudget_id(int budget_id) {
		this.budget_id = budget_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Budget [budget_id=" + budget_id + ", date=" + date + ", amount=" + amount + "]";
	}

	
	
}
