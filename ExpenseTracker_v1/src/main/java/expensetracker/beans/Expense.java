package expensetracker.beans;

import java.time.LocalDate;

public class Expense {

	private int expense_id;
	private String expense_type;
	private int expense_amount;
	private String expense_bank;

	public Expense() {
		super();
	}

	public Expense(String expense_type, int expense_amount, String expense_bank) {
		super();
		this.expense_type = expense_type;
		this.expense_amount = expense_amount;
		this.expense_bank = expense_bank;

	}

	public Expense(int expense_id, String expense_type, int expense_amount, String expense_bank) {
		super();
		this.expense_id = expense_id;
		this.expense_type = expense_type;
		this.expense_amount = expense_amount;
		this.expense_bank = expense_bank;

	}

	public int getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}

	public String getExpense_type() {
		return expense_type;
	}

	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}

	public int getExpense_amount() {
		return expense_amount;
	}

	public void setExpense_amount(int expense_amount) {
		this.expense_amount = expense_amount;
	}

	public String getExpense_bank() {
		return expense_bank;
	}

	public void setExpense_bank(String expense_bank) {
		this.expense_bank = expense_bank;
	}

	@Override
	public String toString() {
		return "Expense [expense_id=" + expense_id + ", expense_type=" + expense_type + ", expense_amount="
				+ expense_amount + ", expense_bank=" + expense_bank + "]\n";
	}

}