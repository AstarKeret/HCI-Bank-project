package main;

import java.util.ArrayList;

import model.Customer;
import model.Employee;

public class ManagmentSystem {
	private static ManagmentSystem manager = new ManagmentSystem();
	private ArrayList<Customer> allCustomer;
	private ArrayList<Employee> allEmployees;
	
	public ManagmentSystem() {
		allCustomer = new ArrayList<>();
		allEmployees = new ArrayList<>();
	}

	public static ManagmentSystem getManager() {
		return manager;
	}
	
	public ArrayList<Customer> getAllCustomer() {
		return allCustomer;
	}

	public void addAllCustomer(Customer customer) {
		allCustomer.add(customer);
	}

	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void addAllEmployees(Employee employees) {
		allEmployees.add(employees);
	}
	
	public Customer findCustomer(String userName,String pass) {
		Customer customer=null;
		for(int i = 0; i < allCustomer.size() ; i++)
			if(allCustomer.get(i).getUserName().trim().equals(userName.trim()) && allCustomer.get(i).getPassword().trim().equals(pass.trim()))
				return allCustomer.get(i);
			
		
		return customer;
	}
	public Employee findEmployee(String userName,String pass) {
		Employee employee=null;
		for(int i = 0; i < allEmployees.size() ; i++)
			if(allEmployees.get(i).getUserName().trim().equals(userName.trim()) && allEmployees.get(i).getPassword().trim().equals(pass.trim()))
				return allEmployees.get(i);
		
		return employee;
		}

}
