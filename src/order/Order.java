package order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import menu.MenuItem;
import menu.PromotionPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Order {

	private int orderId;
	private int staffId;
	private int tableId;
	private int customerId;
	private double orderPrice;
	//private ArrayList<orderMenuItem> listOfOrderItems = new ArrayList<orderMenuItem>();
	//private ArrayList<orderPromotionPackage> listOfOrderPromotions = new ArrayList<orderPromotionPackage>();
	private ArrayList<OrderMenuItem> listOfOrderItems;
	private ArrayList<OrderPromotionPackage> listOfOrderPromotions;
	private Calendar timestamp;
	
	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy,HH:mm");

	public Order(int orderId, int staffId, int customerId, int tableId, Calendar timestamp) {
		//added tableId as param
		this.orderId = orderId;
		this.staffId = staffId;
		this.customerId = customerId;
		this.tableId = tableId;
		this.timestamp = timestamp;
		listOfOrderItems = new ArrayList<OrderMenuItem>();
		listOfOrderPromotions = new ArrayList<OrderPromotionPackage>();
	}
	

	public int getOrderId() {
		return this.orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getStaffId() {
		return this.staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getTableId() {
		return this.tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId= customerId;
	}
	public double getOrderPrice() {
		return this.orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		//to do: add all orderitem and promo item prices 
		this.orderPrice = orderPrice;
	}
	public String getTimestamp() {
		Date datey = timestamp.getTime();
		String strDate = sdf.format(datey);
		return strDate;
	}
	public void setTimestamp(String timestamp) {
		try {
			Date datey = sdf.parse(timestamp);
			Calendar caley = Calendar.getInstance();
			caley.setTime(datey);
			this.timestamp = caley;
		}catch(ParseException e) {}
	}
	
	
	
	public void addOrderItem(OrderMenuItem item) {
		listOfOrderItems.add(item);
		orderPrice += item.getPrice();
		System.out.println(item.getName()+" added.");
	}


	//param change to MenuItem
	public void removeOrderItem(OrderMenuItem item) {
		if(listOfOrderItems.remove(item)) {
			System.out.println("Successfully Removed");
			orderPrice -= item.getPrice();
		}
		else {
			System.out.println("Error.");
		}
	}

	//param change to PromoItem
	public void addPromotion(OrderPromotionPackage pack) {
		listOfOrderPromotions.add(pack);
		orderPrice += pack.getPackagePrice();
		System.out.println(pack.getPackageName()+" added.");
	}

	//param change to PromoItem
	public void removePromotion(OrderPromotionPackage pack) {
		if(listOfOrderPromotions.remove(pack)) {
			System.out.println("Successfully Removed");
			orderPrice -= pack.getPackagePrice();
		}
		else {
			System.out.println("Error.");
		}
	}
	
	
	public void viewOrder() {
		// TODO - implement Order.viewOrder
		//throw new UnsupportedOperationException();
		
		if(listOfOrderItems.size()==0 && listOfOrderPromotions.size()==0) {
			System.out.println("Order is empty.\n");
		}
		else {
			if(listOfOrderItems.size()>0) {
				System.out.println("Ala carte items: ");
				System.out.println(String.format("%-10s", "ItemID") + 
						String.format("%-20s", "Item name") +
						String.format("%-10s", "Quantity") +
						String.format("%-20s", "Item price (each)" ) +
						String.format("%-20s", "Type")
						);
				listOfOrderItems.forEach((n) -> printItem(n));	
			}
			if(listOfOrderPromotions.size()>0) {
				System.out.println("\nPromotion Package items: ");
				System.out.println(String.format("%-10s", "PackID") + 
						String.format("%-20s", "Package name") +
						String.format("%-10s", "Quantity") + 
						String.format("%-20s","Package price (each)")
						);
				listOfOrderPromotions.forEach((n) -> printPack(n));
				System.out.println("\n");	
			}
		}
	}
	
	//another method to print the stuff
	public void printItem(OrderMenuItem n){
		System.out.println(String.format("%-10s", n.getItemId() ) + 
				String.format("%-20s", n.getName() ) + 
				String.format("%-10s", n.getQty() ) + 
				String.format("%-20s", n.getPrice() ) +
				String.format("%-20s", (n.getMenuType().toString()) )
				);
	}
	
	public void printItemNoPrice(MenuItem n){
		System.out.println(n.getItemId() + "\t" +
						n.getName() + "\t" +
						(n.getMenuType().toString())
						);
	}
	
	//for package
	public void printPack(OrderPromotionPackage p){
		System.out.println(String.format("%-10s", p.getPackageId() )+ 
				String.format("%-20s", p.getPackageName() )+
				String.format("%-10s", p.getQty() )+ 
				String.format("%-20s", p.getPackagePrice() )
				);
		
		ArrayList<MenuItem> temp = p.getListOfMenuItem();
		System.out.println("Package contents: ");
		temp.forEach((foo) -> printItemNoPrice(foo));
		//^ but without the item price
		
	}
	

	public OrderMenuItem getOrderMenuItem(int itemId) {
		for(OrderMenuItem ord: listOfOrderItems) {
			if( ord.getItemId() == itemId) {
				return ord;
			}
		}
		//doesn't exist.
		return null;
	}
	
	
	public OrderPromotionPackage getOrderPromotionPackage(int packageId) {
		for(OrderPromotionPackage pek: listOfOrderPromotions) {
			if( pek.getPackageId() == packageId) {
				return pek;
			}
		}
		//doesn't exist
		return null;
	}







}
