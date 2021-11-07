package Restaurant;

import Menu.MenuMgr;
import Reservation.ReservationMgr;
import java.util.*;

public class Restaurant {

	private static ReservationMgr reserveManager;
	private static MenuMgr menuMgr;
	
	public static void main(String[] args){
		reserveManager = new ReservationMgr();
		menuMgr = new MenuMgr();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do{
			System.out.println("1.\tMenu\n"
					+ "2.\tOrders\n"
					+ "3.\tReservation & Tables\n"
					+ "4.\tInvoice\n"
					+ "5.\tSales Report\n"
					+ "6.\tExit");
			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("1.\tView Menu\n"
						+ "2.\tEdit Menu\n"
						+ "3.\tReturn to Main Menu");
				int menuchoice = sc.nextInt();
				if(menuchoice == 1) {
					menuMgr.seeMenu();
				}
				else if (menuchoice == 2) {
					menuMgr.editMenu();
				}
				else if (menuchoice == 3) {
					System.out.println("Returning to Main Menu...");
				}
				else {
					System.out.println("Invalid Choice.\nReturning to Main Menu...");
				}
			}
			else if(choice == 2) {
				
			}
			else if(choice == 3) {
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
			}
			else if(choice == 4) {
							
			}
			else if(choice == 5) {
				
			}
		}while(choice != 6);
		menuMgr.save();
	}	

}

