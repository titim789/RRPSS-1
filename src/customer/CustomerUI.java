package customer;

import java.util.Scanner;

/**
 * This class is the UI for the customer, for capturing user input for staff details and passing it to the customerMgr class
 * 
 * @author Marcus
 * @version 1.0
 */
public class CustomerUI {

	// empty constructor
	/**
	 * This is the constructor for the CustomerUI class
	 */
	public CustomerUI() {}


	/** 
	 * This method is used to display the menu for the customer
	 * @return String - the customer's name
	 */
	public String getCustomerName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Name");
		String name = sc.next();
		name += sc.nextLine();
		return name;
	}
	
	
	/** 
	 * This method is used ask user for phone number of new customer object
	 * @return String
	 */
	public String getCustomerPhone() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter Customer Phone");
		String phone = sc2.next();
		return phone;
	}
	
	
	/** 
	 * This method is used to ask user whether new customer object is member or not
	 * @return String
	 */
	public String getCustomerMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("is customer member y/n");
		String member = sc.next();
		return member;
	}
	
	
	/**
	 * This method is to ask user for the ID of customer object to be removed 
	 * @return int
	 */
	public int getRemoveId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer id to remove");
		int id = sc.nextInt();
		return id;
	}
    
    
}
