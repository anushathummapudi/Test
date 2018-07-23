package com.virtusa.bankapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.virtusa.bankApplication.Response;

public class Operations {
	String status = "declined";
	ArrayList<com.virtusa.bankapp.Response> dresponse = new ArrayList<com.virtusa.bankapp.Response>();
	ArrayList<BankStatement> bankStatement = new ArrayList<BankStatement>();
	ArrayList<com.virtusa.bankapp.Response> multipleResponse = new ArrayList<com.virtusa.bankapp.Response>();

	public void readAchFile() throws ClassNotFoundException {
		// ArrayList<Response> response=null;
		try {
			FileInputStream fileInputStream = new FileInputStream("ABC.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			bankStatement = (ArrayList) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
			
			ArrayList<com.virtusa.bankapp.Response> mulResponse1 = validateTransaction(bankStatement);
			if (mulResponse1.isEmpty()) {
				System.out.println("data declined");

			} else {
				// System.out.println(mulResponse1);
				writeAchrFile(mulResponse1);
			}

		} catch (IOException ex) {
			System.out.println("IOException is caught");
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}

	}

	public ArrayList<com.virtusa.bankapp.Response> validateTransaction(ArrayList<BankStatement> bankStatement) {

		// System.out.println(ob);
		for (BankStatement bankStatement1 : bankStatement) {
			com.virtusa.bankapp.Response response = new com.virtusa.bankapp.Response();
			if (bankStatement1.getCredits() < bankStatement1.getCreditLimit()) {
				// System.out.println(li);
				status = "Approved";

				response.setAccountNumber(bankStatement1.getAccountNumber());
				response.setTransactionId("TRA00" + bankStatement1.getAccountNumber().charAt(14)
						+ bankStatement1.getAccountNumber().charAt(15));
				response.setStatus(status);
				response.setDescription("Transaction is processed");
				multipleResponse.add(response);

			} else {
				status = "Declined";
				response.setAccountNumber(bankStatement1.getAccountNumber());
				response.setTransactionId("TRA00" + bankStatement1.getAccountNumber().charAt(14)
						+ bankStatement1.getAccountNumber().charAt(15));
				response.setStatus(status);
				response.setDescription("No amount available");
				multipleResponse.add(response);
			}
		}

		return multipleResponse;
	}

	public void writeAchrFile(ArrayList<com.virtusa.bankapp.Response> mulResponse1) {
		try {

			FileOutputStream fileOutputStream = new FileOutputStream("XYZ.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(mulResponse1);
			System.out.println("Response object is serialized");
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			FileInputStream fileOutputStream = new FileInputStream("XYZ.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);
			dresponse = (ArrayList) objectInputStream.readObject();
			System.out.println("Response object is deserialized");
			objectInputStream.close();
			fileOutputStream.close();
			for (com.virtusa.bankapp.Response response : dresponse)
				System.out.println(response.getAccountNumber() + " " + response.getTransactionId() + " "
						+ response.getStatus() + " " + response.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
