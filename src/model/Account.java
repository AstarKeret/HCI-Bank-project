package model;

import java.util.ArrayList;
import java.util.Date;

public class Account {
	private String accountNumber;
	private double balance;
	private Date openDate;
	private ArrayList<Transaction> transactions;
	IDGenerator d = IDGenerator.getInstance(1);

	public Account(double balance) {
		this.balance = balance;
		accountNumber = "" + d.nextId();
		openDate = new Date();
		transactions = new ArrayList<>();
	}
	public Account() {
		this(0);
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public void addTransactions(Transaction transaction) {
		transactions.add(transaction);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
}
