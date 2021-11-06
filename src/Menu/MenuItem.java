package Menu;
import java.io.Serializable;

public class MenuItem implements Serializable {

	private int item_id;
	private String name;
	private String description;
	private double price;
	private TYPEOFMENU menutype;

	/**
	 * 
	 * @param item_id
	 * @param name
	 * @param description
	 * @param price
	 * @param menutype
	 */
	public MenuItem(int item_id, String name, String description, double price, TYPEOFMENU menutype) {
		// TODO - implement Menu_Item.Menu_Item
		this.item_id = item_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menutype = menutype;
	}

	public int getItemId() {
		return this.item_id;
	}

	/**
	 * 
	 * @param item_id
	 */
	public void setItemId(int item_id) {
		this.item_id = item_id;
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

	public TYPEOFMENU getMenutype() {
		return this.menutype;
	}

	/**
	 * 
	 * @param menutype
	 */
	public void setMenuType(TYPEOFMENU menutype) {
		this.menutype = menutype;
	}
	
	@Override
    public String toString() {
        return "MenuItem{" +
                "Item ID ='" + item_id + '\'' +
                ", Name ='" + name + '\'' +
                ", Description =" + description +
                ", Price =" + price +
                ", Type =" + menutype +
                "}\n";
    }

}
