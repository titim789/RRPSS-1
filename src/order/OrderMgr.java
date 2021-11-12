package order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import menu.MenuItem;
import menu.PromotionPackage;

/**
 * The control class of the order entities
 * Contains the list of orders
 * For information on each order in the list, please visit order
 * @author Trevor
 *
 */
public class OrderMgr {
	/**
	 * The list of orders that this control class manages
	 */
	private ArrayList<Order> listOfOrders;

	/**
	 * When instantiating this manager, it will create a list of orders
	 */
	public OrderMgr() {
		listOfOrders = new ArrayList<Order>();
	}
	
	/**
	 * Creating a new order
	 * @param staffId The ID of the staff creaing this new order
	 * @param customerId The ID of the customer making an order
	 * @param tableId The ID that this order is being made for
	 */
	public void newOrder(int staffId, int customerId, int tableId) {
		int orderId = listOfOrders.size();
		Calendar caley = Calendar.getInstance();
	    Order ord = new Order(orderId, staffId, customerId, tableId, caley);
	    listOfOrders.add(ord);
	    //print menu and call add items method in the restaurant boundary
	}
	
	/**
	 * Finds number of existing orders
	 * @return The number of existing orders
	 */
	public int currentSize() {
		return listOfOrders.size();
	}
	
	/**
	 * Gets the order object corresponding to the order ID 
	 * @param orderId The ID of the order we're looking for
	 * @return The order object corresponding to the order ID input
	 */
	public Order getOrder(int orderId) {
		return listOfOrders.get(orderId);
	}
	
	/**
	 * Views the item contents of the order
	 */
	public void viewItemInOrder() {
		OrderUI orderUI = new OrderUI();
		int orderId = orderUI.getOrderId();
		if(exists(orderId)) {
			System.out.println("\n---Viewing order "+orderId+"---\n");
			listOfOrders.get(orderId).viewOrder();	
		}
		else {
			System.out.println("Order ID does not exist.\n");
		}
	}
	
	/**
	 * Adds an item to the order
	 * @param orderId The ID to which to add an item to
	 * @param item The item to add to the order
	 */
	public void addItem(int orderId, OrderMenuItem item) {
		listOfOrders.get(orderId).addOrderItem(item);
	}
	
	/**
	 * Removes an item from an order
	 * @param orderId The ID from which to remove an item from
	 * @param item The item to remove from the order
	 * @param qty The quantity of the item to remove
	 */
	public void removeItem(int orderId, OrderMenuItem item, int qty) {
		//check qty > qty
		//get qty of that item
		int realQty = listOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).getQty();
		if(realQty == qty) {
			listOfOrders.get(orderId).removeOrderItem(item);	
			System.out.println("\nremoved.\n");
		}
		else if(realQty > qty) {
			int remainingQty = realQty - qty;
			double indPrice = listOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).getPrice();
			double newPrice = indPrice * remainingQty;
			listOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).setQty(remainingQty);
			//and reduce the price
			listOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).setQtyPrice(newPrice);
			System.out.println("\nQty reduced.\n");
		}
		else {
			System.out.println("Cannot remove more than " + realQty + ".\n");
		}
	}
	
	/**
	 * Adds a promotion package to the order
	 * @param orderId The ID of the order to which to add the promotion package to
	 * @param pack The promotion package to add to the order
	 */
	public void addPackage(int orderId, OrderPromotionPackage pack) {

		listOfOrders.get(orderId).addPromotion(pack);
	}
	
	/**
	 * Removes a promotion package from an order
	 * @param orderId The ID of the order form which to remove a promotion package from
	 * @param pack The promotion package to remove from the order
	 * @param qty The quantity of the package to remove from the order
	 */
	public void removePackage(int orderId, OrderPromotionPackage pack, int qty) {
		int realQty = listOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).getQty();
		if(realQty == qty) {
			listOfOrders.get(orderId).removePromotion(pack);
			System.out.println("\nremoved.\n");
		}
		else if(realQty > qty) {
			int remainingQty = realQty - qty;
			double indPrice = listOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).getPackagePrice();
			double newPrice = indPrice*remainingQty;
			listOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).setQty(remainingQty);
			//reduce price
			listOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).setQtyPrice(newPrice);
			System.out.println("\nQty reduced.");
		}
		else {
			System.out.println("Cannot remove more than " + realQty + ".\n");
		}
	}

	
	/**
	 * Ensures the order ID input is valid
	 * @param prompt The string prompt that the UI will print to ask for
	 * @return A valid ID input from the user
	 */
	public int ensureId(String prompt) {
		Scanner sc = new Scanner(System.in);
		boolean ordE = false;
		int orderId;
		do{System.out.println(prompt);
		orderId = sc.nextInt();
		ordE = exists(orderId);
		if(!ordE) {System.out.println("Order ID does not exist.");}
		}while(ordE==false);
		return orderId;
	}

	/**
	 * Checks if an order ID exists
	 * @param orderId The order ID for which to check for existence
	 * @return True if it exists, False if it does not exist
	 */
	public boolean exists(int orderId) {
		for(int i=0; i<listOfOrders.size(); i++) {
			if(listOfOrders.get(i).getOrderId() == orderId) {
				return true;
			}
		}
		/*
		if (orderId > listOfOrders.size() ) {
			return false;
		}
		*/
		return false;
	}
}
