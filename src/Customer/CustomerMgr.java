package Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.lang.String;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;

public class CustomerMgr {
	private ArrayList<Customer> ListOfCustomer;
	
	private ReadCustomerList readCustomerList = new ReadCustomerList();
	
	public CustomerMgr() {
		ListOfCustomer = readCustomerList.readCustomerFromFile("customerList.txt");
	}
	
	public void displayCustomerList() {
		try {
			FileReader fr = new FileReader("customerList.txt");
			BufferedReader br = new BufferedReader(fr);
			//to store a line
			String line = "";
			System.out.println("Customer List");
			System.out.printf("CustId\tName\t\tPhone\t\tMember\n");
			// to consume the header row of csv
			String headerLine = "";
			headerLine = br.readLine();
			// keeps instanciating staff object until no more rows
			while((line = br.readLine()) != null) {			
				// split a line of string into an array
				// [0] is id, [1] is name etc...
				String[] values = line.split(",");
				
				String custid = values[0];
				String name = values[1];
				String phone = values[2];
				String member = values[3];
				System.out.printf("%s\t%s\t\t%s\t%s\n", custid, name, phone, member);
			}
			
		} 
		// catch blocks for reading csv or if not will throw error
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// catch IO exception for br.readline()
			e.printStackTrace();
		}
		}
	
	public void addCustomer() {
		// prompt for id, name, phone, etc
		// filewriter to append
		// re-load ListOfCustomer
		Scanner sc = new Scanner(System.in);
		
		// read the last customer id and increment
		int lastId = readCustomerList.readLastCustomerId("customerList.txt");
		int customer_id = ++lastId;
		
		// prompt user to enter customer name
		System.out.println("Enter the customer name:");
		String name = sc.next();
		
		// prompt user to enter customer phone
		System.out.println("Enter customer phone number:");
		String phone = sc.next();
		
		// prompt user to enter is it member
		System.out.println("Is it a member? y/n");
		String isMember = sc.next();
		
		// concat strings together
		String outputText = customer_id+","+name+","+phone+","+isMember;
		
		// read file
		File file1 = new File("customerList.txt");
		
		// initialise writer object, append new row using printwriter
		FileWriter fw = null;
		try {
			fw = new FileWriter(file1,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(outputText);
		pw.close();
		sc.close();
		displayCustomerList();
	}
	
	public void removeCustomer() {
		// prompt user to enter customer id to remove
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer id to remove:");
		String CustomerId = sc.next();
		
		String tempFile = "temp2.txt";
		
		File oldFile = new File("customerList.txt");
		File newFile = new File(tempFile);
		
		String currentline;
		String data[];
		
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader("customerList.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while((currentline = br.readLine())!= null) {
				data = currentline.split(",");
				if(!(data[0].equalsIgnoreCase(CustomerId))) {
					pw.println(currentline);
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
		
		  PrintWriter writer2 = null;
			try {
				writer2 = new PrintWriter(oldFile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			writer2.print("");
			writer2.close();
			
		  FileReader fin = new FileReader("temp2.txt");  
		  FileWriter fout = new FileWriter("customerList.txt", true);  
		  int c;  
		  while ((c = fin.read()) != -1) {  
		   fout.write(c);  
		  }  
//		  System.out.println("Copy finish...");  
		  displayCustomerList();
		  fin.close();  
		  fout.close();  
		  
		  PrintWriter writer = null;
			try {
				writer = new PrintWriter(tempFile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			writer.print("");
			writer.close();
			}
			catch(Exception e) {}
	}
	
}
