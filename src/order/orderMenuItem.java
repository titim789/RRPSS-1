package order;

import menu.MenuItem;
import menu.TYPEOFMENU;

public class orderMenuItem extends MenuItem{
	
	private int qty;
	private double qtyPrice;
	
	public orderMenuItem(int itemId, String name, String description, double price, TYPEOFMENU menuType, int qty) {
		super(itemId, name, description, price, menuType);
		this.qty = qty;
		this.qtyPrice = price*qty;
//		super.setPrice(price*qty);
	}
	
	public double getQtyPrice() {
		return qtyPrice;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}

	
}
