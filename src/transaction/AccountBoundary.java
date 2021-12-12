package transaction;

public class AccountBoundary {
	private String accountNumber;
	private String bankID;
	private String branch;
	private String customerName;
	
	public AccountBoundary() {
	}

	public AccountBoundary(String accountNumber, String bankID, String branch, String customerName) {
		this.accountNumber = accountNumber;
		this.bankID = bankID;
		this.branch = branch;
		this.customerName = customerName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
