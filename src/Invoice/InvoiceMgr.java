package Invoice;

import Order.Order;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
//import java.text.SimpleDateFormat;



public class InvoiceMgr {
	
	private ArrayList<Invoice> listOfInvoice = new ArrayList<Invoice>();
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

	/*
	public void save() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("inv.txt", true));
		BufferedReader br = new BufferedReader(new FileReader("inv.txt"));
		//wait how to save an arraylist of items in a csv???
		
	}
	*/
/*
	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
*/
	
}



