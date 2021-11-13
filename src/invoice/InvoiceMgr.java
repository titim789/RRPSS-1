package invoice;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Scanner;

import order.Order;
import order.OrderMenuItem;
import order.OrderPromotionPackage;

//import Menu.MenuItem;

import java.util.Date;
import java.util.GregorianCalendar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//import java.text.SimpleDateFormat;



public class InvoiceMgr {
	
	private ArrayList<Invoice> listOfInvoice;
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy,HH:mm");
	
	//private static final SimpleDateFormat justDates = new SimpleDateFormat("dd/MM/yyyy");
	
	public InvoiceMgr() {
		listOfInvoice = new ArrayList<Invoice>();
		load();
	}
	
	
	public void generateSalesReport(){
		ArrayList<Order> listOfOrders = new ArrayList<Order>();
		ArrayList<String> listOfMenuItems = new ArrayList<String>();
		ArrayList<Double> listOfItemRevenue = new ArrayList<Double>();
		ArrayList<String> listOfPromotion = new ArrayList<String>();
		ArrayList<Double> listOfPromotionRevenue = new ArrayList<Double>();
		
		int i, j;
		Date dte = new Date();
		Calendar tdy = Calendar.getInstance();
		tdy.setTime(dte);
		//int tdyDate = tdy.get(Calendar.DATE);
		int tdyMonth = tdy.get(Calendar.MONTH);
		int tdyYear = tdy.get(Calendar.YEAR);
		for(i=0;i<listOfInvoice.size();i++) {
			if( ( ( (listOfInvoice.get(i)).getCalTime() ).get(Calendar.MONTH) == tdyMonth) 
				&&
				( ( (listOfInvoice.get(i)).getCalTime() ).get(Calendar.YEAR) == tdyYear)	
			  ){
				listOfOrders.add(listOfInvoice.get(i).getOrder());
			}
		}
		ArrayList<OrderMenuItem> tempMenuItem;
		ArrayList<OrderPromotionPackage> tempPromotionPackage;
		String tempName;
		double tempPrice, totalRevenue=0;
	
		for(i=0;i<listOfOrders.size();i++){
			tempMenuItem = listOfOrders.get(i).getListOfOrderItems();
			tempPromotionPackage = listOfOrders.get(i).getListOfOrderPromotions();
			for(j=0;j<tempMenuItem.size();j++){
				tempName = tempMenuItem.get(j).getName();
				tempPrice = tempMenuItem.get(j).getQtyPrice();
				if(!listOfMenuItems.contains(tempName)){
					listOfMenuItems.add(tempName);
					listOfItemRevenue.add(tempPrice);
				}else{
					listOfItemRevenue.set(listOfMenuItems.indexOf(tempName), listOfItemRevenue.get(listOfMenuItems.indexOf(tempName)) + tempPrice);
				}
				totalRevenue += tempPrice;
			}
			for(j=0;j<tempPromotionPackage.size();j++){
				tempName = tempPromotionPackage.get(j).getPackageName();
				tempPrice = tempPromotionPackage.get(j).getQtyPrice();
				if(!listOfPromotion.contains(tempName)){
					listOfPromotion.add(tempName);
					listOfPromotionRevenue.add(tempPrice);
				}else{
					listOfPromotionRevenue.set(listOfPromotion.indexOf(tempName), listOfPromotionRevenue.get(listOfPromotion.indexOf(tempName)) + tempPrice);
				}
				totalRevenue += tempPrice;
			}
		}
		
		System.out.println("Menu Items");
		System.out.println(String.format("%-20s", "Name") + "|" + "Revenue\t|");
		for(i=0;i<listOfMenuItems.size();i++){
				System.out.println(String.format("%-20s", listOfMenuItems.get(i)) + "|" + String.format("%.2f", listOfItemRevenue.get(i)) + "\t|");
		}
		System.out.println("\n\nPromotion Package");
		System.out.println(String.format("%-20s", "Name") + "|" + "Revenue\t|");
		for(i=0;i<listOfPromotion.size();i++){
				System.out.println(String.format("%-20s", listOfPromotion.get(i)) + "|" + String.format("%.2f", listOfPromotionRevenue.get(i)) + "\t|");
		}
		System.out.println("\n\nTotal Revenue: " + String.format("%.2f", totalRevenue));
	}
	
	

public void generateSalesReport(String str, String s){
		//to do: check if invalid input.
		ArrayList<Order> listOfOrders = new ArrayList<Order>();
		ArrayList<String> listOfMenuItems = new ArrayList<String>();
		ArrayList<Double> listOfItemRevenue = new ArrayList<Double>();
		ArrayList<String> listOfPromotion = new ArrayList<String>();
		ArrayList<Double> listOfPromotionRevenue = new ArrayList<Double>();
		
		int i, j;
		
		//splitting into date month year
		String[] stringarray = str.split("/");
		int sd,sm,sy;
		sd = Integer.parseInt(stringarray[0]);
		sm = Integer.parseInt(stringarray[1])-1;
		sy = Integer.parseInt(stringarray[2]);
		
		Calendar startDate = new GregorianCalendar(sy,sm,sd);
		
		String[] sarray = s.split("/");
		int ed,em,ey;
		ed = Integer.parseInt(sarray[0])+1;
		em = Integer.parseInt(sarray[1])-1;
		ey = Integer.parseInt(sarray[2]);
		
		Calendar endDate = new GregorianCalendar(ey,em,ed);
		
		
		for(i=0;i<listOfInvoice.size();i++) {
			if( ( (listOfInvoice.get(i)).getCalTime()).compareTo(startDate) >= 0 ) {
				if( ( (listOfInvoice.get(i)).getCalTime()).compareTo(endDate) <= 0 ) {
					listOfOrders.add(listOfInvoice.get(i).getOrder());
				}
			}
			
		}
		
		ArrayList<OrderMenuItem> tempMenuItem;
		ArrayList<OrderPromotionPackage> tempPromotionPackage;
		String tempName;
		double tempPrice, totalRevenue=0;
	
		for(i=0;i<listOfOrders.size();i++){
			tempMenuItem = listOfOrders.get(i).getListOfOrderItems();
			tempPromotionPackage = listOfOrders.get(i).getListOfOrderPromotions();
			for(j=0;j<tempMenuItem.size();j++){
				tempName = tempMenuItem.get(j).getName();
				tempPrice = tempMenuItem.get(j).getQtyPrice();
				if(!listOfMenuItems.contains(tempName)){
					listOfMenuItems.add(tempName);
					listOfItemRevenue.add(tempPrice);
				}else{
					listOfItemRevenue.set(listOfMenuItems.indexOf(tempName), listOfItemRevenue.get(listOfMenuItems.indexOf(tempName)) + tempPrice);
				}
				totalRevenue += tempPrice;
			}
			for(j=0;j<tempPromotionPackage.size();j++){
				tempName = tempPromotionPackage.get(j).getPackageName();
				tempPrice = tempPromotionPackage.get(j).getQtyPrice();
				if(!listOfPromotion.contains(tempName)){
					listOfPromotion.add(tempName);
					listOfPromotionRevenue.add(tempPrice);
				}else{
					listOfPromotionRevenue.set(listOfPromotion.indexOf(tempName), listOfPromotionRevenue.get(listOfPromotion.indexOf(tempName)) + tempPrice);
				}
				totalRevenue += tempPrice;
			}
		}
		
		System.out.println("Menu Items");
		System.out.println(String.format("%-20s", "Name") + "|" + "Revenue\t|");
		for(i=0;i<listOfMenuItems.size();i++){
				System.out.println(String.format("%-20s", listOfMenuItems.get(i)) + "|" + String.format("%.2f", listOfItemRevenue.get(i)) + "\t|");
		}
		System.out.println("\n\nPromotion Package");
		System.out.println(String.format("%-20s", "Name") + "|" + "Revenue\t|");
		for(i=0;i<listOfPromotion.size();i++){
				System.out.println(String.format("%-20s", listOfPromotion.get(i)) + "|" + String.format("%.2f", listOfPromotionRevenue.get(i)) + "\t|");
		}
		System.out.println("\n\nTotal Revenue: " + String.format("%.2f", totalRevenue));
}
	
	/*
	 * not necessary to update invoices? Printed = customer paid and left alr.
	public void updateInvoice(int invoiceId) {
		
	}
	*/
	
	public boolean isExists(int invId) {
		if(invId>=listOfInvoice.size()) {
			return false;
		}
		return true;
	}
	
	public int currentSize() {
		return listOfInvoice.size();
	}
	
	public void newInvoice(Order ord, boolean isMember) {
		int invoiceId = listOfInvoice.size();
		int orderId = ord.getOrderId();
		int tableId = ord.getTableId();
		double totalPrice = ord.getOrderPrice();
		double discount=0;

		if(isMember) {
			discount = 0.1*totalPrice;
		}
		
		Calendar caley = Calendar.getInstance();
	    
		Invoice inv = new Invoice(invoiceId, orderId, tableId,
				totalPrice, caley, discount, ord);
		listOfInvoice.add(inv);		
	}
	
	public void printInvoice(int invoiceId) {
		if(invoiceId>=listOfInvoice.size()) {
			System.out.println("Invoice does not exist. Create before printing.");
			return;
		}
		
		System.out.println("\nPrinting InvoiceId: "+ invoiceId);
		System.out.println("For OrderId: "+ listOfInvoice.get(invoiceId).getOrderId());
		String datey = listOfInvoice.get(invoiceId).getTimestamp();
		System.out.println("Date Time: "+ datey);
		System.out.println("TableId: "+ listOfInvoice.get(invoiceId).getTableId());
		System.out.println("\n---Items ordered:----");
		listOfInvoice.get(invoiceId).getOrder().viewOrder();
		System.out.println("------------------");
		System.out.printf("Total Price: %.2f\n",listOfInvoice.get(invoiceId).getTotalPrice());
		System.out.printf("Tax: %.2f\n", listOfInvoice.get(invoiceId).getTax());
		System.out.printf("Discount: %.2f\n", listOfInvoice.get(invoiceId).getDiscount());
		System.out.printf("GRAND TOTAL: %.2f\n\n", listOfInvoice.get(invoiceId).getGrandTotal());
	}

	
	public void save(){
		try{
		    FileOutputStream writeData = new FileOutputStream("invoice.txt");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
		    writeStream.writeObject(listOfInvoice);
		    //writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void load(){
		try{
		    FileInputStream readData = new FileInputStream("invoice.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfInvoice = (ArrayList<Invoice>) readStream.readObject();
		    readStream.close();
		    //System.out.println(listOfMenuItems.toString());
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	
	
/*
	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
*/
	
}



