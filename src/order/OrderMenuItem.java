package order;

import menu.MenuItem;

import menu.MenuItem.TYPE_OF_MENU;

public class OrderMenuItem extends MenuItem{
	
	/**
	 * The quantity of this particular menu item ordered
	 */
	private int qty;
	
	/**
	 * The price of each of the menu item multiplied by the ordered quantity
	 */
	private double qtyPrice;
	
	/**
	 * Creates the order menu item line with the quantity ordered
	 * @param itemId The ID of the menu item ordered
	 * @param name The name of the menu item ordered
	 * @param description The description of the menu item ordered
	 * @param price The individual price of menu item ordered
	 * @param menuType The menu type enumeration of the menu item ordered
	 * @param qty The quantity of the menu item ordered
	 */
	public OrderMenuItem(int itemId, String name, String description, double price, MenuItem.TYPE_OF_MENU menuType, int qty) {
		super(itemId, name, description, price, menuType);
		this.qty = qty;
		this.qtyPrice = price*qty;
//		super.setPrice(price*qty);
	}
	
	/**
	 * Gets the price of each menu item multiplied by the ordered quantity
	 * @return The price of each menu item multiplied by the ordered quantity
	 */
	public double getQtyPrice() {
		return qtyPrice;
	}
	
	/**
	 * Sets the price of each menu item multiplied by the ordered quantity
	 * @param qtyPrice The price of each menu item multiplied by the ordered quantity
	 */
	public void setQtyPrice(double qtyPrice) {
		this.qtyPrice = qtyPrice;
	}
	
	/**
	 * Gets the quantity of the menu item ordered
	 * @return The quantity of the menu item ordered
	 */
	public int getQty() {
		return qty;
	}
	
	/**
	 * Sets the quantity of the menu item ordered
	 * @param qty The quantity of the menu item ordered
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	
}
