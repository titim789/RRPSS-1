package reservation;

import java.util.*;

/**
 * ReservationUI class for capturing user inputs and displaying reservation options
 */
public class ReservationUI {
	
	/**
	 * ReservationUI Constructor
	 */
	public ReservationUI() {}
	
	/** 
	 * Displays the reservations made by a specific customer
	 * @param listOfReservations - An ArrayList of the reservation objects
	 * @param n - An integer holding the customer ID
	 */
	public void reservationDisplayCustomer(ArrayList<Reservation>listOfReservations,int n){
    	
        	System.out.printf("%n%-20s", "Reservation ID");
		System.out.printf("%-20s", "Table ID");
		System.out.printf("%-20s", "Customer ID");
		System.out.printf("%-20s", "Date time");
        	System.out.printf("%-20s", "Number of People");
        	System.out.printf("%-20s", "Customer Name");
		System.out.printf("%-20s%n", "Contact Number");

        	for(Reservation reservation : listOfReservations){
            		if(n == reservation.getCustomerId())
                	reservation.displayStatus();
        	}
    	}
	
	/** 
	 * Displays the reservations on a specific Date
	 * @param listOfReservations - An ArrayList of the reservation objects
	 * @param date - A String that contains a date
	 */
	public void reservationDisplayDate(ArrayList<Reservation>listOfReservations,String date){
    	
		String dt,d;
		
        	System.out.printf("%n%-20s", "Reservation ID");
		System.out.printf("%-20s", "Table ID");
		System.out.printf("%-20s", "Customer ID");
		System.out.printf("%-20s", "Date time");
        	System.out.printf("%-20s", "Number of People");
        	System.out.printf("%-20s", "Customer Name");
		System.out.printf("%-20s%n", "Contact Number");

        	for(Reservation reservation : listOfReservations){
        		dt = reservation.getDateTime();
			String[] part = dt.split(" ");
			d = part[0];
  			if (d.equals(date))
                		reservation.displayStatus();
        	}
    	}
	
	/** 
	 * Displays all the reservation
	 * @param listOfReservations - An ArrayList of the reservation objects
	 */
	public void reservationDisplayAll(ArrayList<Reservation>listOfReservations){
    	
    		System.out.printf("%n%-20s", "Reservation ID");
		System.out.printf("%-20s", "Table ID");
		System.out.printf("%-20s", "Customer ID");
		System.out.printf("%-20s", "Date time");
        	System.out.printf("%-20s", "Number of People");
        	System.out.printf("%-20s", "Customer Name");
		System.out.printf("%-20s%n", "Contact Number");
		
        	for(Reservation reservation : listOfReservations){
            		reservation.displayStatus();
        	}
    	}
	
	
	/** 
	 * Displays the Update Menu of Reservation and prompting user for his/her input
	 * @return int choice of user
	 */
	public int updateReservationDisplay(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSelect Parameter you want to change?");
		System.out.println("1 : Change Table ID");
		System.out.println("2 : Change Customer ID");
		System.out.println("3 : Change Date");
		System.out.println("4 : Change Time");
		System.out.println("5 : Change Number of People");
		System.out.println("6 : Change Customer Name");
		System.out.println("7 : Change Contact Number");
		System.out.println("8 : Stop Changing");
		System.out.print("Enter Choice : ");
		int choice = sc.nextInt();
		return choice;
    	}
	
	/** 
	 * Displays the Remove Menu of Reservation and prompting user for his/her input
	 * @return int choice of user
	 */
	public int removeReservationDisplay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWant to Remove Reservation?");
		System.out.println("0 : Want Remove Reservations");
		System.out.println("1 : Customer Arrive");
		System.out.println("2 : Back to Main Menu");
		System.out.print("Enter your choice : ");
		int m = sc.nextInt();
		return m;
	}
	
	/** 
	 * Prompt for user's reservation Id
	 * @return int choice of user
	 */
	public int getReservationIdFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Reservation Id : ");
		int n = sc.nextInt();
		return n;
	}
	/** 
	 * Prompt for user's Table Id
	 * @return int choice of user
	 */
	public int getTableIdFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Table Id : ");
		int n = sc.nextInt();
		return n;
	}
	
	/** 
	 * Prompt for customer's Id
	 * @return int choice of user
	 */
	public int getCustomerIdFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer Id : ");
		int n = sc.nextInt();
		return n;
	}
	
	/** 
	 * Prompt for a date
	 * @return String date input
	 */
	public String getDateFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date : ");
		String n = sc.next();
		return n;
	}
	
	/** 
	 * Prompt for a time
	 * @return String time input
	 */
	public String getTimeFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Time : ");
		String n = sc.next();
		return n;
	}
	
	/** 
	 * Prompt for number of people
	 * @return int number of people input
	 */
	public int getPaxFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number Of People : ");
		int n = sc.nextInt();
		return n;
	}
	
	/** 
	 * Prompt for name
	 * @return String name input
	 */
	public String getNameFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer Name : ");
		String n = sc.nextLine();
		return n;
	}
	
	/** 
	 * Prompt for contact number
	 * @return String contact number input
	 */
	public String getContactFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Contact Number : ");
		String n = sc.next();
		return n;
	}
}
