package table;

public class Table {

	public enum TABLESTATUS {
		RESERVED,
		VACANT,
		OCCUPIED
	}

	private int tableId;
	private int noOfPax;
	private TABLESTATUS status;

	public Table(){}

	public Table(int tableId,int noOfPax) {
		this.tableId = tableId;
		this.noOfPax = noOfPax;
		this.status = TABLESTATUS.VACANT;
	}

	public int getNoOfPax() {
		return this.noOfPax;
	}

	public void setNoOfPax(int noOfPax) {
		this.noOfPax = noOfPax;
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableStatus() {
		return status.name();
	}

	public void setTableStatus(String status) {
		if(status.equals("VACANT"))
			this.status = TABLESTATUS.VACANT;
		else if(status.equals("OCCUPIED"))
			this.status = TABLESTATUS.OCCUPIED;
		else if(status.equals("RESERVED"))
			this.status = TABLESTATUS.RESERVED;
	}

	public void displayStatus()
	{
		System.out.printf("%-20s", getTableId());
		System.out.printf("%-20s", getNoOfPax());
		System.out.printf("%-20s%n",getTableStatus());
	}

}