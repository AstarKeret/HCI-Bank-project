package model;

public class Employee extends Person{
	public enum Type {Manager, Banker};
	private Type type;
	
	public Employee(String firstName, String surName, String userName, String password, Type type) {
		super(firstName, surName, userName, password);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
