package table;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class is used to manage the table.
 */
public class TableMgr {
	
	//-----------------Tables -------------------------//
	/**
	 * The list of table sizes
	 */
	private List<Integer> tableSize = Arrays.asList(2,4,6,8,10);
	
	/**
	  * An array list of table objects 
	*/
	private ArrayList<Table> listOfTables = new ArrayList<Table>();
	
	
	//-----------------Display Table-------------------------//
	/**
	 * Table UI for capturing users inputs 
	*/
	private TableUI tableUI = new TableUI();
	
	//-----------------Constructor-------------------------//
	/** 
	 * Constructor for the table manager
	 */
	public TableMgr(){
		load();
		/*if(listOfTables.isEmpty()){
			Random rand = new Random();
			for(int i=0;i<30;i++){
				int randomElement = tableSize.get(rand.nextInt(tableSize.size()));
				Table table = new Table(i,randomElement);
				listOfTables.add(table);
			}
			save();
		}*/
	}
	
	//---------------------Get Table Array-------------------------//
	/**
	 * returns list of table objects
	 * @return list of table objects
	 */
	public ArrayList<Table> getTableList(){
		return listOfTables;
	}
	
	//----------------------Display----------------------------//
	/**
	 * Depending on the input, displays the table list with corresponding table status
	 */
	public void displayTbl() {
		
		int n = tableUI.getDisplayType();
		
		switch(n) {
			case 0: 
			if(checkVacant())
				tableUI.displayTableVacant(listOfTables);
			else System.out.println("No tables are Vacant!");
			break;
			case 1: 
			if(checkOccupied())
				tableUI.displayTableOccupied(listOfTables);
			else System.out.println("No tables are Occupied!");
			break;
			case 2: 
			if(checkReserve())
				tableUI.displayTableReserved(listOfTables);
			else System.out.println("No tables are Reserved!");
			break;
		}
	}
	
	//-----------------Get Available Table---------------------------//
	/**
	 * get the available table id based on number of pax pass in
	 * @param pax number of pax to compare with
	 * @return table id of available table
	 */
	public int getAvailableTable(int pax) {
		for(Table table : listOfTables) {
			if(table.getNoOfPax() == pax && (table.getTableStatus()).equals("VACANT")) return table.getTableId();			
		}
		for(Table table : listOfTables) {
			if(table.getNoOfPax() > pax && (table.getTableStatus()).equals("VACANT")) return table.getTableId();			
		}
		return -1;
	}
	
	
	//-----------------print Size Of Table---------------------------//
	/**
	 * print the size of the table
	 * @param pax number of pax for vacant
	 */
	public void displaySizeVacant(int pax){
		tableUI.displayTablePax(listOfTables, pax);
	}
	
	//-----------------Check Vacant---------------------------//
	/**
	 * check if there is any vacant table, returns true if there is
	 * @return boolean true if there is vacant table
	*/
	public boolean checkVacant(){
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("VACANT")) {
				return true;
			}
		}
		return false;
	}
	
	//-----------------Check Occupied---------------------------//
	/**
	 * check if there is any occupied table, returns true if there is
	 * @return boolean true if there is occupied table
	*/
	public boolean checkOccupied(){
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("OCCUPIED")) {
				return true;
			}
		}
		return false;
	}
		
	//-----------------Check Reserved---------------------------//
	/**
	 * check if there is any reserved table, returns true if there is
	 * @return boolean true if there is reserved table
	 */
	public boolean checkReserve(){
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("RESERVED")) {
				return true;
			}
		}
		return false;
	}
	
	//-----------------Check people fit TableSize---------------------------//
	/**
	 * returns an table ID that fits that number of pax pass in
	 * @param pax number of pax
	 * @return table ID if can a table that fits, -1 if cannot fit
	 */
	public int sizeMoreTableSize(int pax){
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("VACANT") && table.getNoOfPax() >= pax) {
				return table.getTableId();
			}
		}
		return -1;
	}
	
	//-----------------Check Size Of Table---------------------------//
	/**
	 * check if there is any table that fits the pax, returns true if there is
	 * @param pax number of pax
	 * @return boolean true if there is a table that fits
	 */
	public boolean checkAvailability(int pax){
		for(Table table : listOfTables) {
			if (table.getNoOfPax() >= pax && table.getTableStatus().equals("VACANT")) {
				return true;
			}
		}
		return false;
	}
	
	//-----------------Update Table---------------------------//
	/**
	 * pass in table ID, and update table status
	 * @param num table id to update
	 * @param newstatus status to update table to
	 */
	public void editTableDetail(int num, String newstatus){
		for(Table table : listOfTables) {
			if (table.getTableId() == num) {
				listOfTables.get(num).setTableStatus(newstatus);
			}
		}
	}
	
	//-----------------Save--------------------------//
	/**
	 * save the list of table objects to the file
	*/
	public void save() {
		try {
		    FileOutputStream fos = new FileOutputStream("table.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(listOfTables); // write MenuArray to ObjectOutputStream
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	//-----------------Load---------------------------//
	/**
	 * load the list of table objects from the file
	 */
	@SuppressWarnings("unchecked")
	public void load() {
		try{
		    FileInputStream readData = new FileInputStream("table.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfTables = (ArrayList<Table>) readStream.readObject();
		    readStream.close();
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}	
}
