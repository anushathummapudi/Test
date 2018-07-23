package com.virtusa.bankapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.virtusa.bankapp.Operations;

public class GeneratingStatement {

	public static void main(String[] args) throws ClassNotFoundException, ParseException {

		Operations operation = new Operations();
		operation.readAchFile();
		System.out.println("success");
		System.out.println("hello");
	}
}
