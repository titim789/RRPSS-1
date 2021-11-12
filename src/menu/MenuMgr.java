package menu;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manager for Menu
 * @author titus
 * @author Wei Xiang
 *
 */
public class MenuMgr{
	
	/**
	 * The MenuItemMgr Object
	 */
	private MenuItemMgr menuItemMgr;
	
	/**
	 * The promotionPackageMgr Object
	 */
	private PromotionPackageMgr promotionPackageMgr;

	
	/**
	 * When instantiating this control, it will create a MenuItemMgr Object
	 * as well as a PromotionPackageMgr Object and loading both the list of 
	 * Menu Items and Promotion Package respectively.
	 */
	public MenuMgr() {
		// TODO - implement Menu.Menu
		menuItemMgr = new MenuItemMgr();
		promotionPackageMgr = new PromotionPackageMgr();
		load();
	}
	/**
	 * Displays the MenuItems and Promotion Packages Available
	 */
	public void seeMenu() {
		menuItemMgr.viewMenuItems();
		promotionPackageMgr.viewPackages();;
	}
	/**
	 * The Main method that instantiates the MenuUI and the connector of the edit
	 * Menu function.
	 */
	public void editMenu() {
		MenuUI menuUI = new MenuUI();
		int choice = menuUI.getMenuTypeOption();
		if(choice == 1) {
			menuItemMgr.edit();
		}
		else if(choice == 2) {
			promotionPackageMgr.edit(menuItemMgr.getListOfMenuItems());
		}
		else {
			System.out.println("Exiting to Main Menu");
		}
	}
	
	
	/**
	 * Gets a particular MenuItem with the itemId
	 * @param itemId The itemId to receive
	 * @return MenuItem Returns the MenuItem if it exists if not returns null
	 */
	public MenuItem getMenuItem(int itemId){
	    ArrayList<MenuItem> listOfMenuItems = menuItemMgr.getListOfMenuItems();
	    int i;
	        for(i=0; i<listOfMenuItems.size();i++)
	        {
	            if(listOfMenuItems.get(i).getItemId() == itemId) {
	                return listOfMenuItems.get(i);
	            }
	        }
	    System.out.println(itemId+" not found.");
	    return null;
	}
	
	/**
	 * Gets a particular PromotionPackage with the packageId
	 * @param packageId The packageId to return
	 * @return PromotionPackage Returns the PromotionPackage if it exists if not returns null
	 */
	public PromotionPackage getPromotionPackage(int packageId){
	    ArrayList<PromotionPackage> listOfPromotion = promotionPackageMgr.getListOfPromotion();
	    int i;
	    for(i=0; i<listOfPromotion.size();i++)
	    {
	        if(listOfPromotion.get(i).getPackageId() == packageId) {
	            return listOfPromotion.get(i);
	        }
	    }
	    System.out.println(packageId+" not found.");
	    return null;
	}
	/**
	 * Calls both MenuItemMgr and PromotionPackageMgr to save the current list of items respectively
	 */
	public void save() {
	    menuItemMgr.save();
	    promotionPackageMgr.save();
	}
	/**
	 * Calls both MenuItemMgr and PromotionPackageMgr to load into their respective list of items
	 */
	public void load() {
	    menuItemMgr.load();
	    promotionPackageMgr.load();
	}
	

}
