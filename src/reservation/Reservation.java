package reservation;

import java.util.Calendar;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * A reservation entity is created when a customer makes a reservation with the restaurant.
 * It contains the customer's name and contact number, pax, table id, reservation id, and the time for which the reservation is made for
 * @author 
 *
 */
public class Reservation implements Serializable{

	/**
	 * The ID for this reservation
	 */
	private int reservationId;
	
	/**
	 * The ID of the table reserved
	 */
	private int tableId;
	
	/**
	 * The ID of the customer making the reservation
	 */
	private int customerId;
	
	/**
	 * The date and time of reservation
	 */
	private Calendar dateTime;

	/**
	 * The number of pax that the reservation is made for
	 */
	private int noOfPax;
	
	/**
	 * The name of the customer
	 */
	private String customerName;
	
	/**
	 * The contact number of the customer making the reservation
	 */
	private String contact;

	/**
	 * The format for date time to be used
	 */
	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy HH:mm");

	/**
	 * Constructor without parameters
	 */
	public Reservation(){}

	/**
	 * Creating a reservation when a customer makes a reservation
	 * @param reservationId The ID of the reservation to be made
	 * @param tableId The ID of the table for which the reservation is to be made for
	 * @param customerId The ID of the customer making the reservation
	 * @param dateTime The date time to reserve the table for
	 * @param noOfPax The number of pax for which the reservation is to be made for
	 * @param customerName The name of the customer making the reservation
	 * @param contact The contact number of the customer making the reservation
	 */
	public Reservation(int reservationId,int tableId,int customerId,Calendar dateTime,int noOfPax,String customerName,String contact) {
		this.reservationId = reservationId;
		this.tableId = tableId;
		this.customerId = customerId;
		this.dateTime = dateTime;
		this.noOfPax = noOfPax;
		this.customerName = customerName;
		this.contact = contact;
	}

	/**
	 * Gets the ID of this reservation
	 * @return This reservation's ID
	 */
	public int getReservationId() {
		return this.reservationId;
	}

	/**
	 * Sets the ID of this reservation
	 * @param reservationId The reservation ID to be set
	 */
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * Gets the ID of the table of this reservation
	 * @return The ID of the table of this reservation
	 */
	public int getTableId() {
		return this.tableId;
	}

	/**
	 * Sets the ID of the table for this reservation
	 * @param tableId The ID of the table of this reservation
	 */
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	/**
	 * Gets the ID of the customer for which this reservation was made
	 * @return The ID of the customer for which this reservation was made
	 */
	public int getCustomerId() {
		return this.customerId;
	}

	/**
	 * Sets the ID of the customer for which this reservation was made
	 * @param customerId The ID of the customer for which this reservation was made
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the date and time that the reservation is made for
	 * @return The date and time that the reservation is made for in a String format
	 */
	public String getDateTime() {
		Date date1 = dateTime.getTime();
		String strDate = sdf.format(date1);  
		return strDate;
	}

	/**
	 * Sets the date and time that the reservation is made for
	 * @param dateTime The date and time that the reservation is made for
	 */
	public void setDateTime(String dateTime){
		try{
			Date date = sdf.parse(dateTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			this.dateTime = cal;
		}catch(ParseException e){}
	}

	/**
	 * Gets the number of pax that this reservation is made for
	 * @return The number of pax that this reservation is made for
	 */
	public int getNoOfPax() {
		return this.noOfPax;
	}

	/**
	 * Sets the number of pax that this reservation is made for
	 * @param noOfPax The number of pax that this reservation is made for
	 */
	public void setNoOfPax(int noOfPax) {
		this.noOfPax = noOfPax;
	}

	/**
	 * Gets the name of the customer making the reservation
	 * @return The name of the customer making the reservation
	 */
	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 * Sets the name of the customer making the reservation
	 * @param customerName The name of the customer making the reservation
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * Get the contact number of the customer making the reservation
	 * @return The contact number of the customer making the reservation
	 */
	public String getContact() {
		return this.contact;
	}

	/**
	 * Sets the contact number of the customer making the reservation
	 * @return The contact number of the customer making the reservation
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Displays all information pertaining to this reservation
	 */
	public void displayStatus()
	{
		System.out.printf("%-20s", getReservationId());
		System.out.printf("%-20s", getTableId());
		System.out.printf("%-20s", getCustomerId());
		System.out.printf("%-20s",getDateTime());
		System.out.printf("%-20s", getNoOfPax());
		System.out.printf("%-20s", getCustomerName());
		System.out.printf("%-20s%n", getContact());
	}

}
