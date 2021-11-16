package order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import menu.MenuItem;
import menu.PromotionPackage;


public class OrderMgr {
	private ArrayList<Order> listOfOrders;

	//private AddNewOrder addNewOrder = new AddNewOrder();
	
	public OrderMgr() {
		listOfOrders = new ArrayList<Order>();
	}
	
	
	public void newOrder(int staffId, int customerId, int tableId) {
		int orderId = listOfOrders.size();
		Calendar caley = Calendar.getInstance();
	    Order ord = new Order(orderId, staffId, customerId, tableId, caley);
	    listOfOrders.add(ord);
	    //print menu and call add items method in the restaurant boundary
	}
	
	public int currentSize() {
		return listOfOrders.size();
	}
	
	public Order getOrder(int orderId) {
		return listOfOrders.get(orderId);
	}
	
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
	
	public void addItem(int orderId, OrderMenuItem item) {
		listOfOrders.get(orderId).addOrderItem(item);
	}
	
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
	
	public void addPackage(int orderId, OrderPromotionPackage pack) {

		listOfOrders.get(orderId).addPromotion(pack);
	}
	
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
	//cannot as println will be different for different cases.
	
	
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
