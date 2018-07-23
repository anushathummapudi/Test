package com.virtusa.BankProcess;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Operations {
	long minimumAmtDue, credits, creditLimit, availableCredit, accountNumber;
	FileReader fr;
	String status = "Declined";
	char[] character = new char[40];
	String mainString, name;
	int amount;
	Response res = new Response();

	public String readAchFile() {
		try {
			fr = new FileReader("example.txt");
			int i;
			int var = 0;
			try {
				while ((i = fr.read()) != -1) {
					character[var] = (char) i;
					var++;
				}
				mainString = new String(character);
				System.out.println(mainString);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mainString;

	}

	public void gettingInfo(String mainString) {
		accountNumber = Long.parseLong(mainString.substring(0, 16));
		minimumAmtDue = Long.parseLong(mainString.substring(16, 21));
		credits = Long.parseLong(mainString.substring(21, 26));
		creditLimit = Long.parseLong(mainString.substring(26, 31));
		availableCredit = Long.parseLong(mainString.substring(31, 36));
		System.out.println(accountNumber);
		System.out.println(minimumAmtDue);
		System.out.println(credits);
		System.out.println(creditLimit);
		System.out.println(availableCredit);
		

	}

	public Response validateTransaction() {
//		Response res = new Response();
		if (credits <= creditLimit && credits <= availableCredit) {
			status = "Approved";
			res.setTransactionId("TRA001");
			res.setAccountNumber(accountNumber);
			res.setStatus(status);
			res.setDescription("Transaction is processing");

		} else {
			res.setTransactionId("TRA001");
			res.setAccountNumber(accountNumber);
			res.setStatus(status);
			res.setDescription("Credit Limit Crossed");
		}
		return res;
	}

	public void writeAchrFile() {
		try {
			FileWriter fw = new FileWriter("responsex.txt");
			fw.write(res.getTransactionId());
			fw.write(Long.toString(res.getAccountNumber()));
			fw.write(res.getStatus());
			fw.write(res.getDescription());
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
