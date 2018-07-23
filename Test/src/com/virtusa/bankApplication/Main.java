package com.virtusa.bankApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		//BankStatement object1 = null;
//		String date="12-03-2017";
//		SimpleDateFormat date1=new SimpleDateFormat("dd-mm-yyyy");
//		Date date2 =date1.parse(date); 
//        try
//        {
//        	BankStatement si = new BankStatement("1234",date2,100,20,200,150,4321,"abcd");
//            FileOutputStream fos = new FileOutputStream("file1.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(si);
//            System.out.println("serialized");
//            oos.close();
//            fos.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
		
	        // Deserialization
//	        try
//	        {   
//	            // Reading the object from a file
////	        	 ArrayList<BankStatement> arraylist = null;
//	           
//	            ObjectInputStream in = new ObjectInputStream(new FileInputStream("ach1.txt"));
//	            object1 = (BankStatement)in.readObject();
////	           
//	            System.out.println("Object has been deserialized ");
//	            System.out.println(object1.getAccountNumber()+" "+object1.getCredits());
//
//	        }
//	        catch(IOException ex)
//	        {
//	            System.out.println("IOException is caught");
//	            ex.printStackTrace();
//	        }
		Operations operation=new Operations();
operation.readAchFile();
	System.out.println("success");
	
//	
	}
}
//}
