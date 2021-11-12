package order;

import menu.MenuItem;

import menu.MenuItem.TYPE_OF_MENU;

public class OrderMenuItem extends MenuItem{
	
	private int qty;
	private double qtyPrice;
	
	public OrderMenuItem(int itemId, String name, String description, double price, MenuItem.TYPE_OF_MENU menuType, int qty) {
		super(itemId, name, description, price, menuType);
		this.qty = qty;
		this.qtyPrice = price*qty;
//		super.setPrice(price*qty);
	}
	
	public double getQtyPrice() {
		return qtyPrice;
	}
	
	public void setQtyPrice(double qtyPrice) {
		this.qtyPrice = qtyPrice;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}

	
}
