package Menu;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class test {
	public static void main(String[] args)
	{
		//testing
		/*MenuItem sandwich = new MenuItem(1,"SandWich", "SandWich", 4.5, TYPEOFMENU.MAIN_COURSE);
		MenuItem coke = new MenuItem(2,"Coke", "Coke", 1.5, TYPEOFMENU.DRINK);
		MenuItem sundae = new MenuItem(3,"Sundae", "sundae", 5.5, TYPEOFMENU.DESSERT);
		ArrayList<MenuItem> deal = new ArrayList<MenuItem>();
		deal.add(sundae);
		deal.add(coke);
		deal.add(sandwich);
		PromotionPackage p1 = new PromotionPackage(1, "Lunch Deal", 12, "Lunch Special", deal);
		
		System.out.println("\nCurrent Promotion Package:");
		int i;
		for(i = 0; i<p1.getNumberOfItems();i++)
		{
			System.out.println(p1.getListOfMenuItem().get(i).getName());
		}
		System.out.println("\nAdding Into Promotion Package:");
		//Adding a new item into the package
		MenuItem chocolate = new MenuItem(4, "Choco","latte", 10, TYPEOFMENU.DESSERT);
		p1.addMenuItem(chocolate);
		p1.setPackagePrice(13.5);
		for(i = 0; i<p1.getNumberOfItems();i++)
		{
			System.out.println(p1.getListOfMenuItem().get(i).getName());
		}
		
		System.out.println("\nRemoving From Promotion Package:");
		//Remove an item from the package
		p1.removeMenuItem(5); // removing invalid
		p1.removeMenuItem(3); // removing Sundae
		p1.setPackagePrice(12.5);
		for(i = 0; i<p1.getNumberOfItems();i++)
		{
			System.out.println(p1.getListOfMenuItem().get(i).getName());
		}
		
		MenuItem sandwich = new MenuItem(1,"SandWich", "SandWich", 4.5, TYPEOFMENU.MAIN_COURSE);
		MenuItem coke = new MenuItem(2,"Coke", "Coke", 1.5, TYPEOFMENU.DRINK);
		MenuItem sundae = new MenuItem(3,"Sundae", "sundae", 5.5, TYPEOFMENU.DESSERT);
		ArrayList<MenuItem> MenuArray = new ArrayList<MenuItem>();
		MenuArray.add(sundae);
		MenuArray.add(coke);
		MenuArray.add(sandwich);
		PromotionPackage p1 = new PromotionPackage(1, "Lunch Deal", 12, "Lunch Special", MenuArray);
		ArrayList<PromotionPackage>  PromoList = new ArrayList<PromotionPackage>();
		PromoList.add(p1);
		
		try {
		    FileOutputStream fos = new FileOutputStream("test.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(PromoList); // write MenuArray to ObjectOutputStream
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		
		try{
		    FileInputStream readData = new FileInputStream("test.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    ArrayList<PromotionPackage> people2 = (ArrayList<PromotionPackage>) readStream.readObject();
		    readStream.close();
		    System.out.println(people2.toString());
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
		//Adding MenuItems into menuitems.txt
		MenuItemMgr menuItemMgr = new MenuItemMgr();
		menuItemMgr.addNewMenuItem(1,"Carbonara","A creamy bacon infused pasta",8.7,TYPEOFMENU.MAIN_COURSE); 
		menuItemMgr.addNewMenuItem(2,"Vongole","Creamy pasta with clams",9.5,TYPEOFMENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(3,"Aglio Olio","Pasta tossed in olive oil and garlic",7.2,TYPEOFMENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(4,"Pizza Margherita","Simple pizza with basil, tomatoes, and cheese",12.4,TYPEOFMENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(5,"Lasagne","Layered pasta sheets with cheese and meat",8.5,TYPEOFMENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(6,"Risotto","Rice dish cooked with creamy broth",7.4,TYPEOFMENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(7,"Pasta Bottarga","Pasta sprinkled with Cured Fish Roe",7.3,TYPEOFMENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(8,"Focaccia","Flat Italian bread topped with meat",5.8,TYPEOFMENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(9,"Beer","Bubbly goodness",5,TYPEOFMENU.DRINK) ;
		menuItemMgr.addNewMenuItem(10,"Coffee","Energy boost",2,TYPEOFMENU.DRINK) ;
		menuItemMgr.addNewMenuItem(11,"Tea","Soothing energy",2,TYPEOFMENU.DRINK) ;
		menuItemMgr.addNewMenuItem(12,"Soft Drink","In-house on tap",3,TYPEOFMENU.DRINK) ;
		menuItemMgr.addNewMenuItem(13,"Cheese Cake","Cake made of cream cheese and crackers",5.6,TYPEOFMENU.DESSERT) ;
		menuItemMgr.addNewMenuItem(14,"Tiramisu","Coffee-flavoured dessert",5.6,TYPEOFMENU.DESSERT) ;
		menuItemMgr.addNewMenuItem(15,"Gelato","Frozen dessert",2.1,TYPEOFMENU.DESSERT);
		menuItemMgr.getListOfMenuItems()();
		menuItemMgr.viewMenuItems();
		
		try {
		    FileOutputStream fos = new FileOutputStream("menuitems.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(menuItemMgr.getListOfMenuItems()()); // write MenuArray to ObjectOutputStream
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		ArrayList<MenuItem> listOfMenuItems = new ArrayList<MenuItem>();
		try{
		    FileInputStream readData = new FileInputStream("menuitems.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfMenuItems = (ArrayList<MenuItem>) readStream.readObject();
		    readStream.close();
		    //System.out.println(listOfMenuItems.toString());
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
		System.out.println(listOfMenuItems.get(0).toString());
		
		//Adding Promotion Package into promotionpackage.txt
		ArrayList<MenuItem> menuItem1 = new ArrayList<MenuItem>(); 
		ArrayList<MenuItem> menuItem2 = new ArrayList<MenuItem>(); 
		ArrayList<MenuItem> menuItem3 = new ArrayList<MenuItem>(); 
		ArrayList<MenuItem> menuItem4 = new ArrayList<MenuItem>(); 
		ArrayList<MenuItem> menuItem5 = new ArrayList<MenuItem>();
		PromotionPackageMgr promotionPackageMgr = new PromotionPackageMgr();
		MenuItemMgr menuItemMgr = new MenuItemMgr();
		menuItemMgr.load();

		promotionPackageMgr.addNewPromotion(1,"Carbonara Meal","Carbonara + Tea + Cheese Cake",13,menuItem1); 
		promotionPackageMgr.addNewPromotion(2,"Aglio Olio Meal","Aglio Olio + Coffee + Tiramisu",11.9,menuItem2); 
		promotionPackageMgr.addNewPromotion(3,"Pizza for 2","Pizza Magherita + 2 x Soft Drink",11.6,menuItem3); 
		promotionPackageMgr.addNewPromotion(4,"Lasagna Meal","Lasagne + Soft Drink + Gelato",10.9,menuItem4); 
		promotionPackageMgr.addNewPromotion(5,"Pasta Bottarga Meal","Pasta Bottarga + Beer + Gelato",11.5,menuItem5); 
		
		promotionPackageMgr.addItemToPackage(1,1,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(1,11,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(1,13,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(2,3,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(2,10,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(2,14,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(3,4,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(3,12,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(3,12,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(4,5,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(4,12,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(4,15,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(5,7,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(5,9,menuItemMgr.getListOfMenuItems()); 
		promotionPackageMgr.addItemToPackage(5,15,menuItemMgr.getListOfMenuItems());
		
		try {
		    FileOutputStream fos = new FileOutputStream("promotionpackages.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(promotionPackageMgr.getListOfPromotion()); // write MenuArray to ObjectOutputStream
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		
		ArrayList<PromotionPackage> listOfPromoPack = new ArrayList<PromotionPackage>();
		try{
		    FileInputStream readData = new FileInputStream("promotionpackages.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfPromoPack = (ArrayList<PromotionPackage>) readStream.readObject();
		    readStream.close();
		    //System.out.println(listOfMenuItems.toString());
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
		System.out.println(listOfPromoPack.get(0).getPackageName());
		*/
	}
}
