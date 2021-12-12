package usecases;
import model.Account;

public class OpenAccount {
	// open new Account and return
	public static Account openNewRequest() {
		return new Account();
	}
	
}
