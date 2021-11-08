package table;

import java.util.*;

public class TableUI {
	
	public TableUI() {}
	
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
