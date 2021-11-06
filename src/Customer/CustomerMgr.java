package Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
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
	public CustomerMgr() {

	}

	public void init(){
		CustomerUI customerui = new CustomerUI();
				
		int choice;
		ListOfCustomer = loadCustomerList("customerList.txt");

		do {
			choice = customerui.mainMenu();
			switch (choice) {
			case 1:
				displayCustomerList(ListOfCustomer);
				break;
			case 2:
				// add customer
				int customerId = getLastCustomerId(ListOfCustomer) + 1;
				System.out.println("Customer Id to insert:" + customerId);
				
				// launch customerUI to get customer info
				String customerName = customerui.getCustomerName();
				String customerPhone = customerui.getCustomerPhone();
				String customrMember = customerui.getCustomerMember();

				// create new customer
				addCustomer(ListOfCustomer, customerId, customerName, customerPhone, customrMember);
				System.out.println("\nCustomer added..");
				displayCustomerList(ListOfCustomer);
				break;
			case 3:
				// remove customer object from the ArrayList of customer
				String customerIdToRemove = customerui.getRemoveId();
				removeCustomer(ListOfCustomer, customerIdToRemove);
				break;
			case 4:
				// removeCustomer();
				saveCustomer(ListOfCustomer, "customerList.txt");
				break;
			case 5:
				// saveCustomer();
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 5);

		
	}

	// load file name and return an ArrayList of Customer objects
	public ArrayList<Customer> loadCustomerList(String fileName) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			//to store a line
			String line = "";
			
			// to consume the header row of csv
			String headerLine = "";
			headerLine = br.readLine();
			
			// keeps instanciating staff object until no more rows
			while((line = br.readLine()) != null) {			
				// split a line of string into an array
				// [0] is id, [1] is name etc...
				String[] values = line.split(",");
				
				// takes the corresponding array[0], fit into staff object
				Customer customer = new Customer();
				int i = Integer.parseInt(values[0]);
				customer.setCustomer_id(i);
				customer.setName(values[1]);
				customer.setPhone(values[2]);
				
				// if value[3] is y, set the boolean to true
				if(values[3].equals("y")) {
					customer.setMember(true);
				}
				else {
					customer.setMember(false);
				}
				
				// append this customer object into the the array list of staff
				customerList.add(customer);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;
	}

	// pass in an ArrayList<Customer> and display all customers in the list
	public void displayCustomerList(ArrayList<Customer> customerList) {
		System.out.printf("CustId\tName\tPhone\t\tMember\n");
		for (Customer customer : customerList) {
			String member = "";
			if (customer.isMember()) {
				member = "y";
			} else {
				member = "n";
			}
			System.out.println(customer.getCustomer_id() + "\t" + customer.getName() + "\t" + customer.getPhone() + "\t" + customer.isMember());
		}
	}
	
	// function to add customer object to list of customer
	public void addCustomer(ArrayList<Customer> customerList, int customer_id, String name, String phone, String member) {
		Customer newCustomer = new Customer();
		newCustomer.setCustomer_id(customer_id);
		newCustomer.setName(name);
		newCustomer.setPhone(phone);
		if(member.equals("y")) {
			newCustomer.setMember(true);
		}
		else {
			newCustomer.setMember(false);
		}
		customerList.add(newCustomer);
	}

	// returns the last customer id in the list
	public int getLastCustomerId(ArrayList<Customer> customerList) {
		int lastCustomerId = 0;
		for (Customer customer : customerList) {
			if (customer.getCustomer_id() > lastCustomerId) {
				lastCustomerId = customer.getCustomer_id();
			}
		}
		return lastCustomerId;
	}

	// remove customer object from the list of customer, store into a temp ArrayList if customer id is not CustomerIdemoval
	public void removeCustomer(ArrayList<Customer> customerList, String customerIdToRemove) {
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		for (Customer customer : customerList) {
			if (customer.getCustomer_id() != Integer.parseInt(customerIdToRemove)) {
				tempList.add(customer);
			}
		}
		customerList.clear();
		customerList.addAll(tempList);

		System.out.println("Staff removed..");
	}


	// save customer list to csv file
	public void saveCustomer(ArrayList<Customer> customerList, String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(fileName));
			pw.print("");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			// write header row
			bw.write("CustomerId,Name,Phone,Member");
			bw.newLine();
			
			// write each customer object into the file
			for (Customer customer : customerList) {
				String member = "";
				if (customer.isMember()) {
					member = "y";
				} else {
					member = "n";
				}
				bw.write(customer.getCustomer_id() + "," + customer.getName() + "," + customer.getPhone() + "," + member);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
