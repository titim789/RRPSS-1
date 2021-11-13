package menu;
import java.io.Serializable;

/**
 * MenuItem class is are the ala carte items in the menu.
 * It contains all the attribtues of an item
 * @author Titus, Wei Xiang
 */
public class MenuItem implements Serializable {

	/**
	 * An enumeration of the menu item type, which is either a main couse, drink or dessert
	 */
	public enum TYPE_OF_MENU {
		MAIN_COURSE,
		DRINK,
		DESSERT
	}

	/**
	 * Item Id of this particular menu item
	 */
	private int itemId;

	/**
	 * Name of this particular menu item
	 */
	private String name;

	/**
	 * Descrption of this particular menu item
	*/
	private String description;
	
	/**
	 * Price of this particular menu item
	 */
	private double price;

	/**
	 * Type of this particular menu item, main course, drink or dessert
	 */
	private TYPE_OF_MENU menuType;
	

	/**
	 * Method for instantciating new menu item object
	 * @param item_id item id of this particular menu item
	 * @param name 	name of this particular menu item
	 * @param description 	description of this particular menu item
	 * @param price	price of this particular menu item
	 * @param menutype	type of this particular menu item, main course, drink or dessert
	 */
	public MenuItem(int itemId, String name, String description, double price, TYPE_OF_MENU menuType) {
		// TODO - implement Menu_Item.Menu_Item
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
	}

	
	/** 
	 * Method for getting the item id of this particular menu item
	 * @return int item id of this particular menu item
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * 
	 * Method for setting the item id of this particular menu item
	 * @param item_id item id of this particular menu item to be set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	/** 
	 * Method for getting the name of this particular menu item
	 * @return String name of this particular menu item
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method for setting the name of this particular menu item
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * Method for getting the description of this particular menu item
	 * @return String description of this particular menu item
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Method for setting the description of this particular menu item
	 * @param description description of this particular menu item to be set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * Method for getting the price of this particular menu item 
	 * @return double price of this particular menu item
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Method for setting the price of this particular menu item
	 * @param price price of this particular menu item to be set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	/** 
	 * Method for getting the type of this particular menu item, main course, drink or dessert
	 * @return TYPE_OF_MENU type of this particular menu item
	 */
	public TYPE_OF_MENU getMenuType() {
		return this.menuType;
	}

	/**
	 * Method for setting the type of this particular menu item, main course, drink or dessert
	 * @param menutype type of this particular menu item to be set
	 */
	public void setMenuType(TYPE_OF_MENU menuType) {
		this.menuType = menuType;
	}
	
	

}
