package menu;

import java.util.Scanner;
import java.util.ArrayList;

public class MenuItemUI {
	public MenuItemUI() {}
	
	public int getEditOption() {
		System.out.println("Choose Edit:\n"
				+ "1)\tAdd Menu Item\n"
				+ "2)\tRemove Menu Item\n"
				+ "3)\tUpdate Menu Item\n"
				+ "4)\tReturn");
		System.out.print("Enter Choice : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return choice;
	}
	
	public MenuItem getAddOption() {
		int id;
		String name;
		String description; 
		double price;
		MenuItem.TYPE_OF_MENU menuType;
		Scanner sc = new Scanner(System.in);
		id = MenuItemMgr.getAvailableItemId();
		System.out.print("Name of New Item:");
		name = sc.next();
		name += sc.nextLine();
		System.out.print("Description of New Item:");
		description = sc.next();
		description += sc.nextLine();
		System.out.print("Price of New Item:");
		price = sc.nextDouble();
		System.out.println("Type of New Item:\n"
				+ "1. Main Course\n"
				+ "2. Drink\n"
				+ "3. Dessert");
		System.out.print("Enter Choice : ");
		int type = sc.nextInt();
		if(type == 1) {
			menuType = MenuItem.TYPE_OF_MENU.MAIN_COURSE;
		}
		else if(type == 2) {
			menuType = MenuItem.TYPE_OF_MENU.DRINK;
		}
		else if(type == 3) {
			menuType = MenuItem.TYPE_OF_MENU.DESSERT;
		}
		else menuType = MenuItem.TYPE_OF_MENU.MAIN_COURSE;
		MenuItem temp = new MenuItem(id,name,description,price,menuType);
		return temp;
	}
	
	public int getRemoveOption() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Menu Item to Remove:");
		int id = sc.nextInt();
		return id;
	}
	
	public int getUpdateOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice of Update:\n"
				+ "1. Name\n"
				+ "2. Description\n"
				+ "3. Price\n"
				+ "4. Type of Item\n");
		System.out.print("Enter Choice : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public int getID() {
		System.out.print("Enter the item ID:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		return id;
	}
	
	public String getName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name of New Item:");
		String name = sc.next();
		name += sc.nextLine();
		return name;
	}
	
	public String getDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name of New Item:");
		String description = sc.next();
		description += sc.nextLine();
		return description;
	}
	
	public double getPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name of New Item:");
		double price = sc.nextDouble();
		return price;
	}
	
	public MenuItem.TYPE_OF_MENU getMenuType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type of New Item:\n"
				+ "1. Main Course\n"
				+ "2. Drink\n"
				+ "3. Dessert");
		System.out.print("Enter Choice : ");
		int type = sc.nextInt();
		MenuItem.TYPE_OF_MENU menuType;
		if(type == 1) menuType = MenuItem.TYPE_OF_MENU.MAIN_COURSE;
		else if(type == 2) menuType = MenuItem.TYPE_OF_MENU.DRINK;
		else if(type == 3) menuType = MenuItem.TYPE_OF_MENU.DESSERT;
		else menuType = MenuItem.TYPE_OF_MENU.MAIN_COURSE;
		return menuType;
	}
	
	public void displayMenuItems() {
		ArrayList<MenuItem> listOfMenuItems = MenuItemMgr.getListOfMenuItems();
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
}
