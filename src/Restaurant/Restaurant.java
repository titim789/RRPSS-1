package Restaurant;

import Reservation.ReservationMgr;
import java.util.*;

public class Restaurant {

	private static ReservationMgr reserveManager;
	
	public static void main(String[] args){
		reserveManager = new ReservationMgr();
		int choice;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("\n1 : View Tables");
			System.out.println("2 : Add Reservation");
			System.out.println("3 : Show Reservations");
			System.out.println("4 : Delete Reservation");
			System.out.println("5 : Update Reservation");
			System.out.println("6 : Quit");
			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					reserveManager.printTableStatus();
					break;
				case 2:
					reserveManager.addNewReservation();
					break;
				case 3:
					reserveManager.DisplayReservations();
					break;
				case 4:
					reserveManager.removeReservation();
					break;
				case 5:
					reserveManager.updateReservation();
					break;
			}
		}while(choice != 6);
		sc.close();
	}	

}