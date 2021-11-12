package invoice;

//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import order.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;



public class Invoice {

	private int invoiceId;
	private Order ord;
	private int orderId;
	private int tableId;
	//private String timestamp;
	
	//if using calender instead of LocalDateTime
	//private LocalDateTime dt;
	
	private Calendar timestamp;
	private double totalPrice;
	private double discount;
	private double tax;
	private double grandTotal;
	
	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy,HH:mm");

	
	public Invoice(int invoiceId, int orderId, int tableId, double totalPrice, Calendar timestamp, double discount, Order ord) {
		this.invoiceId = invoiceId;
		this.orderId = orderId;
		this.tableId = tableId;
		this.totalPrice = totalPrice;
		this.timestamp = timestamp;
		this.discount = discount;
		this.tax = totalPrice*0.17;
		this.grandTotal = (totalPrice + tax) - discount;
		this.ord = ord;
	}

	public int getInvoiceId() {
		return this.invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Order getOrder() {
		return this.ord;
	}
	public void setOrder(Order ord) {
		this.ord = ord;
	}
	public int getTableId() {
		return this.tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTimestamp() {
		Date adate = timestamp.getTime();
		String strDate = sdf.format(adate);
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
	public double getTotalPrice() {
		return this.totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderId() {
		return this.orderId;
	}
	public void setOrderId(int orderId) {
		// TODO - implement Invoice.setorderId
		//throw new UnsupportedOperationException();
		this.orderId = orderId;
	}
	public double getDiscount() {
		return this.discount;
	}
	public void setDiscount(double disc) {
		this.discount = disc;
	}
	public double getTax() {
		return this.tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getGrandTotal() {
		return this.grandTotal;
	}
	public void setGrandTotal(double gt) {
		this.grandTotal = gt;
	}
	public Calendar getCalTime(){
		return this.timestamp;
	}
	
}
