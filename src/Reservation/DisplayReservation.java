package Reservation;

import java.util.*;

public class DisplayReservation {
	
	public DisplayReservation() {}
	
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
		System.out.println("3 : Change Date Time");
		System.out.println("4 : Change Number of People");
		System.out.println("5 : Change Customer Name");
		System.out.println("6 : Change Contact Number");
		System.out.println("7 : Stop Changing");
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
	
	public int GetCustomerId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer Id to check : ");
		int m = sc.nextInt();
		return m;
	}
}
