package order;

import java.util.ArrayList;

import menu.MenuItem;
import menu.PromotionPackage;

/**
 * This is an extention of promotion package, 
 * which includes the quantity ordered, as well as its price multiplied by the quantity
 * @author Trevor
 *
 */
public class OrderPromotionPackage extends PromotionPackage{
	
	/**
	 * The quantity of the promotion package ordered
	 */
	private int qty;
	
	/**
	 * The price of each of the promotion package multiplied by the ordered quantity
	 */
	private double qtyPrice;
	
	/**
	 * Creates the promotion package item line with the quantity ordered
	 * @param packageId The ID of the promotion package ordered
	 * @param packageName The name of the promotion package ordered
	 * @param packagePrice The individual price of the promotion package ordered
	 * @param packageDescription The description of the promotion package ordered
	 * @param listOfMenuItem The list of menu items that the promotion package contains
	 * @param qty The quantity of the promotion package ordered
	 */
	public OrderPromotionPackage(int packageId, String packageName, double packagePrice,
			String packageDescription, ArrayList<MenuItem> listOfMenuItem, int qty) {
		super(packageId, packageName, packagePrice, packageDescription, listOfMenuItem);
		this.qty = qty;
		this.qtyPrice = packagePrice * qty;
		//super.setPackagePrice(packagePrice*qty);
	}
	
	/**
	 * Gets the quantity of the promotion package ordered
	 * @return The quantity of the promotion package ordered
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * Sets the quantity of the promotion package ordered
	 * @param qty The quantity of the promotion package ordered
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	/**
	 * Gets the price of the promotion package ordered multiplied by the ordered quantity
	 * @return The price of the promotion package ordered multiplied by the ordered quantity
	 */
	public double getQtyPrice() {
		return qtyPrice;
	}

	/**
	 * Sets the price of the promotion package ordered multiplied by the ordered quantity
	 * @param qtyPrice The price of the promotion package ordered multiplied by the ordered quantity
	 */
	public void setQtyPrice(double qtyPrice) {
		this.qtyPrice = qtyPrice;
	}
}
