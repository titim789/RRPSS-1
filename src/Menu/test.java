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
		}*/
		System.out.println("Choose Menu Type:\n1)\tMenu\n2)\tPromotions");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
	}
}
