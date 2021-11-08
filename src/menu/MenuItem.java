package menu;
import java.io.Serializable;

public class MenuItem implements Serializable {

	private int itemId;
	private String name;
	private String description;
	private double price;
	private TYPEOFMENU menuType;

	/**
	 * 
	 * @param item_id
	 * @param name
	 * @param description
	 * @param price
	 * @param menutype
	 */
	public MenuItem(int itemId, String name, String description, double price, TYPEOFMENU menuType) {
		// TODO - implement Menu_Item.Menu_Item
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
	}

	public int getItemId() {
		return itemId;
	}

	/**
	 * 
	 * @param item_id
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public TYPEOFMENU getMenuType() {
		return this.menuType;
	}

	/**
	 * 
	 * @param menutype
	 */
	public void setMenuType(TYPEOFMENU menuType) {
		this.menuType = menuType;
	}
	
	

}
