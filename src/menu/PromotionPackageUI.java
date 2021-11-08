package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class PromotionPackageUI {
	
	public PromotionPackageUI() {}
	
	public int getEditOption() {
		int choice;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Choose Edit:\n"
	                        + "1)\tAdd Package\n"
	                        + "2)\tRemove Package\n"
	                        + "3)\tUpdate Package\n"
	                        + "4)\tExit to Main Menu");
	    System.out.print("Enter Choice : ");
	    choice = sc.nextInt();
		return choice;
	}
	
	public PromotionPackage getAddOption() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter Package ID: ");
		int packageId = sc.nextInt();
		System.out.print("Please enter Package Name: ");
		String packageName = sc.next();
		packageName += sc.nextLine();
		System.out.print("Please enter Package Price: ");
		double packagePrice = sc.nextDouble();
		System.out.print("Please enter Package Description: ");
		String packageDescription = sc.next();
		packageDescription += sc.nextLine();
		ArrayList<MenuItem> newListOfMenuItems = new ArrayList<MenuItem>();
		System.out.print("Which Item ID would you like to add into this package: (-1 to exit)");
		int itemId = sc.nextInt();
		while(itemId!=-1) {
			MenuItem tempItem = MenuItemMgr.getItemMenu(itemId);
			if(tempItem==null) {
				System.out.println("Item Id not found.");
			}
			else {
				newListOfMenuItems.add(tempItem);
			}
			System.out.print("Which Item ID would you like to add into this package: (-1 to exit)");
			itemId = sc.nextInt();
		}
		
		PromotionPackage temp = new PromotionPackage(packageId, packageName, packagePrice, packageDescription, newListOfMenuItems);
		return temp;
	}
	
	public int getRemoveOption() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter Package ID: ");
		int packageId = sc.nextInt();
		return packageId;
	}
	
	public int getUpdateOption() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Edit:\n"
							+ "1)\tUpdate Package Name\n"
							+ "2)\tUpdate Package Description\n"
							+ "3)\tUpdate Package Price\n"
							+ "4)\tAdd Item to Package\n"
							+ "5)\tRemove Item in Package\n"
							+ "6)\tExit to Main Menu");
		System.out.print("Enter Choice : ");
		choice = sc.nextInt();
		return choice;
	}
	
	public int getUpdateIDOption () {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter Package ID: ");
		int packageId = sc.nextInt();
		return packageId;
	}
	
	public String getUpdateNameOption() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter new Package Name: ");
		String packageName = sc.next();
		packageName += sc.nextLine();
		return packageName;
	}
	
	public String getUpdateDescOption() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter new Package Description: ");
		String packageDescription = sc.next();
		packageDescription += sc.nextLine();
		return packageDescription;
	}
	
	public double getUpdatePriceOption() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter new Package Price: ");
		double packagePrice = sc.nextDouble();
		return packagePrice;
	}
	
	public int getAddItemOption () {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter Menu Item ID to add: ");
		int itemId = sc.nextInt();
		return itemId;
	}
	
	public int getRemoveItemOption () {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter Menu Item ID to remove: ");
		int itemId = sc.nextInt();
		return itemId;
	}
	
}