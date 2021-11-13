package restaurant;

import customer.CustomerMgr;
import invoice.InvoiceMgr;
import menu.MenuMgr;
import menu.MenuItem;
import menu.PromotionPackage;
import order.Order;
import order.OrderMgr;
import order.OrderMenuItem;
import order.OrderPromotionPackage;
import reservation.ReservationMgr;
import staff.StaffMgr;
//import test.MenuItem;
//import test.OrderMenuItem;

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
						boolean staffExist = false;
						int staffId;
						do{System.out.println("Enter staffId: ");
						staffId = sc.nextInt();
						staffExist = staffMgr.checkStaffId(staffId);
						//checking staff id prints staff id. To remove?
						if(!staffExist) {System.out.println("Invalid Staff ID.");}
						}while(staffExist==false);
						
						boolean customerExist = false;
						int customerId;
						do{System.out.println("Enter customerId: ");
						customerId = sc.nextInt();
						customerExist = customerMgr.isCustomerExist(customerId);
						if(!customerExist) {System.out.println("Invalid Customer ID.");}
						}while(customerExist==false);

						System.out.println("Enter tableId: ");
						int tableId = sc.nextInt();
						int temp = orderMgr.currentSize();
						
						orderMgr.newOrder(staffId, customerId, tableId);
						//print for ref
						System.out.println("Your OrderID: "+temp+"\n");
						break;
					case 2:
						orderMgr.viewItemInOrder();
						break;
					case 3:
						int addOrderId = orderMgr.ensureId("Enter order ID to add items to: ");
						//menuMgr.seeMenu();
						System.out.println("Enter item ID to add: ");
						int addItemId = sc.nextInt();
						MenuItem hurr = menuMgr.getMenuItem(addItemId);
						while(hurr==null) {
							System.out.println("Item ID does not exist.");
							System.out.println("Enter item ID to add: ");
							addItemId = sc.nextInt();
							hurr = menuMgr.getMenuItem(addItemId);
						}
						System.out.println("Enter quantity to add: ");
						int addQty = sc.nextInt();
						//creating a new orderMenuItem
						OrderMenuItem ord = new OrderMenuItem(addItemId, menuMgr.getMenuItem(addItemId).getName(),
								menuMgr.getMenuItem(addItemId).getDescription(), menuMgr.getMenuItem(addItemId).getPrice(),
								menuMgr.getMenuItem(addItemId).getMenuType(), addQty);
						//adding it.
						orderMgr.addItem(addOrderId, ord);
						System.out.println("\nadded.\n");
						break;
					case 4:
						int addPackOrderId = orderMgr.ensureId("Enter order ID to add package to: ");
						//menuMgr.seeMenu();
						System.out.println("Enter Package ID to add: ");
						int addPackId = sc.nextInt();
						PromotionPackage asdf = menuMgr.getPromotionPackage(addPackId);
						while(asdf==null) {
							System.out.println("Package ID does not exist.");
							System.out.println("Enter Package ID to add: ");
							addPackId = sc.nextInt();
							asdf = menuMgr.getPromotionPackage(addPackId);
						}
						System.out.println("Enter quantity to add: ");
						int addPackQty = sc.nextInt();
						
						//creating a new orderPromoPackage obj
						OrderPromotionPackage pak = new OrderPromotionPackage(addPackId, menuMgr.getPromotionPackage(addPackId).getPackageName(),
								menuMgr.getPromotionPackage(addPackId).getPackagePrice(), menuMgr.getPromotionPackage(addPackId).getPackageDesc(),
								menuMgr.getPromotionPackage(addPackId).getListOfMenuItem(), addPackQty);
						//adding it.
						orderMgr.addPackage(addPackOrderId, pak);
						System.out.println("\nadded.\n");
						break;
					case 5:
						int removeOrderId = orderMgr.ensureId("Enter order ID to remove items from: ");
						//menuMgr.seeMenu();
						System.out.println("Enter item ID to remove: ");
						int removeItemId = sc.nextInt();
						OrderMenuItem ordMenIt = orderMgr.getOrder(removeOrderId).getOrderMenuItem(removeItemId);
						if(ordMenIt==null) {
							System.out.println("This order does not contain this item");
							break;
						}
						System.out.println("Enter quantity to remove: ");
						int removeItemIdQty = sc.nextInt();
						
						orderMgr.removeItem(removeOrderId,
								( (orderMgr.getOrder(removeOrderId)).getOrderMenuItem(removeItemId) ),
								removeItemIdQty);
						//System.out.println("\nremoved.\n");
						break;
					case 6:
						int removePackId = orderMgr.ensureId("Enter order ID to remove package from: ");
						//menuMgr.seeMenu();
						System.out.println("Enter package ID to remove: ");
						int removePackageId = sc.nextInt();
						OrderPromotionPackage ordProPac = orderMgr.getOrder(removePackId).getOrderPromotionPackage(removePackageId);
						if(ordProPac==null) {
							System.out.println("This order does not contain this package");
							break;
						}
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
				System.out.println("\n--------------------Reservation & Tables------------------------------");
				System.out.println("0 : View Tables");
				System.out.println("1 : Walk In Customer");
				System.out.println("2 : Check Availability");
				System.out.println("3 : Create reservation booking");
				System.out.println("4 : Check/Remove Reservations");
				System.out.println("5 : Update Reservation");
				System.out.println("6 : Quit");
				System.out.print("Enter Choice : ");
				int reservechoice = sc.nextInt();
				switch(reservechoice){
					case 0:
						reserveManager.displayTableDetails();
						break;
					case 1:
						Scanner sc0 = new Scanner(System.in);
						int pax1;
						System.out.print("Enter Number of people: ");
						pax1 = sc.nextInt();
						int success = reserveManager.customerWalkin(pax1);
						if(success == 1) {
							System.out.print("Enter Customer ID(-1 for new customer): ");
							int custId = sc0.nextInt();
							String cname, ccontact;
							if(customerMgr.isCustomerExist(custId)) {
								cname = customerMgr.getCustomerName(custId);
								ccontact = customerMgr.getCustomerPhone(custId);
							}
							else {
								System.out.print("Enter Customer Name : ");
								cname = sc0.nextLine();
								cname +=sc0.nextLine();
								System.out.print("Enter Contact Number : ");
								ccontact = sc0.next();
								custId = customerMgr.getLastCustomerId()+1;
								customerMgr.addCustomer(custId, cname, ccontact, "n");
								System.out.println(cname + " has been added to Customer table.");
							}	
							System.out.println("Table Status has been changed to occupied");
						}
						else {
							System.out.println("No Table Available");
						}
						
						break;
					case 2:
						Scanner sc1 = new Scanner(System.in);
						System.out.print("Enter Size of Table : ");
						int pax = sc1.nextInt();
						reserveManager.checkAvail(pax);
						break;
					case 3:
						String name="", contact, date, time;
						int customerId, noOfPax;
						Scanner scan = new Scanner(System.in);
						System.out.print("Enter Number of people: ");
						noOfPax = scan.nextInt();
						reserveManager.checkAvail(noOfPax);
						System.out.print("Enter Customer ID(-1 for new customer): ");
						customerId = scan.nextInt();
						System.out.print("Enter Date in (dd/MM/yyyy) format: ");
						date = scan.next();
						System.out.print("Enter Time in (HH:mm) format: ");
						time = scan.next();
						if(customerMgr.isCustomerExist(customerId)) {
							name = customerMgr.getCustomerName(customerId);
							contact = customerMgr.getCustomerPhone(customerId);
						}
						else {
							System.out.print("Enter Customer Name : ");
							name = scan.nextLine();
							name +=scan.nextLine();
							System.out.print("Enter Contact Number : ");
							contact = scan.next();
							customerId = customerMgr.getLastCustomerId()+1;
							customerMgr.addCustomer(customerId, name, contact, "n");
							System.out.println(name + " has been added to Customer table.");
						}
						reserveManager.newReservation(customerId,date+" "+time,noOfPax,name,contact);
						break;
					case 4:
						Scanner scan1 = new Scanner(System.in);
						System.out.println("\nSelect Which Type of Reservation?");
						System.out.println("0 : All Reservations");
						System.out.println("1 : Reservations Today");
						System.out.println("2 : Customer Id");
						System.out.print("Enter your choice : ");
						int n = scan1.nextInt();
						reserveManager.displayResv(n);
						break;
					case 5:
						Scanner scan2 = new Scanner(System.in);
						System.out.print("Enter Customer Id to check : ");
						int editTerm = scan2.nextInt();
						reserveManager.updateReservation(editTerm);
						break;
					case 6:
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
				        + "3 - Save Invoices to File\n"
				        + "4 - Load Invoices From File\n"
				        + "5 - Quit");
				int invchoice = sc.nextInt();
				switch(invchoice) {
					case 1:
						int invOrderId = orderMgr.ensureId("Please enter order ID to create invoice for: ");
						int tempy = invoiceMgr.currentSize();
						invoiceMgr.newInvoice(orderMgr.getOrder(invOrderId), (customerMgr.getCustomerObj((orderMgr.getOrder(invOrderId)).getCustomerId())).isMember());
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
				int option = 0;
				do{
					System.out.println("\nDo you want to \n"
					+ "1 - Display Staff\n"
					+ "2 - Add Staff\n"
					+ "3 - Remove Staff\n"
					+ "4 - Back to main menu");
					option = sc.nextInt();
					if (option == 1) {
						staffMgr.displayStaffList();
					}
					else if (option == 2) {
						staffMgr.addStaff();
					}
					else if (option == 3) {
						staffMgr.removeStaff();
					}
					else if (option == 4) {
						//pass
						System.out.println("Returning to Main Menu...");
					}
					else {
						System.out.println("Invalid Choice.\nReturning to Main Menu...");
						break;
					}

				}while(option != 4);
			}

			else if (choice == 7){
								// customerMgr.init();
								int option = 0;

								do{
									System.out.println("\nDo you want to \n"
									+ "1 - Display Customer List\n"
									+ "2 - Add Customer\n"
									+ "3 - Remove Customer\n"
									+ "4 - Back to main menu");
									option = sc.nextInt();
									if (option == 1) {
										customerMgr.displayCustomerList();
									}
									else if (option == 2) {
										customerMgr.addCustomerInit();
									}
									else if (option == 3) {
										customerMgr.removeCustomer();
									}
									else if (option == 4) {
										//pass
										System.out.println("Returning to Main Menu...");
									}
									else {
										System.out.println("Invalid Choice.\nReturning to Main Menu...");
										break;
									}
				
								}while(option != 4);
			}
		
		}while(choice != 8); //Exiting
		reserveManager.save();
		menuMgr.save();
		staffMgr.save();
		customerMgr.save();
	}
}

