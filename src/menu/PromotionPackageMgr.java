package menu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * The control class for promotion packages
 * This control class will manage the list of promotion packages
 * @author yes
 *
 */
public class PromotionPackageMgr {
	/**
	 * The list of promotion packages
	 */
	private static ArrayList<PromotionPackage> listOfPromotion;
	
	/**
	 * This control uses a separate class, promotionPackageUI, for all UI display options
	 */
	private PromotionPackageUI promotionPackageUI;
	
	/**
	 * When instantiating this control, it will create a list of promotion packages,
	 * as well as instantiate a promotionPackageUI for UI displays
	 */
	public PromotionPackageMgr() {
		listOfPromotion = new ArrayList<PromotionPackage>();
		promotionPackageUI = new PromotionPackageUI();
	}
	
	/**
	 * Edits the promotion package based on the user's choices accordingly
	 * @param listOfMenuItems The list of menu items, should they be added to a package
	 */
	public void edit(ArrayList<MenuItem> listOfMenuItems) {
	    int choice = promotionPackageUI.getEditOption();
	    if(choice == 1){
	        PromotionPackage temp = promotionPackageUI.getAddOption(); 
	        addNewPromotion(temp.getPackageId(), temp.getPackageName(), temp.getPackageDesc(), temp.getPackagePrice(), temp.getListOfMenuItem());
	    }else if(choice == 2){
	        int packageId = promotionPackageUI.getRemoveOption();
	        removePromotion(packageId);
	    }else if(choice == 3){
	    	int packageId = promotionPackageUI.getUpdateIDOption();
	        int choice2 = promotionPackageUI.getUpdateOption();
	        if(choice2==1){
	            String packageName = promotionPackageUI.getUpdateNameOption();
	            updatePackageName(packageId, packageName);
	        }else if(choice2==2){
	            String packageDescription = promotionPackageUI.getUpdateDescOption();
	            updatePackageDescription(packageId, packageDescription);
	        }else if(choice2==3){
	            double packagePrice = promotionPackageUI.getUpdatePriceOption();
	            updatePackagePrice(packageId, packagePrice);
	        }else if(choice2==4){
	            int itemId = promotionPackageUI.getAddItemOption();
	            addItemToPackage(packageId, itemId, listOfMenuItems);
	        }else if(choice2==5){
	            int itemId = promotionPackageUI.getRemoveItemOption();
	            removeItemFromPackage(packageId, itemId);
	        }else if(choice2==6){
	            choice=4;
	        }else{
	            choice=5;
	        }
	    }else if(choice == 4){
	        System.out.println("Returning to Main Menu...");
	        return;
	    }else{
	        System.out.println("Invalid edit option.\n"
	        		+ "Returning to Main Menu...");
	        return;
	    }
	}
	
	/**
	 * Gets the list of promotion packages
	 * @return The list of promotion packages
	 */
	public static ArrayList<PromotionPackage> getListOfPromotion() {
		return listOfPromotion;
	}
	
	/**
	 * Gets the promotion package object from the package ID
	 * @param packageId The ID from which we want to get the promotion package object
	 * @return The promotion package object corresponding to the package ID entered
	 */
	public static PromotionPackage getItemPromotionPackage(int packageId) {
		int i;
		for(i=0;i<listOfPromotion.size();i++) {
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				return listOfPromotion.get(i);
			}
		}
		return null;
	}

	/**
	 * Gets an empty ID slot from the promotion package list
	 * @return An ID slot that is empty and available from the the promotion package list
	 */
	public static int getAvailablePromotionId() {
		int i = 1;
		while(getItemPromotionPackage(i) != null) i++;
		return i;
	}
	
	/**
	 * Displays the existing promotion packages
	 */
	public void viewPackages() {
		// TODO - implement Menu.viewPackages
		promotionPackageUI.displayPackages();
	}

	/**
	 * Adds a new promotion package to the list
	 * @param packageId The ID of the promotion package to add
	 * @param packageName The name of the promotion package to add
	 * @param packageDescription The description of the promotion package to add
	 * @param packagePrice The price of the promotion package to add
	 * @param listOfMenuItem The contents, in menuItems, of the promotion package
	 */
	public void addNewPromotion(int packageId, String packageName, String packageDescription, double packagePrice, ArrayList<MenuItem> listOfMenuItem) {
		// TODO - implement Menu.addNewPromotion
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				System.out.println("packageId is in Use.");
			}
		}
		if(packageName.strip() == "") {
			System.out.println("Invalid name.");
		}
		if(packagePrice<=0) {
			System.out.println("Invalid Price set.");
		}
		
		PromotionPackage temp = new PromotionPackage(packageId, packageName, packagePrice, packageDescription,  listOfMenuItem);
		listOfPromotion.add(temp);
	}

	/**
	 * Removes a promotion package from the list
	 * @param packageId The ID of the promotion package to be removed
	 */
	public void removePromotion(int packageId) {
		// TODO - implement Menu.removePromotion
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				System.out.println("packageId " + packageId + ": "+listOfPromotion.get(i).getPackageName()+" removed.");
				listOfPromotion.remove(i);
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * Updates the name of a promotion package
	 * @param packageId The ID of the promotion package to edit. If the ID cannot be found, the user will be notified
	 * @param newName The new name of the promotion package to be changed to. If the name is invalid, the user will be notified
	 */
	public void updatePackageName(int packageId, String newName) {
		// TODO - implement Menu.updatePackageName
		if(newName.strip() == "") {
			System.out.println("Invalid Name set.");
			return;
		}
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				listOfPromotion.get(i).setPackageName(newName);
				System.out.println("packageId:" + packageId + "'s name changed to "+newName+".");
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * Updates the description of the package
	 * @param packageId The ID of the package whose description shall be updated. If the ID does not exist, the user will be notified
	 * @param newDesc The new description to set 
	 */
	public void updatePackageDescription(int packageId, String newDesc) {
		// TODO - implement Menu.updatePackageDescription
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				listOfPromotion.get(i).setPackageDesc(newDesc);
				System.out.println("packageId:" + packageId + "'s Description changed to "+newDesc+".");
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * Updates the price of the package
	 * @param packageId The ID of the package whose price shall be updated. If the ID does not exist, the user will be notified
	 * @param newPrice The new price to set. This value cannot be less than or equal to 0
	 */
	public void updatePackagePrice(int packageId, double newPrice) {
		// TODO - implement Menu.UpdatePackagePrice
		if(newPrice <= 0) {
			System.out.println("Invalid Price set.");
			return;
		}
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				listOfPromotion.get(i).setPackagePrice(newPrice);
				System.out.println("packageId:" + packageId + "'s price changed to "+newPrice+".");
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * Adds an item to an existing package
	 * @param packageId The ID of the package we want to add an item to. The user will be notified if the ID does not exist
	 * @param itemId The ID of the item to add to the package. If the item does not exist, the user will be notified
	 * @param listOfMenuItems The full list of menu items
	 */
	public void addItemToPackage(int packageId, int itemId, ArrayList<MenuItem> listOfMenuItems) {
		// TODO - implement Menu.addItemtoPackage
		int i, j;
		for(i=0; i<listOfMenuItems.size();i++)
		{
			if(listOfMenuItems.get(i).getItemId() == itemId) {
				MenuItem temp = listOfMenuItems.get(i);
				for(j=0; j<listOfPromotion.size();j++)
				{
					if(listOfPromotion.get(j).getPackageId() == packageId) {
						listOfPromotion.get(j).addMenuItem(temp);;
						System.out.println("itemId:" + itemId + " added to packageId "+packageId+".");
						return;
					}
				}
				System.out.println(packageId+" not found.");
				return;
			}
		}
		System.out.println(itemId+" not found.");
	}

	/**
	 * Removes an item from a package
	 * @param packageId The ID of the package from which we will remove an item from
	 * @param itemId The ID of the item to be removed from the package
	 */
	public void removeItemFromPackage(int packageId, int itemId) {
		// TODO - implement Menu.removeItemfromPackage
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				listOfPromotion.get(i).removeMenuItem(itemId);
				System.out.println("itemId:"+itemId+" has been removed from Package Id "+ packageId);
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * Prints the item contents of a package
	 * @param packageId The ID of the package we want to view
	 */
	public void viewItemsInPackage(int packageId) {
		// TODO - implement Menu.viewItemsinPackage
		int i, j;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				PromotionPackage temp = listOfPromotion.get(i);
				promotionPackageUI.displayItemsInPackage(temp);
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}
	
	/**
	 * Loads the list of promotion packages from a .txt file
	 */
	public void load() {
		// TODO - implement Menu.load
		try{
		    FileInputStream readData = new FileInputStream("promotionpackages.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfPromotion = (ArrayList<PromotionPackage>) readStream.readObject();
		    readStream.close();
		    //System.out.println(listOfMenuItems.toString());
		}catch (Exception e) {
		    e.printStackTrace();
			System.out.println("Error loading promotionpackages.txt");
		}
		
	}

	/**
	 * Saves the list of promotions to the "promotionpackages.txt" file
	 */
	public void save() {
		// TODO - implement Menu.save
		try {
		    FileOutputStream fos = new FileOutputStream("promotionpackages.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(listOfPromotion); // write MenuArray to ObjectOutputStream
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
}
