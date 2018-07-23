package com.virtusa.BankProcess;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author delegate
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operations operations=new Operations();
		
		String mainString=operations.readAchFile();
		operations.gettingInfo(mainString);
		Response response=operations.validateTransaction();
		operations.writeAchrFile();
}

	}


