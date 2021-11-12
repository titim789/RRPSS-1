package menu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is controllers class to manage the menu items.
 * @author Titus, Wei Xiang
 */
public class MenuItemMgr {
	/**
	 * This is a static array list of menu item objects.
	*/
	private static ArrayList<MenuItem> listOfMenuItems;
	
	/**
	 * This is an instance of MenuUI class, to capture user inputs
	*/
	private MenuItemUI menuItemUI;
	
	//constructor
	/**
	 * This is a constructor of MenuItemMgr class, loads menuItems from file.
	*/
	public MenuItemMgr() {
		listOfMenuItems = new ArrayList<MenuItem>();
		menuItemUI = new MenuItemUI();
	}
	
	/**
	 * This is a method to add/remove/update item, depending on what user input to UI.
	*/
	public void edit() {		
		int choice = menuItemUI.getEditOption();
		if(choice == 1) {
			MenuItem newItem = menuItemUI.getAddOption();
			addNewMenuItem(newItem.getItemId(),newItem.getName(),newItem.getDescription(), newItem.getPrice(), newItem.getMenuType());
		}
		else if(choice == 2) {			
			removeItem(menuItemUI.getRemoveOption());
		}
		else if(choice == 3) {
			
			int id = menuItemUI.getID();	
			int update = menuItemUI.getUpdateOption();
				if(update == 1) {					
					String name = menuItemUI.getName();
					updateItemName(id, name);
				}
				else if(update == 2){
					String description = menuItemUI.getDescription();
					updateItemDescription(id, description);					
				}
				else if(update == 3){
					double price = menuItemUI.getPrice();
					updateItemPrice(id, price);;			
				}
				else if(update == 4){
					MenuItem.TYPE_OF_MENU menuType = menuItemUI.getMenuType();
					updateItemMenuType(id, menuType);						
				}			
		}
		else if(choice == 4) {
			System.out.println("returning...");
		}
		else {
			System.out.println("Invalid edit option.\nreturning...");
		}
	}
	
	/**
	 * This is a method to return the static list of menu items.
	 * @return a list of Menu Items
	 */
	public static ArrayList<MenuItem> getListOfMenuItems() {
		return listOfMenuItems;
	}
	
	
	/**
	 * this is a method to view the UI related to Menu Items
	 */
	public void viewMenuItems() {
		// TODO - implement Menu.viewMenuItems
		menuItemUI.displayMenuItems();
	}
	
	/**
	 * This is a method to add new menu item to the list of menu items.
	 * @param itemId - the id of the menu item
	 * @param name 	- the name of the menu item
	 * @param description 	- the description of the menu item
	 * @param price - the price of the menu item
	 * @param menuType - the type of the menu item
	 * @return 0 for fail, 1 for successful
	 */
	public int addNewMenuItem(int itemId, String name, String description, double price, MenuItem.TYPE_OF_MENU menuType) {
		// TODO - implement Menu.addNewItem
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				System.out.println("itemId is in Use.");
				return 0;
			}
		}
		if(name.strip() == "") {
			System.out.println("Invalid name.");
			return 0;
		}
		if(price<=0) {
			System.out.println("Invalid Price set.");
			return 0;
		}
		
		listOfMenuItems.add(new MenuItem(itemId, name, description,price,menuType));
		return 1;
	}
	
	/**
	 * Method to remove menu item from the list of menu items, based on ID passed in
	 * @param itemId - the id of the menu item to be removed
	 */
	public void removeItem(int itemId) {
		// TODO - implement Menu.removeItem
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.remove(i);
				System.out.println("itemID:" + itemId + " removed.");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * Method to update the Id and name of the menu item.
	 * @param itemId - the id of the menu item to be updated
	 * @param newName - the new name of the menu item
	 */
	public void updateItemName(int itemId, String newName) {
		// TODO - implement Menu.updateItemName
		if(newName.strip() == "") {
			System.out.println("Invalid Name set.");
			return;
		}
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.get(i).setName(newName);
				System.out.println("Item ID:" + itemId + "'s name changed to "+newName+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * Method to update the item price based on Item ID passed in
	 * @param itemId - the id of the menu item to be updated
	 * @param newPrice - the new price of the menu item
	 */
	public void updateItemPrice(int itemId, double newPrice) {
		// TODO - implement Menu.UpdateItemPrice
		if(newPrice <= 0) {
			System.out.println("Invalid Price set.");
			return;
		}
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.get(i).setPrice(newPrice);
				System.out.println("itemID:" + itemId + "'s price changed to "+newPrice+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * Method to update the item description based on Item ID passed in
	 * @param itemId - the id of the menu item to be updated
	 * @param newDesc - the new description of the menu item
	 */
	public void updateItemDescription(int itemId, String newDesc) {
		// TODO - implement Menu.updateItemDescription
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.get(i).setDescription(newDesc);
				System.out.println("itemID:" + itemId + "'s Description changed to "+newDesc+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * Method to update the item type based on Item ID passed in
	 * @param itemId - the id of the menu item to be updated
	 * @param menuType - the new type of the menu item
	 */
	public void updateItemMenuType(int itemId, MenuItem.TYPE_OF_MENU menuType) {
		// TODO - implement Menu.updateItemDescription
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.get(i).setMenuType(menuType);
				System.out.println("itemID:" + itemId + "'s Menu Item type changed to "+menuType+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * Method to get the list of menu items object
	 * @param itemId - the id of the menu item to get
	 * @return - the menu item object, or null if not found
	 */
	public static MenuItem getItemMenu(int itemId) {
		int i;
		for(i=0;i<listOfMenuItems.size();i++) {
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				return listOfMenuItems.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Method to get the available ID for a new menu item
	 * @return the available ID for a new menu item
	 */
	public static int getAvailableItemId() {
		int i = 1;
		while(getItemMenu(i) != null) i++;
		return i;
	}
	
	/**
	 * Method to load the menu items from the database file
	 */
	public void load() {
		// TODO - implement Menu.load
		try{
		    FileInputStream readData = new FileInputStream("menuitems.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfMenuItems = (ArrayList<MenuItem>) readStream.readObject();
		    readStream.close();
		    //System.out.println(listOfMenuItems.toString());
		}catch (Exception e) {
		    //e.printStackTrace();
			System.out.println("Error loading menuitems.txt");
		}
		
	}
	
	/**
	 * Method to save the menu items to the database file
	 */
	public void save() {
		// TODO - implement Menu.save
		try {
		    FileOutputStream fos = new FileOutputStream("menuitems.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(listOfMenuItems); // write MenuArray to ObjectOutputStream
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
}

