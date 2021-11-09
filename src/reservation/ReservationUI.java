package reservation;

import java.util.*;

public class ReservationUI {
	
	public ReservationUI() {}
	
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
	
	public int removeReservationDisplay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWant to Remove Reservation?");
		System.out.println("0 : Want Remove Reservations");
		System.out.println("1 : Do Not want to Remove Reservation");
		System.out.print("Enter your choice : ");
		int m = sc.nextInt();
		return m;
	}
	
	public int getReservationIdFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Reservation Id : ");
		int n = sc.nextInt();
		return n;
	}
	
	public int getTableIdFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Table Id : ");
		int n = sc.nextInt();
		return n;
	}
	
	public int getCustomerIdFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer Id : ");
		int n = sc.nextInt();
		return n;
	}
	
	public String getDateFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date : ");
		String n = sc.next();
		return n;
	}
	
	public String getTimeFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date : ");
		String n = sc.next();
		return n;
	}
	
	public int getPaxFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date : ");
		int n = sc.nextInt();
		return n;
	}
	
	public String getNameFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date : ");
		String n = sc.next();
		return n;
	}
	
	public String getContactFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date : ");
		String n = sc.next();
		return n;
	}
}
