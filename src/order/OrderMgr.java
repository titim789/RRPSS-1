package order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import menu.MenuItem;
import menu.PromotionPackage;


public class OrderMgr {
	private ArrayList<Order> ListOfOrders = new ArrayList<Order>();

	//private AddNewOrder addNewOrder = new AddNewOrder();
	
	public OrderMgr() {
		
	}
	
	public void newOrder(int staffId, int customerId, int tableId) {
		
		int orderId = ListOfOrders.size();
		Calendar caley = Calendar.getInstance();
	    Order ord = new Order(orderId, staffId, customerId, tableId, caley);
	    ListOfOrders.add(ord);
	    //print menu and call add items method in the restaurant boundary
	}
	
	public Order getOrder(int orderId) {
		return ListOfOrders.get(orderId);
	}
	
	public void viewItemInOrder(int orderId) {
		System.out.println("\n---Viewing order "+orderId+"---\n");
		ListOfOrders.get(orderId).viewOrder();
	}
	
	public void addItem(int orderId, orderMenuItem item, int qty) {
		ListOfOrders.get(orderId).addOrderItem(item);
		
	}
	
	public void removeItem(int orderId, MenuItem item) {
		ListOfOrders.get(orderId).removeOrderItem(item);
	}
	
	public void addPackage(int orderId, PromotionPackage pack, int qty) {
		for(int i=0;i<qty;i++) {
			ListOfOrders.get(orderId).addPromotion(pack);	
		}
	}
	
	public void removePackage(int orderId, PromotionPackage pack) {
		ListOfOrders.get(orderId).removePromotion(pack);
	}
	
	public boolean exists(int orderId) {
		if (orderId > ListOfOrders.size() ) {
			return false;
		}
		return true;
	}
	
	/* no need save/load orders
	public void save() {
		
	}
	
	public void load() {
		
	}
	*/
	
}
