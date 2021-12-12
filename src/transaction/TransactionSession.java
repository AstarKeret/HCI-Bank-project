package transaction;

import p2p.banking.BankingInterchange;

public class TransactionSession implements AutoCloseable{
	private String myID;
	private TransactionCtrl ctrl;
	private BankingInterchange<BankingTransactionBoundary> interchange;

	public TransactionSession(String myID, String... config) {
		super();
		ctrl = new TransactionCtrl(); 
		this.myID = myID;
		this.interchange = new BankingInterchange<BankingTransactionBoundary>(this.myID, config, this::handleMessage, new BankingTransactionBoundary());
	}

	public void sendMoney(BankingTransactionBoundary trans) {
		this.interchange.sendBankingTransaction(trans);
	}

	
	@Override
	public void close() throws Exception {
		this.interchange.close();		
	}

	public void handleMessage (BankingTransactionBoundary trans) {
		System.err.println("innn");
		if (trans.getDestination().getBankID().equals(this.myID)) 
			ctrl.receivingMoney(trans);
	}

}


