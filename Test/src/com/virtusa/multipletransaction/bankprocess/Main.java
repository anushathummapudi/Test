package com.virtusa.multipletransaction.bankprocess;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Operations operations = new Operations();
        String[] transactionInfo = operations.readAchFile();
		operations.gettingInfo(transactionInfo);
		ArrayList<Response> response = operations.validateTransaction(transactionInfo);
		operations.writeAchrFile(response);
	}
}
