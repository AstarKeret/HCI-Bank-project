package model;

import java.util.Date;

import transaction.AccountBoundary;

public class Transaction {
	private AccountBoundary otherPerson;
	private String comment;
	private Date timestamp;
	private double amount;
	
	public Transaction(AccountBoundary otherPerson, String comment, Date timestamp, double amount) {
		this.otherPerson = otherPerson;
		this.comment = comment;
		this.timestamp = timestamp;
		this.amount = amount;
	}
	
	public AccountBoundary getOtherPerson() {
		return otherPerson;
	}
	public void setOtherPerson(AccountBoundary otherPerson) {
		this.otherPerson = otherPerson;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}

