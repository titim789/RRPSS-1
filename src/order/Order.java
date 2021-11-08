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
	private ArrayList<MenuItem> listOfOrderItems = new ArrayList<MenuItem>();
	private ArrayList<PromotionPackage> listOfOrderPromotions = new ArrayList<PromotionPackage>();
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
		
	}
	

	public int getorderId() {
		return this.orderId;
	}
	public void setorderId(int orderId) {
		this.orderId = orderId;
	}
	public int getstaffId() {
		return this.staffId;
	}
	public void setstaffId(int staffId) {
		this.staffId = staffId;
	}
	public int gettableId() {
		return this.tableId;
	}
	public void settableId(int tableId) {
		this.tableId = tableId;
	}
	public int getcustomerId() {
		return this.customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId= customerId;
	}
	public double getorderPrice() {
		return this.orderPrice;
	}
	public void setorderPrice(double orderPrice) {
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
	
	
	
	public void addOrderItem(MenuItem item) {
		listOfOrderItems.add(item);
		orderPrice += item.getPrice();
		System.out.println(item.getName()+" added.");
	}


	//param change to MenuItem
	public void removeOrderItem(MenuItem item) {
		if(listOfOrderItems.remove(item)) {
			System.out.println("Successfully Removed");
			orderPrice -= item.getPrice();
		}
		else {
			System.out.println("Error.");
		}
	}

	//param change to PromoItem
	public void addPromotion(PromotionPackage pack) {
		listOfOrderPromotions.add(pack);
		orderPrice += pack.getPackagePrice();
		System.out.println(pack.getPackageName()+" added.");
	}

	//param change to PromoItem
	public void removePromotion(PromotionPackage pack) {
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
		
		
		//if empty then println that is all empty. <- either in ctrl or here
		
		System.out.println("Ala carte items: ");
		System.out.println("Item ID" + "\t" + "Item name" + "\t" + "Item price" + "\t" + "Type");
		listOfOrderItems.forEach((n) -> printItem(n));
		
		System.out.println("\nPromotion Package items: ");
		System.out.println("\nPackage ID" + "\t" + "Package name" + "\t" + "Package price");
		listOfOrderPromotions.forEach((n) -> printPack(n));
		
	}
	
	//another method to print the stuff
	public void printItem(MenuItem n){
		System.out.println(n.getItemId() + "\t" + n.getName() + "\t" + n.getPrice() + "\t" + (n.getMenuType().toString()));
	}
	
	public void printItemNoPrice(MenuItem n){
		System.out.println(n.getItemId() + "\t" + n.getName() + "\t" + (n.getMenuType().toString()));
	}
	
	//for package
	public void printPack(PromotionPackage p){
		System.out.println(p.getPackageId() + "\t" + p.getPackageName() + "\t" + p.getPackagePrice());
		
		ArrayList<MenuItem> temp = p.getListOfMenuItem();
		System.out.println("Package contents: ");
		temp.forEach((foo) -> printItemNoPrice(foo));
		//^ but without the item price
		
	}
	









}
