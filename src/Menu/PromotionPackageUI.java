package Menu;

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
	                        + "4)\tReturn");
	    choice = sc.nextInt();
		sc.close();
		return choice;
	}
	
	public PromotionPackage getAddOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Package ID: ");
		int packageId = sc.nextInt();
		System.out.println("Please enter Package Name: ");
		String packageName = sc.next();
		System.out.println("Please enter Package Price: ");
		double packagePrice = sc.nextDouble();
		System.out.println("Please enter Package Description: ");
		String packageDescription = sc.next();
		ArrayList<MenuItem> newListOfMenuItems = new ArrayList<MenuItem>();
		
		PromotionPackage temp = new PromotionPackage(packageId, packageName, packagePrice, packageDescription, newListOfMenuItems);
		sc.close();
		return temp;
	}
	
	public int getRemoveOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Package ID: ");
		int packageId = sc.nextInt();
		sc.close();
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
							+ "6)\tReturn");
		choice = sc.nextInt();
		sc.close();
		return choice;
	}
	
	public int getUpdateIDOption () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Package ID: ");
		int packageId = sc.nextInt();
		sc.close();
		return packageId;
	}
	
	public String getUpdateNameOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter new Package Name: ");
		String packageName = sc.next();
		sc.close();
		return packageName;
	}
	
	public String getUpdateDescOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter new Package Description: ");
		String packageDescription = sc.next();
		sc.close();
		return packageDescription;
	}
	
	public double getUpdatePriceOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter new Package Price: ");
		double packagePrice = sc.nextDouble();
		sc.close();
		return packagePrice;
	}
	
	public int getAddItemOption () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Menu Item ID to add: ");
		int itemId = sc.nextInt();
		sc.close();
		return itemId;
	}
	
	public int getRemoveItemOption () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Menu Item ID to remove: ");
		int itemId = sc.nextInt();
		sc.close();
		return itemId;
	}
	
}