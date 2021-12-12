package usecases;

import java.util.*;

import main.Main;
import main.ManagmentSystem;
import model.Account;
import model.Customer;
import model.Employee;
import model.Person;
import model.Transaction;
import transaction.AccountBoundary;

public class ShowAccount {
	public final String BANK_ID = "afeka08";
	public Scanner s = Main.data;
	public void showAccount(Account account) {
		try {
			System.out.println("Customer name: "+ getcustomerName(account.getAccountNumber()));
			System.out.println("Total balance- " + account.getBalance());
			System.out.println("Opened on- " + account.getOpenDate().toString());
			if (account.getTransactions().size() > 0)
				System.out.println("All account transactions: ");
			for (int i = 0; i < account.getTransactions().size(); i++) {
				Transaction getTransaction = account.getTransactions().get(i);
				showTransaction(getTransaction, account);
			}
		} catch (Exception e) {
			System.err.println("There is no such account");
		}

	}

	public void showTransaction(Transaction trans, Account account) {
		if (trans.getAmount() < 0) {
			System.out.println("Transaction source:");
			System.out.println("BankId- " + BANK_ID);
			System.out.println("Account- " + account.getAccountNumber());

			System.out.println("Transaction destination:");
			showAccontBoundary(trans.getOtherPerson());
		} else {
			System.out.println("Transaction source:");
			showAccontBoundary(trans.getOtherPerson());

			System.out.println("Transaction destination:");
			System.out.println("BankId- " + BANK_ID);
			System.out.println("Account-" + account.getAccountNumber());

		}

		System.out.println("Transaction amount- " + trans.getAmount());
		System.out.println("Comment-" + trans.getComment());
		System.out.println("Transation date:" + trans.getTimestamp());

	}

	public void showAccontBoundary(AccountBoundary boundary) {
		System.out.println("Account number- " + boundary.getAccountNumber());
		System.out.println("BankID- " + boundary.getBankID());

	}

	public Account searchAccount(String accountNum, Object o) {
		ManagmentSystem manage = ManagmentSystem.getManager();
		if (o instanceof Employee) {
			for (int i = 0; i < manage.getAllCustomer().size(); i++) {
				for (int j = 0; j < manage.getAllCustomer().get(i).getAllAccounts().size(); j++) {
					if (accountNum.equals(manage.getAllCustomer().get(i).getAllAccounts().get(j).getAccountNumber()))
						return manage.getAllCustomer().get(i).getAllAccounts().get(j);

				}
			}
		} else {
			Customer c = (Customer) o;
			for (int i = 0; i < c.getAllAccounts().size(); i++) {
				if (c.getAllAccounts().get(i).getAccountNumber().equals(accountNum))
					return c.getAllAccounts().get(i);
			}

		}

		return null;
	}

	private String getcustomerName(String accountNum) {
		ManagmentSystem manage = ManagmentSystem.getManager();
		for (int i = 0; i < manage.getAllCustomer().size(); i++) {
			for (int j = 0; j < manage.getAllCustomer().get(i).getAllAccounts().size(); j++) {
				if (manage.getAllCustomer().get(i).getAllAccounts().get(j).getAccountNumber().equals(accountNum))
					return manage.getAllCustomer().get(i).getFirstName() + " " + manage.getAllCustomer().get(i).getSurName();

			}

		}
		return null;
	}

	public Account show(Person o) {// primaryMethod returns the account it is showing at the moment
		Account account = null;
		ManagmentSystem manage = ManagmentSystem.getManager();
		try {
			if (o instanceof Employee) {
				int accountCount = 0;
				System.out.println("This are all the accounts in the bank:");
				for (int i = 0; i < manage.getAllCustomer().size(); i++) {
					for (int j = 0; j < manage.getAllCustomer().get(i).getAllAccounts().size(); j++) {

						System.out.println( "Account number: "
								+ manage.getAllCustomer().get(i).getAllAccounts().get(j).getAccountNumber());
						accountCount++;
					}

				}
				if(accountCount==0)
					System.out.println("There is no accounts in the bank");
				else {
				System.out.println("Please type in the account number to display");
				String accountNum = s.next();
				account = searchAccount(accountNum, o);
				showAccount(account);
				}

			} else {
				String choice = "";
				Customer c = (Customer) o;
				if (c.getAllAccounts().size() > 1) {
					System.out.println("You have multiple accounts, the accounts numbers are: ");
					for (int i = 0; i < c.getAllAccounts().size(); i++) {
						System.out.println("Account number: " + c.getAllAccounts().get(i).getAccountNumber());
					}

					do {
						System.out.println("please type the number of the account you show");
						String accountNum = s.next();
						account = searchAccount(accountNum, o);
						showAccount(account);
						System.out.println("Do you want to display another account? y/n");
						choice = s.next();

					} while (choice.equalsIgnoreCase("y"));
					return account;
				} else if (c.getAllAccounts().size() == 1) {
					account = c.getAllAccounts().get(0);
					showAccount(account);
				} else
					System.out.println(" No accounts exists");

			}

		} catch (Exception e) {
			System.err.println("Object must be Employee or Customer");
		}
		return account;

	}

}
