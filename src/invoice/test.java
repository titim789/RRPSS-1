package invoice;

import java.util.ArrayList;
import java.util.Calendar;

import order.*;
import menu.*;

public class test {
	public static void main(String []args) {
		InvoiceMgr invmgr = new InvoiceMgr();
		
		
		
		
		
		
		
		/*
		 * Order ord = new Order(1,1,1,0,Calendar.getInstance()); OrderMenuItem omi =
		 * new OrderMenuItem(1,"Carbonara","A creamy bacon infused pasta",8.7,MenuItem.
		 * TYPE_OF_MENU.MAIN_COURSE,5); ord.addOrderItem(omi); omi = new
		 * OrderMenuItem(2,"Vongole","Creamy pasta with clams",9.5,MenuItem.TYPE_OF_MENU
		 * .MAIN_COURSE,5); ord.addOrderItem(omi); omi = new
		 * OrderMenuItem(12,"Soft Drink","In-house on tap",3,MenuItem.TYPE_OF_MENU.DRINK
		 * ,5); ord.addOrderItem(omi); invmgr.newInvoice(ord,false); ord = new
		 * Order(2,1,1,0,Calendar.getInstance()); omi = new
		 * OrderMenuItem(1,"Carbonara","A creamy bacon infused pasta",8.7,MenuItem.
		 * TYPE_OF_MENU.MAIN_COURSE,5); ord.addOrderItem(omi); omi = new
		 * OrderMenuItem(2,"Vongole","Creamy pasta with clams",9.5,MenuItem.TYPE_OF_MENU
		 * .MAIN_COURSE,5); ord.addOrderItem(omi); omi = new
		 * OrderMenuItem(12,"Soft Drink","In-house on tap",3,MenuItem.TYPE_OF_MENU.DRINK
		 * ,5); ord.addOrderItem(omi); invmgr.newInvoice(ord,false); ord = new
		 * Order(3,1,1,0,Calendar.getInstance()); omi = new
		 * OrderMenuItem(1,"Carbonara","A creamy bacon infused pasta",8.7,MenuItem.
		 * TYPE_OF_MENU.MAIN_COURSE,5); ord.addOrderItem(omi); omi = new
		 * OrderMenuItem(2,"Vongole","Creamy pasta with clams",9.5,MenuItem.TYPE_OF_MENU
		 * .MAIN_COURSE,5); ord.addOrderItem(omi); omi = new
		 * OrderMenuItem(12,"Soft Drink","In-house on tap",3,MenuItem.TYPE_OF_MENU.DRINK
		 * ,5); ord.addOrderItem(omi); invmgr.newInvoice(ord,false);
		 * 
		 * 
		 */
		
		
		
		PromotionPackageMgr pm = new PromotionPackageMgr();
		pm.load();
		Order ord = new Order(1,1,1,0,Calendar.getInstance()); 
		
		OrderPromotionPackage omi = new OrderPromotionPackage(1,"Carbonara Meal",13,"Carbonara + Tea + Cheese Cake",pm.getListOfPromotion().get(0).getListOfMenuItem(),2);
		ord.addPromotion(omi); 
		omi = new OrderPromotionPackage(2,"Aglio Olio Meal",11.9,"Aglio Olio + Coffee + Tiramisu",pm.getListOfPromotion().get(1).getListOfMenuItem(),2);
		ord.addPromotion(omi); 
		omi = new OrderPromotionPackage(3,"Pizza for 2",11.6,"Pizza Magherita + 2 x Soft Drink",pm.getListOfPromotion().get(1).getListOfMenuItem(),2);
		ord.addPromotion(omi); 
		 
		invmgr.newInvoice(ord,false);
		 
		 
		 
		 
		 
		
		
		
		invmgr.save();
		
		
		
		/*
		menuItemMgr.addNewMenuItem(1,"Carbonara","A creamy bacon infused pasta",8.7,MenuItem.TYPE_OF_MENU.MAIN_COURSE); 
		menuItemMgr.addNewMenuItem(2,"Vongole","Creamy pasta with clams",9.5,MenuItem.TYPE_OF_MENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(3,"Aglio Olio","Pasta tossed in olive oil and garlic",7.2,MenuItem.TYPE_OF_MENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(4,"Pizza Margherita","Simple pizza with basil, tomatoes, and cheese",12.4,MenuItem.TYPE_OF_MENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(5,"Lasagne","Layered pasta sheets with cheese and meat",8.5,MenuItem.TYPE_OF_MENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(6,"Risotto","Rice dish cooked with creamy broth",7.4,MenuItem.TYPE_OF_MENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(7,"Pasta Bottarga","Pasta sprinkled with Cured Fish Roe",7.3,MenuItem.TYPE_OF_MENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(8,"Focaccia","Flat Italian bread topped with meat",5.8,MenuItem.TYPE_OF_MENU.MAIN_COURSE) ;
		menuItemMgr.addNewMenuItem(9,"Beer","Bubbly goodness",5,MenuItem.TYPE_OF_MENU.DRINK) ;
		menuItemMgr.addNewMenuItem(10,"Coffee","Energy boost",2,MenuItem.TYPE_OF_MENU.DRINK) ;
		menuItemMgr.addNewMenuItem(11,"Tea","Soothing energy",2,MenuItem.TYPE_OF_MENU.DRINK) ;
		menuItemMgr.addNewMenuItem(12,"Soft Drink","In-house on tap",3,MenuItem.TYPE_OF_MENU.DRINK) ;
		menuItemMgr.addNewMenuItem(13,"Cheese Cake","Cake made of cream cheese and crackers",5.6,MenuItem.TYPE_OF_MENU.DESSERT) ;
		menuItemMgr.addNewMenuItem(14,"Tiramisu","Coffee-flavoured dessert",5.6,MenuItem.TYPE_OF_MENU.DESSERT) ;
		menuItemMgr.addNewMenuItem(15,"Gelato","Frozen dessert",2.1,MenuItem.TYPE_OF_MENU.DESSERT);
		
		promotionPackageMgr.addNewPromotion(1,"Carbonara Meal","Carbonara + Tea + Cheese Cake",13,menuItem1); 
		promotionPackageMgr.addNewPromotion(2,"Aglio Olio Meal","Aglio Olio + Coffee + Tiramisu",11.9,menuItem2); 
		promotionPackageMgr.addNewPromotion(3,"Pizza for 2","Pizza Magherita + 2 x Soft Drink",11.6,menuItem3); 
		promotionPackageMgr.addNewPromotion(4,"Lasagna Meal","Lasagne + Soft Drink + Gelato",10.9,menuItem4); 
		promotionPackageMgr.addNewPromotion(5,"Pasta Bottarga Meal","Pasta Bottarga + Beer + Gelato",11.5,menuItem5); */
		
		
	}
}
