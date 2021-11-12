package invoice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import order.Order;

//import Menu.MenuItem;

import java.util.Date;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//import java.text.SimpleDateFormat;


/**
 * The control class of invoice entities. 
 * Contains the list of invoices.
 * For information on each invoice in the list, please visit invoice
 * @author Trevor
 *
 */
public class InvoiceMgr {
	/**
	 * The list of invoices that this control class manages
	 */
	private ArrayList<Invoice> listOfInvoice;
	
	/**
	 * When instantiating this manager, it will create a list of invoices
	 */
	public InvoiceMgr() {
		listOfInvoice = new ArrayList<Invoice>();
	}
	
	/**
	 * This generates the sales report for the current month,
	 * comprising the invoices created in this month, together with their order contents and the total revenue for this period
	 */
	public void generateSalesReport(){
		Date dte = new Date();
		Calendar tdy = Calendar.getInstance();
		tdy.setTime(dte);
		//int tdyDate = tdy.get(Calendar.DATE);
		int tdyMonth = tdy.get(Calendar.MONTH);
		int tdyYear = tdy.get(Calendar.YEAR);
		double revenue=0;
		for(int i=0;i<listOfInvoice.size();i++) {
			if( ( ( (listOfInvoice.get(i)).getCalTime() ).get(Calendar.MONTH) == tdyMonth) 
				&&
				( ( (listOfInvoice.get(i)).getCalTime() ).get(Calendar.YEAR) == tdyYear)	
			  ){
				System.out.println("Invoice "+i+": ");
				(listOfInvoice.get(i).getOrder()).viewOrder();
				revenue += listOfInvoice.get(i).getGrandTotal();
			}
		}
		
		System.out.printf("Total Revenue: $%.2f\n\n",revenue);
	}
	
	/**
	 * This generates the sales report for a certain period,
	 * comprising the invoices created in this period, together with their order contents and the total revenue for this period
	 * @param str The start date for which to include invoices
	 * @param s The end date for which to include invoices
	 */
	public void generateSalesReport(String str, String s){
		//splitting into date month year
		String[] stringarray = str.split("/");
		int sd,sm,sy;
		sd = Integer.parseInt(stringarray[0]);
		sm = Integer.parseInt(stringarray[1]);
		sy = Integer.parseInt(stringarray[2]);
		
		Calendar startDate = Calendar.getInstance();
		startDate.set(Calendar.YEAR, sy);
		startDate.set(Calendar.MONTH, sm);
		startDate.set(Calendar.DAY_OF_MONTH, sd);
		
		String[] sarray = s.split("/");
		int ed,em,ey;
		ed = Integer.parseInt(sarray[0]);
		em = Integer.parseInt(sarray[1]);
		ey = Integer.parseInt(sarray[2]);
		
		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.YEAR, ey);
		endDate.set(Calendar.MONTH, em);
		endDate.set(Calendar.DAY_OF_MONTH, ed);
		
		double revenue=0;
		
		for(int i=0;i<listOfInvoice.size();i++) {
			if( ( (listOfInvoice.get(i)).getCalTime()).compareTo(startDate) >= 0 ) {
				if( ( (listOfInvoice.get(i)).getCalTime()).compareTo(endDate) <= 0 ) {
					System.out.println("Invoice "+i+": ");
					(listOfInvoice.get(i).getOrder()).viewOrder();
					revenue += listOfInvoice.get(i).getGrandTotal();
				}
			}
			
		}
		
		System.out.printf("Total revenue for this period: $%.2f", revenue);
	}
	
	/**
	 * Checks if an invoice for a given ID exists.
	 * @param invId The ID for which to check if an invoice exists for
	 * @return True if the invoice exists, False otherwise.
	 */
	public boolean isExists(int invId) {
		if(invId>=listOfInvoice.size()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the current number of invoices in the list
	 * @return The number of invoices in the list
	 */
	public int currentSize() {
		return listOfInvoice.size();
	}
	
	/**
	 * Creates a new invoice for a specific order.
	 * Also applies the appropriate discount (10% if they are a member)
	 * @param ord The order for which this invoice will be created for
	 * @param isMember Whether the customer is a member
	 */
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
	
	/**
	 * Prints the invoice if it exists
	 * @param invoiceId The ID for which to print the invoice
	 */
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
		System.out.println("Total Price: "+listOfInvoice.get(invoiceId).getTotalPrice());
		System.out.printf("Tax: %.2f\n", listOfInvoice.get(invoiceId).getTax());
		System.out.printf("Discount: %.2f\n", listOfInvoice.get(invoiceId).getDiscount());
		System.out.printf("GRAND TOTAL: %.2f\n\n", listOfInvoice.get(invoiceId).getGrandTotal());
	}

	/**
	 * Saves the invoices in the list to a file that can be stored even if the system has shut down
	 */
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
	
	/**
	 * Loads the invoices that have been previously saved to a file
	 */
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
}



