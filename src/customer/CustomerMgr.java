package customer;

import java.io.File;
import java.io.FileInputStream;

import menu.MenuItem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.String;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;

public class CustomerMgr{

	private static ArrayList<Customer> listOfCustomer;
	
	public CustomerMgr() {
		load();
	}

	public void init(){
		CustomerUI customerui = new CustomerUI();
				
		int choice;
		do {
			choice = customerui.mainMenu();
			switch (choice) {
			case 1:
				displayCustomerList();
				break;
			case 2:
				// add customer
				int customerId = getLastCustomerId() + 1;
				System.out.println("Customer Id to insert:" + customerId);
				
				// launch customerUI to get customer info
				String customerName = customerui.getCustomerName();
				String customerPhone = customerui.getCustomerPhone();
				String customrMember = customerui.getCustomerMember();

				// create new customer
				addCustomer(customerId, customerName, customerPhone, customrMember);
				System.out.println("\nCustomer added..");
				displayCustomerList();
				break;
			case 3:
				// remove customer object from the ArrayList of customer
				int customerIdToRemove = customerui.getRemoveId();
				removeCustomer(customerIdToRemove);
				break;
			case 4:
				// removeCustomer();
				// saveCustomerList("customerList.txt");
				System.out.println("Returning to main menu..");

				break;
			default:
				System.out.println("Invalid choice, return to main menu..");
				break;
			}
		} while (choice != 4);

		
	}

	// pass in an ArrayList<Customer> and display all customers in the list
	public void displayCustomerList() {
		System.out.printf("CustId\tName\tPhone\t\tMember\n");
		for (Customer customer : listOfCustomer) {
			String member = "";
			if (customer.isMember()) {
				member = "y";
			} else {
				member = "n";
			}
			System.out.println(customer.getCustomerId() + "\t" + customer.getName() + "\t" + customer.getPhone() + "\t" + customer.isMember());
		}
	}
	
	// function to add customer object to list of customer
	public void addCustomer(int customerId, String name, String phone, String member) {
		Customer newCustomer = new Customer();
		newCustomer.setCustomerId(customerId);
		newCustomer.setName(name);
		newCustomer.setPhone(phone);
		if(member.equals("y")) {
			newCustomer.setMember(true);
		}
		else {
			newCustomer.setMember(false);
		}
		listOfCustomer.add(newCustomer);
	}

	// returns the last customer id in the list
	public int getLastCustomerId() {
		int lastCustomerId = 0;
		for (Customer customer : listOfCustomer) {
			if (customer.getCustomerId() > lastCustomerId) {
				lastCustomerId = customer.getCustomerId();
			}
		}
		return lastCustomerId;
	}

	// remove customer object from the list of customer, store into a temp ArrayList if customer id is not CustomerIdemoval
	public void removeCustomer(int customerIdToRemove) {
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		for (Customer customer : listOfCustomer) {
			if (customer.getCustomerId() != customerIdToRemove) {
				tempList.add(customer);
			}
		}
		listOfCustomer.clear();
		listOfCustomer.addAll(tempList);

		System.out.println("Customer removed..");
		displayCustomerList();
	}


	// pass in an CustomerId integer and return the customer object
	public Customer getCustomerObj(int customerId) {
		Customer customer = new Customer();
		for (Customer c : listOfCustomer) {
			if (c.getCustomerId() == customerId) {
				customer = c;
			}
		}
		return customer;
	}

	public void save() {
		// TODO Auto-generated method stub
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("customerList.txt"));
			pw.print("");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("customerList.txt"));
			// write header row
			bw.write("CustomerId,Name,Phone,Member");
			bw.newLine();
			
			// write each customer object into the file
			for (Customer customer : listOfCustomer) {
				String member = "";
				if (customer.isMember()) {
					member = "y";
				} else {
					member = "n";
				}
				bw.write(customer.getCustomerId() + "," + customer.getName() + "," + customer.getPhone() + "," + member);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void load() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("customerList.txt"));
			//to store a line
			String line = "";
			
			// to consume the header row of csv
			String headerLine = "";
			headerLine = br.readLine();
			
			// keeps instanciating customer object until no more rows
			while((line = br.readLine()) != null) {			
				// split a line of string into an array
				// [0] is id, [1] is name etc...
				String[] values = line.split(",");
				
				// takes the corresponding array[0], fit into customer object
				Customer customer = new Customer();
				int i = Integer.parseInt(values[0]);
				customer.setCustomerId(i);
				customer.setName(values[1]);
				customer.setPhone(values[2]);
				
				// if value[3] is y, set the boolean to true
				if(values[3].equals("y")) {
					customer.setMember(true);
				}
				else {
					customer.setMember(false);
				}
				
				// append this customer object into the the array list of customer
				customerList.add(customer);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.listOfCustomer = customerList;
	}
	
	// public void load() {
	// 	// TODO - implement Menu.load
	// 	try{
	// 	    FileInputStream readData = new FileInputStream("customerList.txt");
	// 	    ObjectInputStream readStream = new ObjectInputStream(readData);
	// 	    ListOfCustomer = (ArrayList<Customer>) readStream.readObject();
	// 	    readStream.close();
	// 	    //System.out.println(listOfMenuItems.toString());
	// 	}catch (Exception e) {
	// 	    e.printStackTrace();
	// 	}
		
	// }
	
	// public void save() {
	// 	// TODO - implement Menu.save
	// 	try {
	// 	    FileOutputStream fos = new FileOutputStream("customerList.txt");
	// 	    ObjectOutputStream oos = new ObjectOutputStream(fos);   
	// 	    oos.writeObject(ListOfCustomer); // write List of customer to ObjectOutputStream
	// 	    oos.close(); 
	// 	} catch(Exception ex) {
	// 	    ex.printStackTrace();
	// 	}
	// }
}
