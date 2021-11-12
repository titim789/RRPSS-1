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

/**
 * This class is used to manage the customer objects.
 * @author Ng Li Wang
 */
public class CustomerMgr{

	/**
	 * This is a static list of customer objects.
	 */
	private static ArrayList<Customer> listOfCustomer;
	
	/**
	 * This is the constructor of the class.
	 */
	public CustomerMgr() {
		load();
	}

	/**
	 * This method is used to display the list of customers in current list of customers.
	 * @param customer
	 */
	// pass in an ArrayList<Customer> and display all customers in the list
	public void displayCustomerList() {
		System.out.println(String.format("|%-10s", "ID")
		+"|"+String.format("%-20s", "Customer Name")
		+"|"+String.format("%-20s", "Phone")
		+"|"+String.format("%-10s", "Member?")
		);

		for (Customer customer : listOfCustomer) {
			String member = "";
			if (customer.isMember()) {
				member = "yes";
			} else {
				member = "no";
			}
			System.out.println(String.format("|%-10s", customer.getCustomerId())
			+"|"+String.format("%-20s", customer.getName())
			+"|"+String.format("%-20s", customer.getPhone())
			+"|"+String.format("%-20s", member));		
		}
	}
	

	/**
	 * Get user input to about new customer to be added
	 */
	// function to add customer object to list of customer
	public void addCustomerOption() {
		// int customerId, String name, String phone, String member

		int customerId = getLastCustomerId() + 1;
		System.out.println("Customer Id to insert:" + customerId);

		CustomerUI customerui = new CustomerUI();

		String name = customerui.getCustomerName();
		String phone = customerui.getCustomerPhone();				
		String member = customerui.getCustomerMember();

		addCustomer(customerId, name, phone, member);
	}
	

	/** 
	 * This method is used to add a new customer to the static list of customers.
	 * @param customerId the customer id of the new customer
	 * @param name 	the name of the new customer
	 * @param phone	the phone number of the new customer
	 * @param member whether the new customer is a member or not
	 */
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

	/**
	 * This method is to get the customer ID to be removed
	 * @param customerId the customer id of the customer to be removed
	 */
	public void removeCustomerOption(){
		CustomerUI customerui = new CustomerUI();
		int customerIdToRemove = customerui.getRemoveId();
		removeCustomer(customerIdToRemove);
	}

	/**
	 * This method is used to remove a new customer based on ID passed in
	 * @param customerId the customer id of the customer to be removed
	 */
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

	/** 
	 * returns the last customer id in the list
	 * @return int
	 */
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
	
	/** 
	 * pass in int customerId check if exist in the ArrayList Customer
	 * @param customerId
	 * @return boolean
	 */
	// pass in int customerId check if exist in the ArrayList Customer
	public boolean isCustomerExist(int customerId) {
		for (Customer customer : listOfCustomer) {
			if (customer.getCustomerId() == customerId) {
				return true;
			}
		}
		return false;
	}

		/** 
	 * pass in an CustomerId integer and return the customer object
	 * @param customerId
	 * @return Customer
	 */
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
	
	/**
	 *  pass in customerId and returns customer phone attribtue
	 * @param customerId
	 * @return String
	 */
	// pass in customerId and returns customer phone attribtue
	public String getCustomerPhone(int customerId) {
		for (Customer customer : listOfCustomer) {
			if (customer.getCustomerId() == customerId) {
				return customer.getPhone();
			}
		}
		return null;
	}

	
	/** 
	 * pass in customerId and returns customer name attribtue
	 * @param customerId
	 * @return String
	 */
	// pass in customerId and returns customer name attribute
	public String getCustomerName(int customerId) {
		for (Customer customer : listOfCustomer) {
			if (customer.getCustomerId() == customerId) {
				return customer.getName();
			}
		}
		return null;
	}


	/**
	 * save the customer list to a list of customer database file
	 */
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

	/**
	 * load the customer list from a list of customer database file
	 */
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
	
}
