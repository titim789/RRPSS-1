package Menu;

import java.util.Scanner;

public class MenuItemUI {
	public MenuItemUI() {}
	
	public int getEditOption() {
		System.out.println("Choose Edit:\n"
				+ "1)\tAdd Menu Item\n"
				+ "2)\tRemove Menu Item\n"
				+ "3)\tUpdate Menu Item"
				+ "4)\tReturn");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		return choice;
	}
	
	public MenuItem getAddOption() {
		int id;
		String name;
		String description; 
		double price;
		TYPEOFMENU menuType;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ID of New Item:");
		id = sc.nextInt();
		System.out.println("Name of New Item:");
		name = sc.next();
		System.out.println("Description of New Item:");
		description = sc.next();
		System.out.println("Price of New Item:");
		price = sc.nextDouble();
		System.out.println("Type of New Item:\n"
				+ "1. Main Course\n"
				+ "2. Drink\n"
				+ "3. Dessert");
		int type = sc.nextInt();
		if(type == 1) {
			menuType = TYPEOFMENU.MAIN_COURSE;
		}
		else if(type == 2) {
			menuType = TYPEOFMENU.DRINK;
		}
		else if(type == 3) {
			menuType = TYPEOFMENU.DESSERT;
		}
		else menuType = TYPEOFMENU.MAIN_COURSE;
		MenuItem temp = new MenuItem(id,name,description,price,menuType);
		return temp;
	}
	
	public int getRemoveOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Menu Item to Remove:");
		int id = sc.nextInt();
		sc.close();
		return id;
	}
	
	public int getUpdateOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice of Update:\n"
				+ "1. Name\n"
				+ "2. Description\n"
				+ "3. Price\n"
				+ "4. Type of Item\n");
		int choice = sc.nextInt();
		sc.close();
		return choice;
	}
	
	public int getID() {
		System.out.println("Enter the item ID:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		sc.close();
		return id;
	}
	
	public String getName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of New Item:");
		String name = sc.next();
		sc.close();
		return name;
	}
	
	public String getDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of New Item:");
		String description = sc.next();
		sc.close();
		return description;
	}
	
	public double getPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of New Item:");
		double price = sc.nextDouble();
		sc.close();
		return price;
	}
	
	public TYPEOFMENU getMenuType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type of New Item:\n"
				+ "1. Main Course\n"
				+ "2. Drink\n"
				+ "3. Dessert");
		int type = sc.nextInt();
		TYPEOFMENU menuType;
		if(type == 1) menuType = TYPEOFMENU.MAIN_COURSE;
		else if(type == 2) menuType = TYPEOFMENU.DRINK;
		else if(type == 3) menuType = TYPEOFMENU.DESSERT;
		else menuType = TYPEOFMENU.MAIN_COURSE;
		sc.close();
		return menuType;
	}
}
