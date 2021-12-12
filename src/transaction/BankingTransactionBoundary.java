package transaction;

import java.util.Date;

public class BankingTransactionBoundary {
	private AccountBoundary source;
	private AccountBoundary destination;
	private String comment;
	private Date timestamp;
	private double amount;
	
	public BankingTransactionBoundary() {
		
	}
	
	public BankingTransactionBoundary(AccountBoundary source, AccountBoundary destination, String comment, double amount) {
		this.source = source;
		this.destination = destination;
		this.comment = comment;
		this.timestamp = new Date();
		this.amount = amount;
	}
	
	public AccountBoundary getSource() {
		return source;
	}
	public void setSource(AccountBoundary source) {
		this.source = source;
	}
	public AccountBoundary getDestination() {
		return destination;
	}
	public void setDestination(AccountBoundary destination) {
		this.destination = destination;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDateStamp() {
		return timestamp;
	}
	public void setDateStamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
