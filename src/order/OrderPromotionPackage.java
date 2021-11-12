package order;

import java.util.ArrayList;

import menu.MenuItem;
import menu.PromotionPackage;

public class OrderPromotionPackage extends PromotionPackage{
	
	private int qty;
	private double qtyPrice;
	
	public OrderPromotionPackage(int packageId, String packageName, double packagePrice,
			String packageDescription, ArrayList<MenuItem> listOfMenuItem, int qty) {
		super(packageId, packageName, packagePrice, packageDescription, listOfMenuItem);
		this.qty = qty;
		this.qtyPrice = packagePrice * qty;
		//super.setPackagePrice(packagePrice*qty);
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public double getQtyPrice() {
		return qtyPrice;
	}

	public void setQtyPrice(double qtyPrice) {
		this.qtyPrice = qtyPrice;
	}
}
