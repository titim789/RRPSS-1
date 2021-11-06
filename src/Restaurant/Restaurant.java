package Restaurant;

import java.util.*;

public class Restaurant {

	private static ReservationMgr reserveManager = new ReservationMgr();;
	
	public static void main(String[] args){
		int choice;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("\n--------------------Reservation------------------------------");
			System.out.println("0 : View Tables");
			System.out.println("1 : Create reservation booking");
			System.out.println("2 : Check/Remove Reservations");
			System.out.println("3 : Update Reservation");
			System.out.println("4 : Quit");
			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			switch(choice){
				case 0:
					reserveManager.displayTableDetails();
					break;
				case 1:
					Scanner scan = new Scanner(System.in);
					System.out.print("Enter Table ID to be assigned : ");
					int tableId = scan.nextInt();
					System.out.print("Enter Customer ID: ");
					int customerId = scan.nextInt();
					System.out.print("Enter Date and Time in (dd/MM/yyyy,HH:mm) format: ");
					String calen = scan.next();
					System.out.print("Enter Number of people: ");
					int noOfPax = scan.nextInt();
					System.out.print("Enter Customer Name : ");
					String name = scan.next();
					System.out.print("Enter Contact Number : ");
					String contact = scan.next();
					reserveManager.newReservation(tableId,customerId,calen,noOfPax,name,contact);
					break;
				case 2:
					Scanner scan1 = new Scanner(System.in);
					System.out.println("\nSelect Which Type of Reservation?");
					System.out.println("0 : All Reservations");
					System.out.println("1 : Customer Id");
					System.out.print("Enter your choice : ");
					int n = scan1.nextInt();
					reserveManager.displayResv(n);
					break;
				case 3:
					Scanner scan2 = new Scanner(System.in);
					System.out.print("Enter Customer Id to check : ");
					int editTerm = scan2.nextInt();
					reserveManager.updateReservation(editTerm);
					break;
				case 4:
					reserveManager.save();
					break;
			}
		}while(choice != 4);
	}	

}
