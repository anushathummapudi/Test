package com.virtusa.multipletransaction.bankprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;

public class Operations {
	String status;
	ArrayList<Response> mulResponse = new ArrayList<Response>();
	FileInputStream fileInputStream = null;
	BufferedReader bufferedReader = null;

	String[] transactionInfo = new String[20];
	char[] character = new char[40];
	int var = 0;
	int li = 0;
	long minimumAmtDue, credits, creditLimit, availableCredit, accountNumber;

	public String[] readAchFile() {
		try {
			fileInputStream = new FileInputStream("transactions.txt");
			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

			String line = bufferedReader.readLine();
			while (line != null) {
				transactionInfo[li] = line;

				System.out.println(transactionInfo[li]);
				line = bufferedReader.readLine();
				li++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionInfo;
	}

	public void gettingInfo(String[] transactionInfo) {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			System.out.println(transactionInfo[i]);

			accountNumber = Long.parseLong(transactionInfo[i].substring(0, 16));
			minimumAmtDue = Long.parseLong(transactionInfo[i].substring(16, 21));
			credits = Long.parseLong(transactionInfo[i].substring(21, 26));
			creditLimit = Long.parseLong(transactionInfo[i].substring(26, 31));
			availableCredit = Long.parseLong(transactionInfo[i].substring(31, 36));

			System.out.println(accountNumber);
			System.out.println(minimumAmtDue);
			System.out.println(credits);
			System.out.println(creditLimit);
			System.out.println(availableCredit);
		}
	}

	public ArrayList<Response> validateTransaction(String[] transactionInfo) {
		for (int li = 0; li < 5; li++) {
			Response response = new Response();
			accountNumber = Long.parseLong(transactionInfo[li].substring(0, 16));
			credits = Long.parseLong(transactionInfo[li].substring(21, 26));
			creditLimit = Long.parseLong(transactionInfo[li].substring(26, 31));
			availableCredit = Long.parseLong(transactionInfo[li].substring(31, 36));

			if (credits <= creditLimit && credits <= availableCredit) {
				status = "Approved";
				response.setTransactionId("TRA00" + (li + 1));
				response.setAccountNumber(accountNumber);
				response.setStatus(status);
				response.setDescription("Transaction is processing");

			} else {
				status = "Declined";
				response.setTransactionId("TRA00" + (li + 1));
				response.setAccountNumber(accountNumber);
				response.setStatus(status);
				response.setDescription("Credit Limit Crossed     ");
			}
			mulResponse.add(response);
			System.out.println(response);

		}

		System.out.println(mulResponse);
		return mulResponse;
	}

	public void writeAchrFile(ArrayList<Response> mulResponse) {
		try {
			File fout = new File("TraResponses.txt");
			FileOutputStream fos = new FileOutputStream(fout);

			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(fos));
			if (mulResponse.isEmpty()) {
				System.out.println("Sorry something wrong is happened");
			} else {
				for (int j = 0; j < mulResponse.size(); j++) {
					fw.write(mulResponse.get(j).getTransactionId());
					fw.write(Long.toString(mulResponse.get(j).getAccountNumber()));
					fw.write(mulResponse.get(j).getStatus());
					fw.write(mulResponse.get(j).getDescription());
					fw.newLine();
				}
				fw.close();
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
