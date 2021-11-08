package reservation;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Reservation {

	private int reservationId;
	private int tableId;
	private int customerId;
	private Calendar dateTime;
	private int noOfPax;
	private String customerName;
	private String contact;

	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy,HH:mm");

	public Reservation(){}

	public Reservation(int reservationId,int tableId,int customerId,Calendar dateTime,int noOfPax,String customerName,String contact) {
		this.reservationId = reservationId;
		this.tableId = tableId;
		this.customerId = customerId;
		this.dateTime = dateTime;
		this.noOfPax = noOfPax;
		this.customerName = customerName;
		this.contact = contact;
	}

	public int getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDateTime() {
		Date date1 = dateTime.getTime();
		String strDate = sdf.format(date1);  
		return strDate;
	}

	public void setDateTime(String dateTime){
		try{
			Date date = sdf.parse(dateTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			this.dateTime = cal;
		}catch(ParseException e){}
	}

	public int getNoOfPax() {
		return this.noOfPax;
	}

	public void setNoOfPax(int noOfPax) {
		this.noOfPax = noOfPax;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

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