package usecases;

import java.util.ArrayList;

import main.ManagmentSystem;
import model.Customer;
import model.Employee;

public class CreateNewCustomer extends Customer {
	public CreateNewCustomer(String firstName, String surName, String userName, String password, Gender type,
			String DOB, String phoneNumber) {
		super(firstName, surName, userName, password, type, DOB, phoneNumber);

	}

	private boolean searchManager() {

		ArrayList<Employee> employees = ManagmentSystem.getManager().getAllEmployees();

		for (Employee employee : employees) {
			if (employee.getType() == Employee.Type.Manager)
				return true;
		}

		return false;

	}

	public boolean registerCustomer() {
		if (searchManager()) {
			ManagmentSystem.getManager().addAllCustomer(this);
			return true;
		}

		return false;

	}

}
