package customer;

import java.io.Serializable;

/**
 * Customer class consist of attribtues and methods of a customer object
 * @author Ng Li Wang
 */
public class Customer implements Serializable{
	/**
	 * customer id of this customer object
	*/
	private int customerId;

	/**
	 * customer name of this customer object
	*/
	private String name;
	
	/**
	 * phone number of this customer object
	*/
	private String phone;

	/**
	 * boolean value of whether this customer object is a member
	 */
	private boolean member;
	
	/**
	 * Constructor of Customer class
	*/
	public Customer() {}
	
	/**
	 * Constructor of Customer class
	 * @param customerId pass in customer id (int) of a new customer object
	 * @param name pass in name (string) of a new customer object
	 * @param phone pass in phone(string) of a new customer object
	 * @param member pass in member(boolean) of a new customer object
	 */
	public Customer(int customerId, String name, String phone, boolean member) {
		// TODO - implement Staff.Staff
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
		this.member = member;
		throw new UnsupportedOperationException();
	}
	
	
	/** 
	 * Getter method of boolean value of whether customer is member or not
	 * @return boolean returns T/F value if whether a customer is a member
	 */
	public boolean isMember() {
		return member;
	}

	
	/** 
	 * Setter method for whether a customre is member or not
	 * @param member pass in a boolean value to set a customer as a member
	 */
	public void setMember(boolean member) {
		this.member = member;
	}

	
	/** 
	 * getter method of customer name
	 * @return String returns a customer object's name
	 */
	public String getName() {
		return name;
	}

	
	/** 
	 * Setter method for customer name
	 * @param name pass in a string value to set a customer object's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * getter method of customer phone number
	 * @return String returns a customer object's phone number
	 */
	public String getPhone() {
		return phone;
	}

	
	/** 
	 * Setter method for customer phone number
	 * @param phone pass in a string value to set a customer object's phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	/** 
	 * getter method of customer id
	 * @return int returns a customer object's id
	 */
	public int getCustomerId() {
		return this.customerId;
	}

	
	/** 
	 * Setter method for customer id
	 * @param customerId pass in an int value to set a customer object's id
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
