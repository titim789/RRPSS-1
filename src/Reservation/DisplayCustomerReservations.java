package Reservation;

import java.util.*;

public class DisplayCustomerReservations {

    public DisplayCustomerReservations(){}

    public void CustomerReservationDisplay(ArrayList<Reservation>listOfReservations, int customer_id){
        System.out.printf("%n%-20s", "Reservation ID");
		System.out.printf("%-20s", "Table ID");
		System.out.printf("%-20s", "Customer ID");
		System.out.printf("%-20s", "Date time");
        System.out.printf("%-20s", "Number of People");
        System.out.printf("%-20s", "Customer Name");
		System.out.printf("%-20s%n", "Contact Number");

        for(Reservation reservation : listOfReservations){
            if(customer_id == reservation.getCustomerId())
                reservation.displayStatus();
        }

        listOfReservations.clear();
    }
}
