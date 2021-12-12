package model;

import java.util.ArrayList;

public class Customer extends Person{
	public enum Gender {Female, Male};

	private int customerNumber;
	private Gender type;
	private String DOB;
	private String phoneNumber;
	private ArrayList<Account> allAccounts;
	IDGenerator d = IDGenerator.getInstance(0);

	public Customer(String firstName, String surName, String userName, String password , Gender type, String DOB, String phoneNumber) {
		super(firstName, surName, userName, password);
		this.customerNumber = d.nextId();
		this.type = type;
		this.DOB = DOB;
		this.phoneNumber = phoneNumber;
		allAccounts = new ArrayList<>();
	}

	public ArrayList<Account> getAllAccounts() {
		return allAccounts;
	}

	public void addAllAccount(Account account) {
		allAccounts.add(account);
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Gender getType() {
		return type;
	}

	public void setType(Gender type) {
		this.type = type;
	}
	
	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
