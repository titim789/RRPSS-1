package Order;

import Menu.MenuItem;
import Menu.PromotionPackage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class OrderMgr {
	private ArrayList<Order> ListOfOrders = new ArrayList<Order>();

	//private AddNewOrder addNewOrder = new AddNewOrder();
	
	public OrderMgr() {
		
	}
	
	public void newOrder() {
		Scanner scan = new Scanner(System.in);
		int orderId, staffId, customerId, tableId;
		orderId = ListOfOrders.size();
		
		System.out.println("\n---Adding new order---\n");
		System.out.println("Enter staffId: ");
		staffId = scan.nextInt();
		System.out.println("Enter customerId: ");
		customerId = scan.nextInt();
		System.out.println("Enter tableId: ");
		tableId = scan.nextInt();
		
	    Calendar caley = Calendar.getInstance();
	    
	    Order ord = new Order(orderId, staffId, customerId, tableId, caley);
	    ListOfOrders.add(ord);
	    scan.close();
	    //print menu and call add items method in the restaurant boundary
	    
	}
	
	public Order getOrder(int orderId) {
		return ListOfOrders.get(orderId);
	}
	
	public void viewItemInOrder(int orderId) {
		System.out.println("\n---Viewing order "+orderId+"---\n");
		ListOfOrders.get(orderId).viewOrder();
	}
	
	public void addItem(int orderId, MenuItem item) {
		ListOfOrders.get(orderId).addOrderItem(item);
	}
	
	public void removeItem(int orderId, MenuItem item) {
		ListOfOrders.get(orderId).removeOrderItem(item);
	}
	
	public void addPackage(int orderId, PromotionPackage pack) {
		ListOfOrders.get(orderId).addPromotion(pack);
	}
	
	public void removePackage(int orderId, PromotionPackage pack) {
		ListOfOrders.get(orderId).removePromotion(pack);
	}
	
	/*
	public void save() {
		
	}
	
	public void load() {
		
	}
	*/
	
}
