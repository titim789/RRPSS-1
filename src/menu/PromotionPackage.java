package menu;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * A promotion package contains two or more menu items, packaged together in a deal.
 * Customers may order this instead of the ala carte items it contains for a cheaper price
 * @author yes
 *
 */
public class PromotionPackage implements Serializable{

	/**
	 * The ID of the promotion package
	 */
	private int packageId;
	
	/**
	 * The name of the package
	 */
	private String packageName;
	
	/**
	 * The price of the package
	 */
	private double packagePrice;
	
	/**
	 * The description of the packages
	 */
	private String packageDescription;
	
	/**
	 * The list of ala carte menu items contained in this promotion package
	 */
	private ArrayList<MenuItem> listOfMenuItem;

	/**
	 * This creates a promotion package, containing a list of ala carte menu items
	 * @param packageId The ID of the package
	 * @param packageName The name of the package
	 * @param packagePrice The price of the package
	 * @param packageDescription The description of the package
	 * @param listOfMenuItem The list of ala carte menu items contained in the promotion package
	 */
	public PromotionPackage(int packageId, String packageName, double packagePrice, String packageDescription, ArrayList<MenuItem> listOfMenuItem)  {
		// TODO - implement Promotion_Package.Promotion
		this.packageId = packageId;
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.packageDescription = packageDescription;
		this.listOfMenuItem = listOfMenuItem;
		
	}

	/**
	 * Gets the ID of this promotion package
	 * @return The ID of this promotion package
	 */
	public int getPackageId() {
		// TODO - implement Promotion_Package.getPackage_id
		return packageId;
	}

	/**
	 * Sets the ID of this promotion package
	 * @param packageId The ID of this promotion package
	 */
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	/**
	 * Gets the name of this promotion package
	 * @return The name of this promotion package
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * Sets the name of this promotion package
	 * @param packageName The name of this promotion package to be set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * Gets the price of this promotion package
	 * @return The price of this promotion package
	 */
	public double getPackagePrice() {
		return this.packagePrice;
	}

	/**
	 * Sets the price of this promotion package
	 * @param packagePrice The price to set this promotion package to
	 */
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	/**
	 * Gets the description of this promotion package
	 * @return The description of this promotion package
	 */
	public String getPackageDesc() {
		return this.packageDescription;
	}

	/**
	 * Sets the description of this promotion package
	 * @param packageDescription The description to set this promotion package to
	 */
	public void setPackageDesc(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	/**
	 * Get the list of ala carte menu items this promotion package contains
	 * @return The list of ala carte menu items this promotion package contains
	 */
	public ArrayList<MenuItem> getListOfMenuItem() {
		// TODO - implement Promotion_Package.getListOfMenuItem
		return listOfMenuItem;
	}

	/**
	 * Adds a menu item to this promotion package
	 * @param item The menu item to add to this promotion package
	 */
	public void addMenuItem(MenuItem item) {
		// TODO - implement Promotion_Package.addMenu_Item		
		listOfMenuItem.add(item);
	}

	/**
	 * Removes a menu item from the promotion package
	 * @param itemId The ID of the item to remove from this promotion package
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
	 * Gets the number of items in the package
	 * @return The number of items in the package
	 */
	public int getNumberOfItems() {
		return listOfMenuItem.size();
	}
	
	

}
