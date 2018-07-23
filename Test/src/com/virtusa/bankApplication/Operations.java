package com.virtusa.bankApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Operations {
	String status="declined";
	Response res=new Response("435","6565",status,"fdgdfgfd");
	int val=0;
	BankStatement object1 = null;
public void readAchFile() throws ClassNotFoundException
{
	
	 try
     {   
         // Reading the object from a file
//    	 ArrayList<BankStatement> arraylist = null;
        FileInputStream fileInputStream=new FileInputStream("ACH.txt");
         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        object1=(BankStatement)objectInputStream.readObject();
        //System.out.println(res);
        Response res1=validateTransaction( object1,res);
      if(res1!=null) {
    	  System.out.println(res1);
        writeAchrFile(res1);
      }
//         
     }
     catch(IOException ex)
     {
         System.out.println("IOException is caught");
         ex.printStackTrace();
     }
     
}
public  Response validateTransaction(BankStatement ob,Response res)
{
	
	System.out.println(ob);
	if(ob.getCredits()<10000)
	{
		status="Approved";
		res.setAccountNumber(ob.getAccountNumber());
		res.setTransactionId("TRA001");
		
		res.setStatus(status);
		res.setDescription("your Transaction is processed");
	}
	else
	{
		res.setAccountNumber(ob.getAccountNumber());
		res.setTransactionId("TRA001");
		res.setStatus(status);
		res.setDescription("No amount available");
	}
	
	return res;
}
public void writeAchrFile(Response res1)
{
	try
  {
  	
      FileOutputStream fileOutputStream = new FileOutputStream("ACHR.txt");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(res1);
      System.out.println("serialized response object");
//      objectOutputStream.close();
//      fileOutputStream.close();
  }
  catch (Exception e)
  {
      e.printStackTrace();
  }
	
}

}
