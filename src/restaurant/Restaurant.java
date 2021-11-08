package restaurant;

import customer.CustomerMgr;
import invoice.InvoiceMgr;
import menu.MenuMgr;
import order.Order;
import order.OrderMgr;
import order.orderMenuItem;
import order.orderPromotionPackage;
import reservation.ReservationMgr;
import staff.StaffMgr;

import java.util.*;


public class Restaurant {

	private static ReservationMgr reserveManager;
	private static MenuMgr menuMgr;
	private static OrderMgr orderMgr;
	private static InvoiceMgr invoiceMgr;
	private static CustomerMgr customerMgr;
	private static StaffMgr staffMgr;
	
	public static void main(String[] args){
		reserveManager = new ReservationMgr();
		menuMgr = new MenuMgr();
		staffMgr = new StaffMgr();
		customerMgr = new CustomerMgr();
		orderMgr = new OrderMgr();
		invoiceMgr = new InvoiceMgr();
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do{
			System.out.println("1.\tMenu\n"
					+ "2.\tOrders\n"
					+ "3.\tReservation & Tables\n"
					+ "4.\tInvoice\n"
					+ "5.\tSales Report\n"
					+ "6.\tManage Staff\n"
					+ "7.\tManage Customer\n"
					+ "8.\tExit");
			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			//Menu Choice
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
			//Ordering Choice
			else if(choice == 2) {
				System.out.println("Do you want to \n"
				        + "1 - Create New Order\n"
				        + "2 - View Items in an Order\n"
				        + "3 - Add Items\n"
				        + "4 - Add Package\n"
				        + "5 - Remove Items\n"
				        + "6 - Remove Package\n"
				        + "7 - Quit");
				int ordOption = sc.nextInt();
				switch(ordOption){
					case 1:
						System.out.println("\n---Creating new order---\n");
						System.out.println("Enter staffId: ");
						int staffId = sc.nextInt();
						System.out.println("Enter customerId: ");
						int customerId = sc.nextInt();
						System.out.println("Enter tableId: ");
						int tableId = sc.nextInt();
						int temp = orderMgr.currentSize();
						orderMgr.newOrder(staffId, customerId, tableId);
						
						//print for ref
						System.out.println("Your OrderID: "+temp+"\n");
						
						break;
					case 2:
						System.out.println("\nEnter order ID: ");
						int viewOrderId = sc.nextInt();
						if(orderMgr.exists(viewOrderId)) {
							orderMgr.viewItemInOrder(viewOrderId);
						}
						else {
							System.out.println("Order ID does not exists.");
						}
						break;
					case 3:
						System.out.println("Enter order ID: ");
						int addOrderId = sc.nextInt();
						//check if exists
						//wanna display just items menu anot?
						menuMgr.seeMenu();
						System.out.println("Enter item ID to add: ");
						int addItemId = sc.nextInt();
						//hmmm can check if exists first? Rather than just println and return null if not exists
						System.out.println("Enter quantity to add: ");
						int addQty = sc.nextInt();
						
						//creating a new orderMenuItem
						orderMenuItem ord = new orderMenuItem(addItemId, menuMgr.getMenuItem(addItemId).getName(),
								menuMgr.getMenuItem(addItemId).getDescription(), menuMgr.getMenuItem(addItemId).getPrice(),
								menuMgr.getMenuItem(addItemId).getMenuType(), addQty);
						//adding it.
						orderMgr.addItem(addOrderId, ord);
						System.out.println("\nadded.\n");
						break;
					case 4:
						System.out.println("Enter order ID: ");
						int addPackOrderId = sc.nextInt();
						//check if exists
						//wanna display just package menu anot?
						menuMgr.seeMenu();
						System.out.println("Enter Package ID to add: ");
						int addPackId = sc.nextInt();
						//hmmm can check if exists first? Rather than just println and return null if not exists
						System.out.println("Enter quantity to add: ");
						int addPackQty = sc.nextInt();
						
						//menuMgr.getPromotionPackage(addPackId);
						
						//creating a new orderPromoPackage obj
						orderPromotionPackage pak = new orderPromotionPackage(addPackId, menuMgr.getPromotionPackage(addPackId).getPackageName(),
								menuMgr.getPromotionPackage(addPackId).getPackagePrice(), menuMgr.getPromotionPackage(addPackId).getPackageDesc(),
								menuMgr.getPromotionPackage(addPackId).getListOfMenuItem(), addPackQty);
						
						orderMgr.addPackage(addPackOrderId, pak);
						System.out.println("\nadded.\n");
						break;
					case 5:
						System.out.println("Enter order ID: ");
						int removeOrderId = sc.nextInt();
						//check if exists
						//wanna display just package menu anot?
						//menuMgr.seeMenu();
						System.out.println("Enter item ID to remove: ");
						int removeItemId = sc.nextInt();
						//hmmm can check if exists first? Rather than just println and return null if not exists
						System.out.println("Enter quantity to remove: ");
						int removeItemIdQty = sc.nextInt();
						
						
						orderMgr.removeItem(removeOrderId,
								( (orderMgr.getOrder(removeOrderId)).getOrderMenuItem(removeItemId) ),
								removeItemIdQty);
						//System.out.println("\nremoved.\n");
						break;
					case 6:
						System.out.println("Enter order ID: ");
						int removePackId = sc.nextInt();
						//check if exists
						//wanna display just package menu anot?
						//menuMgr.seeMenu();
						System.out.println("Enter package ID to remove: ");
						int removePackageId = sc.nextInt();
						//hmmm can check if exists first? Rather than just println and return null if not exists
						System.out.println("Enter quantity to remove: ");
						int removePackIdQty = sc.nextInt();
						
						orderMgr.removePackage(removePackId,
								( (orderMgr.getOrder(removePackId)).getOrderPromotionPackage(removePackageId) ),
								removePackIdQty);
						//System.out.println("\nremoved.\n");
						break;
					case 7:
					default:
						//pass
						break;
				}
			}
			//Tables & Reservations Choice
			else if(choice == 3) {
				System.out.println("\n--------------------Reservation------------------------------");
				System.out.println("0 : View Tables");
				System.out.println("1 : Check Availability");
				System.out.println("2 : Create reservation booking");
				System.out.println("3 : Check/Remove Reservations");
				System.out.println("4 : Update Reservation");
				System.out.println("5 : Quit");
				System.out.print("Enter Choice : ");
				int reservechoice = sc.nextInt();
				switch(reservechoice){
					case 0:
						reserveManager.displayTableDetails();
						break;
					case 1:
						reserveManager.checkAvail();
						break;
					case 2:
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
					case 3:
						Scanner scan1 = new Scanner(System.in);
						System.out.println("\nSelect Which Type of Reservation?");
						System.out.println("0 : All Reservations");
						System.out.println("1 : Customer Id");
						System.out.print("Enter your choice : ");
						int n = scan1.nextInt();
						reserveManager.displayResv(n);
						break;
					case 4:
						Scanner scan2 = new Scanner(System.in);
						System.out.print("Enter Customer Id to check : ");
						int editTerm = scan2.nextInt();
						reserveManager.updateReservation(editTerm);
						break;
					case 5:
					default:
						//pass
						break;
				}
			}
			//Invoice Choice
			else if(choice == 4) {
				System.out.println("What do you want to do? \n"
				        + "1 - Create New Invoice\n"
				        + "2 - Print Invoice\n"
				        + "3 - Generate Sales Report\n"
				        + "4 - Save Invoices to File\n"
				        + "5 - Load Invoices From File\n"
				        + "6 - Quit");
				int invchoice = sc.nextInt();
				switch(invchoice) {
					case 1:
						System.out.println("Please enter order ID to create invoice for: ");
						int invOrderId = sc.nextInt();
						//to check if ord id exists
						int tempy = invoiceMgr.currentSize();
						invoiceMgr.newInvoice(orderMgr.getOrder(invOrderId), (customerMgr.getCustomerObj((orderMgr.getOrder(invOrderId)).getcustomerId())).isMember());
						System.out.println("Invoice ID "+tempy+" created.");
						break;
					case 2:
						System.out.println("Please enter order ID to print invoice for: ");
						int printInvOrdId = sc.nextInt();
						invoiceMgr.printInvoice(printInvOrdId);
						break;
					case 3:
						invoiceMgr.save();
						System.out.println("Invoices saved to invoice.txt file");
						break;
					case 4:
						invoiceMgr.load();
						System.out.println("Invoices loaded from invoice.txt file");
						break;
					case 5:
					default:
						//pass
						break;
				}
							
			}
			//Sales Report Choice
			else if(choice == 5) {
				System.out.println("Generate sales by: \n"
				        + "1 - This month\n"
				        + "2 - Date range\n"
				        + "3 - Quit");
				int genchoice = sc.nextInt();
				switch(genchoice) {
					case 1:
						System.out.println("Printing sales rpt for this month\n");
						invoiceMgr.generateSalesReport();
						break;
					case 2:
						System.out.println("Input start date (inclusive) in DD/MM/YYYY format: ");
						String sStr;
						Scanner sk = new Scanner(System.in);
						sStr = sk.nextLine();
						//to do: check if invalid input.
						System.out.println("Input end date (inclusive) in DD/MM/YYYY format: ");
						String eStr;
						eStr = sk.nextLine();
						invoiceMgr.generateSalesReport(sStr, eStr);
					case 3:
					default:
						//pass
						break;
				}
			}
			
			else if(choice == 6) {
				staffMgr.init();
			}

			else if (choice == 7){
				customerMgr.init();
			}
		
		}while(choice != 8); //Exiting
		reserveManager.save();
		menuMgr.save();
		staffMgr.save();
		customerMgr.save();
	}
}

