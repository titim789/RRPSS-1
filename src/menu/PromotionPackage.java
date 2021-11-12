package menu;
import java.util.ArrayList;
import java.io.Serializable;

public class PromotionPackage implements Serializable{

	private int packageId;
	private String packageName;
	private double packagePrice;
	private String packageDescription;
	private ArrayList<MenuItem> listOfMenuItem;

	/**
	 * 
	 * @param package_id
	 * @param package_name
	 * @param package_price
	 * @param package_description
	 * @param listOfMenuItem
	 */
	public PromotionPackage(int packageId, String packageName, double packagePrice, String packageDescription, ArrayList<MenuItem> listOfMenuItem)  {
		// TODO - implement Promotion_Package.Promotion
		this.packageId = packageId;
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.packageDescription = packageDescription;
		this.listOfMenuItem = listOfMenuItem;
		
	}

	public int getPackageId() {
		// TODO - implement Promotion_Package.getPackage_id
		return packageId;
	}

	/**
	 * 
	 * @param package_id
	 */
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * 
	 * @param package_name
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public double getPackagePrice() {
		return this.packagePrice;
	}

	/**
	 * 
	 * @param package_price
	 */
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	public String getPackageDesc() {
		return this.packageDescription;
	}

	/**
	 * 
	 * @param package_description
	 */
	public void setPackageDesc(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public ArrayList<MenuItem> getListOfMenuItem() {
		// TODO - implement Promotion_Package.getListOfMenuItem
		return listOfMenuItem;
	}

	/**
	 * 
	 * @param item
	 */
	public void addMenuItem(MenuItem item) {
		// TODO - implement Promotion_Package.addMenu_Item		
		listOfMenuItem.add(item);
	}

	/**
	 * 
	 * @param item_id
	 */
	public void removeMenuItem(int itemId) {
		// TODO - implement Promotion_Package.removeMenu_Item
		int i;
		for(i=0; i < listOfMenuItem.size(); i++) {
			if(listOfMenuItem.get(i).getItemId() == itemId) {
				listOfMenuItem.remove(i);
				return;
			}
		}
		System.out.println("Item ID is not in this Promotion Package.");
	}
	/**
	 * 
	 * Gets the number of items in the package
	 */
	public int getNumberOfItems() {
		return listOfMenuItem.size();
	}
	
	

}
