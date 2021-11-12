package table;

import java.io.Serializable;

/**
 * This is the entity class of table, contains attribtues of table object.
 */
public class Table implements Serializable{

	/**
	 * an enumeration of possible table status (reserved, vacant, occupied)
	*/
	public enum TABLESTATUS {
		RESERVED,
		VACANT,
		OCCUPIED
	}

	/**
	 * table ID of table object
	*/
	private int tableId;
	
	/**
	 * number of seats for this table object
	 */
	private int noOfPax;

	/**
	 * table status of table object using enum
	*/
	private TABLESTATUS status;

	/**
	 * constructor of table object
	*/
	public Table(){}

	/**
	 * constructor of table object, with table ID, number of pax for table size, status default to vacant
	 */
	public Table(int tableId,int noOfPax) {
		this.tableId = tableId;
		this.noOfPax = noOfPax;
		this.status = TABLESTATUS.VACANT;
	}

	/**
	 * get the number of seats for this table object
	*/
	public int getNoOfPax() {
		return this.noOfPax;
	}

	/**
	 * get the number of seats for this table object
	 * @param noOfPax number of seats/table size
	 */
	public void setNoOfPax(int noOfPax) {
		this.noOfPax = noOfPax;
	}

	/**
	 * get the table ID of this table object
	 * @return table ID
	 */
	public int getTableId() {
		return this.tableId;
	}

	/**
	 * set the table ID of this table object
	 * @param tableId table ID to be set
	 */
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	/**
	 * get the status of this table object
	 * @return table status
	 */
	public String getTableStatus() {
		return status.name();
	}

	/**
	 * set the status of this table object to a string passed in
	 * @param status table status to be set
	 */
	public void setTableStatus(String status) {
		if(status.equals("VACANT"))
			this.status = TABLESTATUS.VACANT;
		else if(status.equals("OCCUPIED"))
			this.status = TABLESTATUS.OCCUPIED;
		else if(status.equals("RESERVED"))
			this.status = TABLESTATUS.RESERVED;
	}

	/**
	 * display status of this table object, table Id, table size, table status
	 */
	public void displayStatus()
	{
		System.out.printf("%-20s", getTableId());
		System.out.printf("%-20s", getNoOfPax());
		System.out.printf("%-20s%n",getTableStatus());
	}

}