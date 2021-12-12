package menus;
import java.util.Scanner;

import main.Main;
import model.Account;
import transaction.TransferMoney;
import usecases.ShowAccount;

public class AccountMenu {
	public static Scanner data = Main.data;
	static void run(Account accountLogin)// After Login
	{
		boolean flag=false;	
		do {
		System.err.println("\nWelcome to Account " + accountLogin.getAccountNumber());
		System.out.println("\nSelect one of the displayed options and enter its number after the #\n");
		System.out.println("1. Show my data \n");// 1
		System.out.println("2. Transaction \n");// 2
		System.out.println("3. Beck\n");// 3
		System.err.print("#  ");
		
		int select = data.nextInt();  // select
		
		switch(select)
		{
		case (1):
			new ShowAccount().showAccount(accountLogin);
			break;
		case (2):
			TransferMoney.transfer();
			break;
		case (3):
			flag=true;
			break;
		}
		}while(flag==false);
	}
}
