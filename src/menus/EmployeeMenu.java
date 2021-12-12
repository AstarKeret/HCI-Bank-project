package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.Main;
import model.Employee;
import usecases.ShowAccount;
import usecases.ShowCustomer;

public class EmployeeMenu {
	public static Scanner data = Main.data;
	public static void run(Employee employeeLogin) {
		boolean flag=false;	
	do {
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		
		System.err.println("Welcome to Plutus Employee Menu\n");
		System.out.println("Select one of the displayed options and enter its number after the #\n");
		System.out.println("1. Select and show customer\n");// 1
		System.out.println("2. Select and show account\n");// 2
		System.out.println("3. Manager connection\n");// 3
		System.out.println("4. Logout\n");// 4
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		System.err.print("#  ");
			
		int select = 0;  // select
		boolean bSelect = false;
		while(!bSelect) {
			try{
				select = data.nextInt();
				if(select < 1 || select > 4)
					throw new InputMismatchException();
				bSelect = true;
			}catch (InputMismatchException e) {
				System.out.println("You must select one the options displayed(in digit)");
				 data.next();
			}
			
		}
		switch(select)
		{
		case (1):
			ShowCustomer showCustomer=new ShowCustomer();
			showCustomer.showAllCustomers();
			System.out.println("Please type in the customer number of the customer you want to expand details about");
			int selection= data.nextInt();
			showCustomer.showCustomerInfo(showCustomer.searchCustomer(selection));
			break;
		case (2):
			new ShowAccount().show(employeeLogin); // 	select an account data 
			break;
		case (3):
			switch(employeeLogin.getType())
			{
			case Manager:
				System.out.println("Welcome "+employeeLogin.getFirstName() + " " + employeeLogin.getSurName());
				System.out.println("You are logged in to a user authentication system");
				System.out.println("There are no users waiting for approval");
				break;
			case Banker:
				System.out.println("Access denied");
				break;
			   }
			break;
		case (4):
			flag = true;
			break;
		}
		}while(!flag);
	}
}
