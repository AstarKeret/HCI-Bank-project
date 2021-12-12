package usecases;

import main.ManagmentSystem;
import model.Customer;

public class ShowCustomer {
	ManagmentSystem manage = ManagmentSystem.getManager();

	public void showCustomerInfo(Customer customer) {

		try {
			System.out.println("First Name: " + customer.getFirstName());// print name
			System.out.println("Sur Name: " + customer.getSurName());// Show lastName
			System.out.println("ID: " + customer.getCustomerNumber());// Show Id
			System.out.println("Birthday: " + customer.getDOB());// show birthday
			System.out.println("Phone number: " + customer.getPhoneNumber());
			System.out.println("Account/s: ");
			for (int i = 0; i < customer.getAllAccounts().size(); i++) {
				System.out.println("Account # " + customer.getAllAccounts().get(i).getAccountNumber());
			}
			System.out.println("Total of: " + customer.getAllAccounts().size() + " accounts.");
		} catch (Exception e) {
			System.out.println("There is no such customer");
		}

	}

	public Customer searchCustomer(int customerNum) {// method will find the the desired customer according his/hers Id

		int numberOfCustomers = manage.getAllCustomer().size();
		for (int i = 0; i < numberOfCustomers; i++) {
			if (manage.getAllCustomer().get(i).getCustomerNumber() == customerNum)
				return manage.getAllCustomer().get(i);
		}

		return null;
	}

	public void showAllCustomers() {

		System.out.println("These are all the customers in the bank");
		for (int i = 0; i < manage.getAllCustomer().size(); i++) {
			System.out.print( manage.getAllCustomer().get(i).getFirstName() + " "	+ manage.getAllCustomer().get(i).getSurName());
			System.out.println(" Customer number:" + manage.getAllCustomer().get(i).getCustomerNumber());
		}
	}

}
