package usecases;

import java.util.ArrayList;

import model.Account;
import model.Customer;

public class CloseAccount {

	public static boolean closeAccount(Customer customer, String accountNumber) {

		ArrayList<Account> accounts = customer.getAllAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
				accounts.remove(i);
				return true;

			}

		}
		return false;
	}

}
