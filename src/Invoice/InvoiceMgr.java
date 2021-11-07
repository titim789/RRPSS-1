package Invoice;

import Order.Order;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

//import Menu.MenuItem;

import java.util.Date;
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
		
	}
	
	public void generateSalesReport(){
		int opt = 0;
		System.out.println("1. Generate report for today\n2.Generate report for this month\n");
		Scanner sk = new Scanner(System.in);
		opt = sk.nextInt();
		//check if invalid input.
		
		Date dte = new Date();
		Calendar tdy = Calendar.getInstance();
		tdy.setTime(dte);
		int tdyDate = tdy.get(Calendar.DATE);
		int tdyMonth = tdy.get(Calendar.MONTH);
		double revenue=0;
		
		switch (opt) {
		case 1: 
			System.out.println("\n");
			for(int i=0;i<listOfInvoice.size();i++) {
				if( ((listOfInvoice.get(i)).getCalTime()).get(Calendar.DATE) == tdyDate) {
					System.out.println("Invoice "+i+": ");
					(listOfInvoice.get(i).getOrder()).viewOrder();
					revenue += listOfInvoice.get(i).getGrandTotal();
				}
			}
			System.out.println("Total Revenue: $"+ revenue);
			break;
		case 2:
			for(int i=0;i<listOfInvoice.size();i++) {
				if( ((listOfInvoice.get(i)).getCalTime()).get(Calendar.MONTH) == tdyMonth) {
					System.out.println("Invoice "+i+": ");
					(listOfInvoice.get(i).getOrder()).viewOrder();
					revenue += listOfInvoice.get(i).getGrandTotal();
				}
			}
			System.out.println("Total Revenue: $"+ revenue);
			break;
		default:
			
		}
		sk.close();
	}
	
	public void generateSalesReportDates(){
		String str;
		System.out.println("Input start date (inclusive) in DD/MM/YYYY format: ");
		Scanner sk = new Scanner(System.in);
		str = sk.nextLine();
		//to do: check if invalid input.
		
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
		
		String s;
		System.out.println("Input end date (inclusive) in DD/MM/YYYY format: ");
		//to do: check if valid input.
		s = sk.nextLine();
		String[] sarray = s.split("/");
		int ed,em,ey;
		ed = Integer.parseInt(stringarray[0]);
		em = Integer.parseInt(stringarray[1]);
		ey = Integer.parseInt(stringarray[2]);
		
		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.YEAR, sy);
		endDate.set(Calendar.MONTH, sm);
		endDate.set(Calendar.DAY_OF_MONTH, sd);
		
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
		
		System.out.println("Total revenue for this period: $"+ revenue);
		sk.close();
	}
	
	/*
	 * not necessary to update invoices? Printed = customer paid and left alr.
	public void updateInvoice(int invoiceId) {
		
	}
	*/
	
	public void newInvoice(Order ord, boolean isMember) {
		int invoiceId = listOfInvoice.size();
		int orderId = ord.getorderId();
		int tableId = ord.gettableId();
		double totalPrice = ord.getorderPrice();
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
		System.out.println("\nPrinting InvoiceId: "+ invoiceId);
		System.out.println("For OrderId: "+ listOfInvoice.get(invoiceId).getOrderId());
		String datey = listOfInvoice.get(invoiceId).getTimestamp();
		System.out.println("Date Time: "+ datey);
		System.out.println("TableId: "+ listOfInvoice.get(invoiceId).getTableId());
		System.out.println("\n---Items ordered:----");
		listOfInvoice.get(invoiceId).getOrder().viewOrder();
		System.out.println("------------------");
		System.out.println("Total Price: "+listOfInvoice.get(invoiceId).getTotalPrice());
		System.out.println("Tax: "+ listOfInvoice.get(invoiceId).getTax());
		System.out.println("Discount: "+ listOfInvoice.get(invoiceId).getDiscount());
		System.out.println("GRAND TOTAL: "+ listOfInvoice.get(invoiceId).getGrandTotal());
	}

	
	public void save() throws IOException {
		try{
		    FileOutputStream writeData = new FileOutputStream("invoice.txt");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(listOfInvoice);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	public void load() throws IOException{
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



