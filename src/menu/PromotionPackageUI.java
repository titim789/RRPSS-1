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
	
	public void displayPackages() {
		ArrayList<PromotionPackage> listOfPromotion = PromotionPackageMgr.getListOfPromotion();
		int i;
	    for(i=0; i<listOfPromotion.size(); i++){
	        System.out.println("Package ID\t"+listOfPromotion.get(i).getPackageId());
	        System.out.println("Package Name\t"+listOfPromotion.get(i).getPackageName());
	        System.out.println("Package Price\t"+listOfPromotion.get(i).getPackagePrice());
	        System.out.println("Package Desc\t"+listOfPromotion.get(i).getPackageDesc());
	        System.out.println("Package Menu Items");
	        System.out.println(String.format("%-20s", "Name")
					+"|"+String.format("%-50s", "Description")
					+"|"+"Original Price"+"\t|");
	        displayItemsInPackage(listOfPromotion.get(i));
	        System.out.println("\n");
	    }
	}
	
	public void displayItemsInPackage(PromotionPackage promotionPackage) {
		int j;
		for(j=0; j<promotionPackage.getNumberOfItems();j++){
			System.out.println(String.format("%-20s", promotionPackage.getListOfMenuItem().get(j).getName())
						+"|"+String.format("%-50s", promotionPackage.getListOfMenuItem().get(j).getDescription())
						+"|"+promotionPackage.getListOfMenuItem().get(j).getPrice()+"\t\t|");
		}
		
	}
	
	public PromotionPackage getAddOption() {
		Scanner sc = new Scanner(System.in);
		int packageId = PromotionPackageMgr.getAvailablePromotionId();
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