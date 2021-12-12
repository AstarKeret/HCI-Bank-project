package transaction;

import java.util.ArrayList;

import main.Login;
import main.Main;
import main.ManagmentSystem;
import menus.CustomerMenu;
import model.Account;
import model.Customer;
import model.Transaction;

public class TransactionCtrl {
	public final static String MY_ID = "afeka08";
	private Account account;

	public void receivingMoney(BankingTransactionBoundary trans) {
		Account destination = searchAccount(trans.getDestination().getAccountNumber());
		if(destination != null){
			destination.setBalance(destination.getBalance() + trans.getAmount());	//update amount
			destination.addTransactions(new Transaction(trans.getSource(), trans.getComment(), trans.getDateStamp(), trans.getAmount()));	//add transaction
		}
		else 
			sendMoney(new BankingTransactionBoundary(trans.getDestination(), trans.getSource(), "The requested account was not found", trans.getAmount()));	//notify
		}

	private Account searchAccount(String accountNumber) {
		ArrayList<Customer> allCustomer = ManagmentSystem.getManager().getAllCustomer();
		for(int i = 0; i < allCustomer.size() ; i ++) 
			for(int j = 0 ; j < allCustomer.get(i).getAllAccounts().size() ; j++) 
				if(allCustomer.get(i).getAllAccounts().get(j).getAccountNumber().equals(accountNumber))
					return allCustomer.get(i).getAllAccounts().get(j);
		return null;
	}
	
	public void sendMoney(AccountBoundary destination, double amount, String commant) {
		Customer tmp = Login.getCustomerLogin();
		account = CustomerMenu.getAccountLogin();
		
		if(account.getBalance() < amount) {	//check balance
			System.out.println("Sorry, you do not have enough money in your account to transfer this amount");
			return;
		}
		AccountBoundary source = new AccountBoundary(account.getAccountNumber(), MY_ID, " ", tmp.getFirstName() + " " + tmp.getSurName());
		sendMoney(new BankingTransactionBoundary(source, destination, commant, amount));

	}
	
	public Boolean sendMoney(BankingTransactionBoundary trans) {
		try (TransactionSession ts = new TransactionSession(MY_ID, Main.arg)){
			ts.sendMoney(trans);
			if(!trans.getComment().equals("The requested account was not found")) {
				account.setBalance(account.getBalance() - trans.getAmount());	//update account
				account.addTransactions(new Transaction(trans.getDestination(), trans.getComment(), trans.getDateStamp(), trans.getAmount() * -1));
			}
			System.err.println("Money transfer was successful");
		}catch (Exception e) {
			System.err.println("Money transfer failed");
		}
		return false;
	}
}
