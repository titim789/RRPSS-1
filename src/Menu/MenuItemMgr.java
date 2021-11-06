package Menu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuItemMgr {
	private ArrayList<MenuItem> listOfMenuItems;
	
	//constructor
	public MenuItemMgr() {}
	
	public void edit() {
		MenuItemUI menuItemUI = new MenuItemUI();
		int choice = menuItemUI.getEditOption();
		if(choice == 1) {
			MenuItem newItem = menuItemUI.getAddOption();
			addNewMenuItem(newItem.getItemId(),newItem.getName(),newItem.getDescription(), newItem.getPrice(), newItem.getMenutype());
		}
		else if(choice == 2) {			
			removeItem(menuItemUI.getRemoveOption());
		}
		else if(choice == 3) {
			
			for(int i=0; i<listOfMenuItems.size();i++)
			{
					int update = menuItemUI.getUpdateOption();
					if(update == 1) {
						int id = menuItemUI.getID();
						String name = menuItemUI.getName();
						updateItemName(id, name);
						
					}
					else if(update == 2){
						int id = menuItemUI.getID();
						String description = menuItemUI.getDescription();
						updateItemDescription(id, description);
						
					}
					else if(update == 3){
						int id = menuItemUI.getID();
						double price = menuItemUI.getPrice();
						updateItemPrice(id, price);;			
					}
					else if(update == 4){
						int id = menuItemUI.getID();
						TYPEOFMENU menuType = menuItemUI.getMenuType();
						updateItemMenuType(id, menuType);						
					}
				
			}
			System.out.println("Invalid Item ID.");
			
		}
		else if(choice == 4) {
			System.out.println("returning...");
		}
		else {
			System.out.println("Invalid edit option.\nreturning...");
		}
	}
	
	public ArrayList<MenuItem> getListOfMenuItems() {
		return this.listOfMenuItems;
	}

	public void viewMenuItems() {
		// TODO - implement Menu.viewMenuItems
		int i;
		System.out.println("Name\t|\tDescription\t|\tPrice\t|");
		for(i=0; i<listOfMenuItems.size(); i++) {
			System.out.println(listOfMenuItems.get(i).getName()+"\t|\t"+listOfMenuItems.get(i).getDescription()+"\t|\t"+listOfMenuItems.get(i).getPrice()+"\t|");
		}
	}
	
	/**
	 * 
	 * @param item_id
	 * @param name
	 * @param description
	 * @param price
	 * @param menutype
	 * Returns 0 if failed to add
	 * Returns 1 if added Successfully
	 */
	public int addNewMenuItem(int itemId, String name, String description, double price, TYPEOFMENU menuType) {
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
		
		MenuItem temp = new MenuItem(itemId, name, description,price,menuType);
		listOfMenuItems.add(temp);
		return 1;
	}
	
	/**
	 * 
	 * @param item_id
	 */
	public void removeItem(int itemId) {
		// TODO - implement Menu.removeItem
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.remove(i);
				System.out.println("itemID:" + itemId + "removed.");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * 
	 * @param item_id
	 * @param newName
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
				System.out.println("itemID:" + itemId + "'s name changed to"+newName+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * 
	 * @param item_id
	 * @param newPrice
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
				System.out.println("itemID:" + itemId + "'s price changed to"+newPrice+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * 
	 * @param item_id
	 * @param newDesc
	 */
	public void updateItemDescription(int itemId, String newDesc) {
		// TODO - implement Menu.updateItemDescription
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.get(i).setDescription(newDesc);
				System.out.println("itemID:" + itemId + "'s Description changed to"+newDesc+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	/**
	 * 
	 * @param item_id
	 * @param menuType
	 */
	public void updateItemMenuType(int itemId, TYPEOFMENU menuType) {
		// TODO - implement Menu.updateItemDescription
		int i;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				listOfMenuItems.get(i).setMenuType(menuType);
				System.out.println("itemID:" + itemId + "'s Menu Item type changed to"+menuType+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	public void load() {
		// TODO - implement Menu.load
		try{
		    FileInputStream readData = new FileInputStream("menuitems.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfMenuItems = (ArrayList<MenuItem>) readStream.readObject();
		    readStream.close();
		    //System.out.println(listOfMenuItems.toString());
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param menuType (String - either 'promopack', 'menu', or both is accepted)
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

