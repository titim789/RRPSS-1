package order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import menu.MenuItem;
import menu.PromotionPackage;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * An order is created when a customer places an order with the restaurant.
 * It contains a list of order menu items and a list of promotion packages that has been added to this order
 * @author Trevor
 *
 */
public class Order implements Serializable{

	/**
	 * The order ID pertaining to this order
	 */
	private int orderId;
	
	/**
	 * The ID of the staff who is in charge of this order
	 */
	private int staffId;
	
	/**
	 * The ID of the table for which this order has been created for
	 */
	private int tableId;
	
	/**
	 * The ID of the customer making the order
	 */
	private int customerId;
	
	/**
	 * The cumulative price of all items and packages in this order
	 */
	private double orderPrice;

	/**
	 * The list of ala carte items ordered
	 */
	private ArrayList<OrderMenuItem> listOfOrderItems;
	
	/**
	 * The list of promotion packages ordered
	 */
	private ArrayList<OrderPromotionPackage> listOfOrderPromotions;
	
	/**
	 * The time of creation of this order
	 */
	private Calendar timestamp;
	
	/**
	 * The format for which to output timestamps
	 */
	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy,HH:mm");

	/**
	 * This creates an order,
	 * as well as the lists of ala carte items and promotion packages
	 * @param orderId The ID of the order
	 * @param staffId The ID of the staff creating this order
	 * @param customerId The ID of the customer making this order
	 * @param tableId The ID of the table for which this order is made for
	 * @param timestamp The time that this order has been made
	 */
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
	
	/**
	 * Gets the ID of this order
	 * @return This order's ID
	 */
	public int getOrderId() {
		return this.orderId;
	}
	
	/**
	 * Sets the ID of this order
	 * @param orderId The order ID to be set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Gets the ID of the staff who created this order
	 * @return The ID of the staff who created this order
	 */
	public int getStaffId() {
		return this.staffId;
	}
	
	/**
	 * Sets the ID of the staff who created this order
	 * @param staffId The ID of the staff who created this order
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	
	/**
	 * Gets the ID of the table for which this invoice was created for
	 * @return The ID of the table for which this invoice was created for
	 */
	public int getTableId() {
		return this.tableId;
	}
	
	/**
	 * Sets the ID of the table for which this invoice was created for
	 * @param tableId The ID of the table for which this invoice was created for
	 */
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	/**
	 * Gets the ID of the customer who made this order
	 * @return The ID of the customer who made this order
	 */
	public int getCustomerId() {
		return this.customerId;
	}
	
	/**
	 * Sets the ID of the customer who made this order
	 * @param customerId The ID of the customer who made this order
	 */
	public void setCustomerId(int customerId) {
		this.customerId= customerId;
	}
	
	/**
	 * Gets the total price of this order, before taxes and discounts
	 * @return The total price of this order, before taxes and discounts
	 */
	public double getOrderPrice() {
		return this.orderPrice;
	}
	
	/**
	 * Sets the total price of this order, before taxes and discounts
	 * @param orderPrice The total price of this order, before taxes and discounts
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	/**
	 * Gets the time when this order was created
	 * @return The time when this order was created
	 */
	public String getTimestamp() {
		Date datey = timestamp.getTime();
		String strDate = sdf.format(datey);
		return strDate;
	}
	
	/**
	 * Sets the time when this order was created
	 * @param timestamp The time when this order was created
	 */
	public void setTimestamp(String timestamp) {
		try {
			Date datey = sdf.parse(timestamp);
			Calendar caley = Calendar.getInstance();
			caley.setTime(datey);
			this.timestamp = caley;
		}catch(ParseException e) {}
	}
	
	/**
	 * Adds an ala carte item to this order
	 * @param item The item to add to this order
	 */
	public void addOrderItem(OrderMenuItem item) {
		listOfOrderItems.add(item);
		orderPrice += item.getPrice();
		System.out.println(item.getName()+" added.");
	}


	/**
	 * Removes an item from this order
	 * @param item The item to remove from this order
	 */
	public void removeOrderItem(OrderMenuItem item) {
		if(listOfOrderItems.remove(item)) {
			System.out.println("Successfully Removed");
			orderPrice -= item.getPrice();
		}
		else {
			System.out.println("Error.");
		}
	}

	/**
	 * Adds a promotion package to this order
	 * @param pack The promotion package to add to this order
	 */
	public void addPromotion(OrderPromotionPackage pack) {
		listOfOrderPromotions.add(pack);
		orderPrice += pack.getPackagePrice();
		System.out.println(pack.getPackageName()+" added.");
	}

	/**
	 * Removes a promotion package from this order
	 * @param pack The promotion package to remove from this order
	 */
	public void removePromotion(OrderPromotionPackage pack) {
		if(listOfOrderPromotions.remove(pack)) {
			System.out.println("Successfully Removed");
			orderPrice -= pack.getPackagePrice();
		}
		else {
			System.out.println("Error.");
		}
	}
	
	/**
	 * Views the contents of this order
	 */
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
				listOfOrderPromotions.forEach((n) -> printPack(n));
				System.out.println("\n");	
			}
		}
	}
	
	/**
	 * View the contents of each order line
	 * @param n The order line for which we want to view the order items
	 */
	public void printItem(OrderMenuItem n){
		System.out.println(String.format("%-10s", n.getItemId() ) + 
				String.format("%-20s", n.getName() ) + 
				String.format("%-10s", n.getQty() ) + 
				String.format("%-20s", n.getPrice() ) +
				String.format("%-20s", (n.getMenuType().toString()) )
				);
	}
	
	/**
	 * Prints the items without the price
	 * @param n
	 */
	public void printItemNoPrice(MenuItem n){
		System.out.println("\t" + n.getItemId() + "\t" +
						n.getName() + "\t" +
						(n.getMenuType().toString())
						);
	}
	
	/**
	 * Prints the items in a promotion package
	 * @param p
	 */
	public void printPack(OrderPromotionPackage p){
		System.out.println(String.format("%-10s", "PackID") + 
				String.format("%-20s", "Package name") +
				String.format("%-10s", "Quantity") + 
				String.format("%-20s","Package price (each)")
				);
		System.out.println(String.format("%-10s", p.getPackageId() )+ 
				String.format("%-20s", p.getPackageName() )+
				String.format("%-10s", p.getQty() )+ 
				String.format("%-20s", p.getPackagePrice())
				);
		
		ArrayList<MenuItem> temp = p.getListOfMenuItem();
		System.out.println("\t" + "Package contents: ");
		temp.forEach((foo) -> printItemNoPrice(foo));
		System.out.println();
		//^ but without the item price
		
	}
	
	/**
	 * Gets the order menu item line, using the item ID
	 * @param itemId The Item ID of the order menu item line we are looking for
	 * @return The order menu item line
	 */
	public OrderMenuItem getOrderMenuItem(int itemId) {
		for(OrderMenuItem ord: listOfOrderItems) {
			if( ord.getItemId() == itemId) {
				return ord;
			}
		}
		//doesn't exist.
		return null;
	}
	
	/**
	 * Gets the order promotion package line, using the package ID
	 * @param packageId The package ID of the order promotion package line we are looking for
	 * @return The order promotion package line
	 */
	public OrderPromotionPackage getOrderPromotionPackage(int packageId) {
		for(OrderPromotionPackage pek: listOfOrderPromotions) {
			if( pek.getPackageId() == packageId) {
				return pek;
			}
		}
		//doesn't exist
		return null;
	}
	
	/**
	 * Gets the list of order menu items
	 * @return The list of order menu items
	 */
	public ArrayList<OrderMenuItem> getListOfOrderItems() {
		return listOfOrderItems;
	}
	
	/**
	 * Gets the list of order promotion packages
	 * @return The list of order promotion packages
	 */
	public ArrayList<OrderPromotionPackage> getListOfOrderPromotions(){
		return listOfOrderPromotions;
	}
	
	
	
}
