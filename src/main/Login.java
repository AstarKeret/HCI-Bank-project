
package main;
import java.util.ArrayList;
import java.util.Scanner;

import menus.CustomerMenu;
import menus.EmployeeMenu;
import model.Customer;
import model.Customer.Gender;
import model.Employee;
import usecases.CreateNewCustomer;


public class Login {

	static String userName; 
	static String password;
	static Scanner data = Main.data;  // Create a Scanner object
	static Customer customerLogin= null;
	static Employee EmployeeLogin= null;
	public static Boolean start(int select)//  Infinity=true => back to main menu
	{	
		
		try {
			switch(select)
			{
			case(1): // Customer login
				do
					{
					System.out.println("Enter username");
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					System.err.print("#  ");
					userName = data.next();  // Read user input
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					System.out.println("Enter password");
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					System.err.print("# ");
					password = data.next();  // Read password input
					System.out.println("Working");
					printP ();
					customerLogin=ManagmentSystem.getManager().findCustomer(userName,password);
					System.out.println(customerLogin.getFirstName());
					}while (customerLogin== null);  // try 3 times or 
				
				if(customerLogin!= null)
					CustomerMenu.run(customerLogin);
				else
					System.err.println("Beack to home page");
				return true;
			
			case(2): //open Customer
				String tmpUserName = null, tmpPassword;
				System.out.println( "The Fourth Circle of Hell - for the Stingy and wasteful\n");
				System.out.println("Please enter your first Name");
				String firstName=data.next();
				System.out.println("Please enter your sur name");
				String surName=data.next();
				boolean user = false;
				while(true) {
					if(!user) {
						System.out.println("\nPlease enter a username");
						tmpUserName=data.next();
		
						if(!checkUserName(tmpUserName))
							continue;
						user = true;
					}
					System.out.println("Please enter a password");
					tmpPassword=data.next();
					if(checkPassword(tmpPassword))
						break;
					
				}	
			
				char choice;
				Gender gender;
				while(true) {
					System.out.println("Please enter a Gender M/F");
					choice = data.next().charAt(0);
					if(choice == 'f' || choice == 'F') {
						gender = Gender.Female;
						break;
					}
					else if(choice == 'm' || choice == 'M') {
						gender = Gender.Male;
						break;
					}
					
				}
			
				System.out.println("Please enter a DOB");
				String DOB=data.next();
				System.out.println("Please enter a phone Number");
				String phoneNumber=data.next();
				
				CreateNewCustomer createNewCustomer = null;
				createNewCustomer=new CreateNewCustomer(firstName, surName, tmpUserName, tmpPassword, gender, DOB, phoneNumber);
				if(createNewCustomer.registerCustomer()) {
					System.out.println("Welcome "+firstName+" "+surName+ " to Plutus"); 
				}
				return true;

		
			case(3):
			 	int exit2=0;
				do{
					System.out.println("Enter username");
					userName = data.next();  // Read user input
					System.out.println("Enter password");
					password = data.next();  // Read password input
					System.out.println("Working");
					printP ();
					exit2++;
					EmployeeLogin=ManagmentSystem.getManager().findEmployee(userName,password);
				}while (EmployeeLogin== null && exit2<=3);	
				if (EmployeeLogin!= null)
					EmployeeMenu.run(EmployeeLogin);
				System.err.println("Beack to home page");
				return true;
		
			}
		} catch (Exception e) {
			return true;
		} 
		return true;

	}

	private static boolean checkPassword(String password) {
		for(int i = 0 ; i  < password.length() ; i++)
			if(password.charAt(i) >= 'A' &&  password.charAt(i) <= 'Z')
				return true;
			
		System.out.println("Password must include at least one capital letter");
		return false;
	}

	private static boolean checkUserName(String userName) {
		ArrayList<Customer> customers = ManagmentSystem.getManager().getAllCustomer();
		ArrayList<Employee> employees = ManagmentSystem.getManager().getAllEmployees();
		String tube = "{,'//\\\\&$@^~-|+=}.";
		for(int i = 0 ; i  < tube.length() ; i++)
			if(userName.contains(tube.charAt(i) +"")) {
				System.out.println("Username can't include one of flowing " + tube);
				return false;
			}
		
		for(int i = 0 ; i < customers.size() ; i++)
			if(customers.get(i).getUserName().equals(userName)) {
				System.out.println("Username " + userName + " already exist");
				return false;
			}
		
		for(int i = 0 ; i < employees.size() ; i++)
			if(employees.get(i).getUserName().equals(userName)) {
				System.out.println("Username " + userName + " already exist");
				return false;
			}
		return true;
	}

	public static void printP ()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.print(".");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}

public static Customer getCustomerLogin() {
	return customerLogin;
}

public static Employee getEmployeeLogin() {
	return EmployeeLogin;
}

}
