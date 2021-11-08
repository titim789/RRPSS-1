package menu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuItemMgr {
	private static ArrayList<MenuItem> listOfMenuItems;
	
	//constructor
	public MenuItemMgr() {
		listOfMenuItems = new ArrayList<MenuItem>();
	}
	
	public void edit() {
		MenuItemUI menuItemUI = new MenuItemUI();
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
					TYPEOFMENU menuType = menuItemUI.getMenuType();
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
	
	public ArrayList<MenuItem> getListOfMenuItems() {
		return listOfMenuItems;
	}

	public void viewMenuItems() {
		// TODO - implement Menu.viewMenuItems
		int i;
		System.out.println(String.format("%-20s", "Name")
				+"|"+String.format("%-50s", "Description")
				+"|"+"Price"+"\t|");
		for(i=0; i<listOfMenuItems.size(); i++) {
			System.out.println(String.format("%-20s", listOfMenuItems.get(i).getName())
					+"|"+String.format("%-50s", listOfMenuItems.get(i).getDescription())
					+"|"+listOfMenuItems.get(i).getPrice()+"\t|");
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
		
		listOfMenuItems.add(new MenuItem(itemId, name, description,price,menuType));
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
				System.out.println("itemID:" + itemId + " removed.");
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
				System.out.println("Item ID:" + itemId + "'s name changed to "+newName+".");
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
				System.out.println("itemID:" + itemId + "'s price changed to "+newPrice+".");
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
				System.out.println("itemID:" + itemId + "'s Description changed to "+newDesc+".");
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
				System.out.println("itemID:" + itemId + "'s Menu Item type changed to "+menuType+".");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}
	
	public static MenuItem getItemMenu(int itemId) {
		int i;
		for(i=0;i<listOfMenuItems.size();i++) {
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				return listOfMenuItems.get(i);
			}
		}
		return null;
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

