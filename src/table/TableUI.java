package table;

import java.util.*;

/**
 * TableUI class for capturing user inputs and displaying menu options
 */
public class TableUI {
	/**
	 * Method for instantciating new TableUI object
	 */
	public TableUI() {}
	
	/** 
	 * Displays the list of vacant tables
	 * @param ListOfTables The tables that are being viewed
	 */
	public void displayTableVacant(ArrayList<Table>ListOfTables){
		System.out.printf("%n%-20s", "Table Number");
        	System.out.printf("%-20s", "Number of Seats");
        	System.out.printf("%-20s%n", "Table Status");
        	for(Table table : ListOfTables){
            		if(table.getTableStatus().equals("VACANT"))
                	table.displayStatus();
        	}
    	}
	
	/** 
	 * Displays the list of occupied tables
	 * @param ListOfTables The tables that are being viewed
	 */
	public void displayTableOccupied(ArrayList<Table>ListOfTables){
		System.out.printf("%n%-20s", "Table Number");
        	System.out.printf("%-20s", "Number of Seats");
        	System.out.printf("%-20s%n", "Table Status");
        	for(Table table : ListOfTables){
            		if(table.getTableStatus().equals("OCCUPIED"))
                		table.displayStatus();
        	}
    	}
	
	/** 
	 * Displays the list of reserved tables
	 * @param ListOfTables The tables that are being viewed
	 */
	public void displayTableReserved(ArrayList<Table>ListOfTables){
		System.out.printf("%n%-20s", "Table Number");
        	System.out.printf("%-20s", "Number of Seats");
        	System.out.printf("%-20s%n", "Table Status");
        	for(Table table : ListOfTables){
            		if(table.getTableStatus().equals("RESERVED"))
                		table.displayStatus();
        	}
    	}
	
	/** 
	 * Displays the list of vacant tables that can accomodate a certain number of people
	 * @param ListOfTables The tables that are being viewed
	 * @param n The number of people to check for
	 */
	public void displayTablePax(ArrayList<Table>ListOfTables, int n){
		System.out.printf("%n%-20s", "Table Number");
        	System.out.printf("%-20s", "Number of Seats");
        	System.out.printf("%-20s%n", "Table Status");
        	for(Table table : ListOfTables){
            		if(table.getNoOfPax() >= n && table.getTableStatus().equals("VACANT"))
                		table.displayStatus();
        	}
    	}
	
	/** 
	 * Displays menu options, return user's choice
	 * @return int user's choice
	 */
	public int getDisplayType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSelect Which Type of Table Status to view?");
		System.out.println("0 : Vacant");
		System.out.println("1 : Occupied");
		System.out.println("2 : Reserved");
		System.out.print("Enter your choice : ");
		int n = sc.nextInt();
		return n;
	}
}
