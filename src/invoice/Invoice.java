package invoice;

//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import order.Order;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * An invoice is generated and serves as a receipt for customers. It contains the order, as well as calculation of final prices.
 * @author Trevor
 *
 */
public class Invoice implements Serializable{

	/**
	 * the ID of the invoice
	 */
	private int invoiceId;
	
	/**
	 * The contents of the invoice
	 */
	private Order ord;
	
	/**
	 * the order ID corresponding to the invoice
	 */
	private int orderId;
	
	/**
	 * the table ID corresponding to the invoice
	 */
	private int tableId;
	
	/**
	 * the time and date of the invoice
	 */
	private Calendar timestamp;
	
	/**
	 * this price refers to the subtotal price, before adding tax and before deducting discount (if any)
	 */
	private double totalPrice;
	
	/**
	 * this is the amount of discount in absolute dollars
	 */
	private double discount;
	
	/**
	 * this is the amount of tax to be added in absolute dollars
	 */
	private double tax;
	
	/**
	 * this is the final price that the customer is to pay
	 */
	private double grandTotal;
	
	/**
	 * this is the format in which we will output the date time with
	 */
	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy,HH:mm");

	/**
	 * This creates an invoice
	 * @param invoiceId This invoice's ID
	 * @param orderId This invoices's order ID
	 * @param tableId This invoice's table ID
	 * @param totalPrice The subtotal before adding tax and before deducting discount
	 * @param timestamp The timestamp of creation of this invoice
	 * @param discount This invoice's discount in absolute dollars
	 * @param ord The contents of the order for which we will generate the invoice
	 */
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

	/**
	 * Gets the ID of this invoice
	 * @return this invoice's ID
	 */
	public int getInvoiceId() {
		return this.invoiceId;
	}
	
	/**
	 * Sets the ID of this invoice
	 * @param invoiceId The invoice's ID to be set
	 */
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	/**
	 * Gets the order contents of this invoice
	 * @return The order of this invoice, in an Order object
	 */
	public Order getOrder() {
		return this.ord;
	}
	
	/**
	 * Sets the order contents of this invoice
	 * @param ord The order contents to be set in this invoice
	 */
	public void setOrder(Order ord) {
		this.ord = ord;
	}
	
	/**
	 * Gets the table for which this invoice has been created for
	 * @return The table for which this invoice has been created for
	 */
	public int getTableId() {
		return this.tableId;
	}
	
	/**
	 * Sets the table for which this invoice has been created for
	 * @param tableId The table for which this invoice has been created for
	 */
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	/**
	 * Gets the timestamp in the "dd/MM/yyyy,HH:mm" format
	 * @return The timestamp in the "dd/MM/yyyy,HH:mm" format
	 */
	public String getTimestamp() {
		Date adate = timestamp.getTime();
		String strDate = sdf.format(adate);
		return strDate;
	}
	
	/**
	 * Sets the timestamp for this invoice
	 * @param timestamp The current timestamp of creation of this invoice
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
	 * Get the subtotal of the order before adding tax and before deducting discount
	 * @return The subtotal of the order before adding tax and before deducting discount
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	/**
	 * Set the subtotal of the order before adding tax and before deducting discount
	 * @param totalPrice The subtotal of the order before adding tax and before deducting discount
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Gets the orderID for which this invoice has been created for
	 * @return The orderID for which this invoice has been created for
	 */
	public int getOrderId() {
		return this.orderId;
	}
	
	/**
	 * Sets the orderID for which this invoice has been created for
	 * @param orderId The orderID for which this invoice has been created for
	 */
	public void setOrderId(int orderId) {
		// TODO - implement Invoice.setorderId
		//throw new UnsupportedOperationException();
		this.orderId = orderId;
	}
	
	/**
	 * Gets the amount of discount in absolute dollars
	 * @return The amount of discount in absolute dollars
	 */
	public double getDiscount() {
		return this.discount;
	}
	
	/**
	 * Sets the amount of discount in absolute dollars
	 * @param disc The amount of discount in absolute dollars
	 */
	public void setDiscount(double disc) {
		this.discount = disc;
	}
	
	/**
	 * Gets the amount of tax to be paid
	 * @return The amount of tax to be paid
	 */
	public double getTax() {
		return this.tax;
	}
	
	/**
	 * Sets the amount of tax to be paid
	 * @param tax The amount of tax to be paid
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	/**
	 * Gets the grand total the customer will pay for
	 * @return The grand total the customer will pay for
	 */
	public double getGrandTotal() {
		return this.grandTotal;
	}
	
	/**
	 * Sets the grand total the customer will pay for
	 * @param gt The grand total the customer will pay for
	 */
	public void setGrandTotal(double gt) {
		this.grandTotal = gt;
	}
	
	/**
	 * Gets the time this invoice was created, in calendar object form
	 * @return The time this invoice was created, in calendar object form
	 */
	public Calendar getCalTime(){
		return this.timestamp;
	}
	
}
