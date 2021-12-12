package transaction;

import java.util.Scanner;

import main.Main;

public class TransferMoney {
	public static Scanner scanner = Main.data;
	public final static String MY_ID = "afeka08";

	public static void transfer() {
		AccountBoundary destination = getDestinationDetails();
	double amount = -1;
		while(true){
			try {
			System.out.println("Amount to be transferred:");
			amount = scanner.nextDouble();
			if(amount <= 0)
				System.out.println("The amount to be transferred must be greater than 0");
			else
				break;
		}catch (Exception e) {
			System.out.println("The amount must be written in the digits");
			scanner.next();
		}
			}
		System.out.println("Enter a commant:");
		String commant = scanner.next();
		new TransactionCtrl().sendMoney(destination, amount, commant);

	}
	

	
	private static AccountBoundary getDestinationDetails() {
		String accountNumber, bankID, branch, name;
		while(true){
			System.out.println("Destination Details:\n\nEnter account number");
			accountNumber = scanner.next();
			System.out.println("Enter bank ID");
			bankID = scanner.next();
			System.out.println("Enter branch number");
			branch = scanner.next();
			
			System.out.println("Enter reciver name");
			name = scanner.next();
			if(accountNumber.isBlank()) {
				System.out.println("You must enter an account number");
				continue;
			}
			if(bankID.isBlank())
				System.out.println("You must enter a bank ID");
			else
				break;
		}
		return new AccountBoundary(accountNumber, bankID, branch, name);
		
	}
}
