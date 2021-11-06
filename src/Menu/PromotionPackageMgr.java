package Menu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PromotionPackageMgr {
	private ArrayList<PromotionPackage> listOfPromotion;
	
	//constructor
	public PromotionPackageMgr() {}
	
	public void edit(ArrayList<MenuItem> listOfMenuItems) {
	    PromotionPackageUI promotionPackageUI = new PromotionPackageUI();
	    int choice = promotionPackageUI.getEditOption();
	    if(choice == 1){
	        PromotionPackage temp = promotionPackageUI.getAddOption(); 
	        addNewPromotion(temp.getPackageId(), temp.getPackageName(), temp.getPackageDesc(), temp.getPackagePrice(), temp.getListOfMenuItem());
	    }else if(choice == 2){
	        int packageId = promotionPackageUI.getRemoveOption();
	        removePromotion(packageId);
	    }else if(choice == 3){
	        int choice2 = promotionPackageUI.getUpdateOption();
	        if(choice2==1){
	            int packageId = promotionPackageUI.getUpdateIDOption();
	            String packageName = promotionPackageUI.getUpdateNameOption();
	            updatePackageName(packageId, packageName);
	        }else if(choice2==2){
	            int packageId = promotionPackageUI.getUpdateIDOption();
	            String packageDescription = promotionPackageUI.getUpdateDescOption();
	            updatePackageDescription(packageId, packageDescription);
	        }else if(choice2==3){
	            int packageId = promotionPackageUI.getUpdateIDOption();
	            double packagePrice = promotionPackageUI.getUpdatePriceOption();
	            updatePackagePrice(packageId, packagePrice);
	        }else if(choice2==4){
	            int packageId = promotionPackageUI.getUpdateIDOption();
	            int itemId = promotionPackageUI.getAddItemOption();
	            addItemToPackage(packageId, itemId, listOfMenuItems);
	        }else if(choice2==5){
	            int packageId = promotionPackageUI.getUpdateIDOption();
	            int itemId = promotionPackageUI.getRemoveItemOption();
	            removeItemFromPackage(packageId, itemId);
	        }else if(choice2==6){
	            choice=4;
	        }else{
	            choice=5;
	        }
	    }else if(choice == 4){
	        System.out.println("returning...");
	        return;
	    }else{
	        System.out.println("Invalid edit option.\nreturning...");
	        return;
	    }
	}
	
	public ArrayList<PromotionPackage> getListOfPromotion() {
		return this.listOfPromotion;
	}

	public void viewPackages() {
		// TODO - implement Menu.viewPackages
		int i;
	    for(i=0; i<listOfPromotion.size(); i++){
	        System.out.println("Package ID\t"+listOfPromotion.get(i).getPackageId());
	        System.out.println("Package Name\t"+listOfPromotion.get(i).getPackageName());
	        System.out.println("Package Price\t"+listOfPromotion.get(i).getPackagePrice());
	        System.out.println("Package Desc\t"+listOfPromotion.get(i).getPackageDesc());
	        System.out.println("Package Menu Items");
	        System.out.println("Name\t|\tDescription\t|\tPrice\t|");
	        viewItemsInPackage(listOfPromotion.get(i).getPackageId());
	    }
	}

	/**
	 * 
	 * @param package_id
	 * @param package_name
	 * @param package_description
	 * @param package_price
	 * @param listOdMenuItem
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
	 * 
	 * @param package_id
	 */
	public void removePromotion(int packageId) {
		// TODO - implement Menu.removePromotion
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				listOfPromotion.remove(i);
				System.out.println("packageId:" + packageId + "removed.");
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * 
	 * @param package_id
	 * @param newName
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
				System.out.println("packageId:" + packageId + "'s name changed to"+newName+".");
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * 
	 * @param package_id
	 * @param newDesc
	 */
	public void updatePackageDescription(int packageId, String newDesc) {
		// TODO - implement Menu.updatePackageDescription
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				listOfPromotion.get(i).setPackageDesc(newDesc);
				System.out.println("packageId:" + packageId + "'s Description changed to"+newDesc+".");
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * 
	 * @param package_id
	 * @param newPrice
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
				System.out.println("packageId:" + packageId + "'s price changed to"+newPrice+".");
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * 
	 * @param package_id
	 * @param item_id
	 * @param listOfMenuItems
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
						System.out.println("itemId:" + itemId + "added to packageId"+packageId+".");
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
	 * 
	 * @param package_id
	 * @param item_id
	 */
	public void removeItemFromPackage(int packageId, int itemId) {
		// TODO - implement Menu.removeItemfromPackage
		int i;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				listOfPromotion.get(i).removeMenuItem(itemId);
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}

	/**
	 * 
	 * @param package_id
	 */
	public void viewItemsInPackage(int packageId) {
		// TODO - implement Menu.viewItemsinPackage
		int i, j;
		for(i=0; i<listOfPromotion.size();i++)
		{
			if(listOfPromotion.get(i).getPackageId() == packageId) {
				PromotionPackage temp = listOfPromotion.get(i);
				for(j=0; j<temp.getNumberOfItems();j++){
					System.out.println(temp.getListOfMenuItem().get(j).getName()+"\t|\t"+temp.getListOfMenuItem().get(j).getDescription()+"\t|\t"+temp.getListOfMenuItem().get(j).getPrice()+"\t|");
				}
				return;
			}
		}
		System.out.println(packageId+" not found.");
	}
	
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
		}
		
	}
	/**
	 * 
	 * @param menuType (String - either 'promopack', 'menu', or both is accepted)
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
