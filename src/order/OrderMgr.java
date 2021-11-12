package order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import menu.MenuItem;
import menu.PromotionPackage;


public class OrderMgr {
	private ArrayList<Order> ListOfOrders;

	//private AddNewOrder addNewOrder = new AddNewOrder();
	
	public OrderMgr() {
		ListOfOrders = new ArrayList<Order>();
	}
	
	public void newOrder(int staffId, int customerId, int tableId) {
		int orderId = ListOfOrders.size();
		Calendar caley = Calendar.getInstance();
	    Order ord = new Order(orderId, staffId, customerId, tableId, caley);
	    ListOfOrders.add(ord);
	    //print menu and call add items method in the restaurant boundary
	}
	
	public int currentSize() {
		return ListOfOrders.size();
	}
	
	public Order getOrder(int orderId) {
		return ListOfOrders.get(orderId);
	}
	
	public void viewItemInOrder(int orderId) {
		System.out.println("\n---Viewing order "+orderId+"---\n");
		ListOfOrders.get(orderId).viewOrder();
	}
	
	public void addItem(int orderId, orderMenuItem item) {
		ListOfOrders.get(orderId).addOrderItem(item);
		
	}
	
	public void removeItem(int orderId, orderMenuItem item, int qty) {
		//check qty > qty
		//get qty of that item
		int realQty = ListOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).getQty();
		if(realQty == qty) {
			ListOfOrders.get(orderId).removeOrderItem(item);	
			System.out.println("\nremoved.\n");
		}
		else if(realQty > qty) {
			int remainingQty = realQty - qty;
			double indPrice = ListOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).getPrice();
			double newPrice = indPrice * remainingQty;
			ListOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).setQty(remainingQty);
			//and reduce the price
			ListOfOrders.get(orderId).getOrderMenuItem(item.getItemId()).setQtyPrice(newPrice);
			System.out.println("\nQty reduced.\n");
		}
		else {
			System.out.println("Cannot remove more than " + realQty + ".\n");
		}
	}
	
	public void addPackage(int orderId, orderPromotionPackage pack) {

		ListOfOrders.get(orderId).addPromotion(pack);
	}
	
	public void removePackage(int orderId, orderPromotionPackage pack, int qty) {
		int realQty = ListOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).getQty();
		if(realQty == qty) {
			ListOfOrders.get(orderId).removePromotion(pack);
			System.out.println("\nremoved.\n");
		}
		else if(realQty > qty) {
			int remainingQty = realQty - qty;
			double indPrice = ListOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).getPackagePrice();
			double newPrice = indPrice*remainingQty;
			ListOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).setQty(remainingQty);
			//reduce price
			ListOfOrders.get(orderId).getOrderPromotionPackage(pack.getPackageId()).setQtyPrice(newPrice);
			System.out.println("\nQty reduced.");
		}
		else {
			System.out.println("Cannot remove more than " + realQty + ".\n");
		}
	}
	
	public boolean exists(int orderId) {
		if (orderId > ListOfOrders.size() ) {
			return false;
		}
		return true;
	}
	
	

	
}
