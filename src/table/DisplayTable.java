package table;

import java.util.ArrayList;

public class DisplayTable {
	
	public DisplayTable() {}
	
	public void displayTableVacant(ArrayList<Table>ListOfTables){
		System.out.printf("%n%-20s", "Table Number");
        System.out.printf("%-20s", "Number of Seats");
        System.out.printf("%-20s%n", "Table Status");
        for(Table table : ListOfTables){
            if(table.getTableStatus().equals("VACANT"))
                table.displayStatus();
        }
    }
	
	public void displayTableOccupied(ArrayList<Table>ListOfTables){
		System.out.printf("%n%-20s", "Table Number");
        System.out.printf("%-20s", "Number of Seats");
        System.out.printf("%-20s%n", "Table Status");
        for(Table table : ListOfTables){
            if(table.getTableStatus().equals("OCCUPIED"))
                table.displayStatus();
        }
    }
	
	public void displayTableReserved(ArrayList<Table>ListOfTables){
		System.out.printf("%n%-20s", "Table Number");
        System.out.printf("%-20s", "Number of Seats");
        System.out.printf("%-20s%n", "Table Status");
        for(Table table : ListOfTables){
            if(table.getTableStatus().equals("RESERVED"))
                table.displayStatus();
        }
    }
}
