package Table;

import java.util.*;

public class TableDisplay {

    private DisplayTableInterface displayTableInterface;
	private ArrayList<Table> listOfTables = new ArrayList<Table>();

    public TableDisplay(ArrayList<Table> list){
		for(Table table: list){
			listOfTables.add(table);
		}
    }

    private void printTables(DisplayTableInterface dInterface) {
		System.out.printf("%n%-20s", "Table Number");
        System.out.printf("%-20s", "Number of Seats");
        System.out.printf("%-20s%n", "Table Status");
	    dInterface.displayTables(listOfTables);
	}

    public void DisplayTable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSelect Which Type of Table Status to view?");
		System.out.println("V for Vacant");
		System.out.println("O for Occupied");
		System.out.println("R for Reserved");
		System.out.print("Enter your choice : ");
		char n = sc.next().charAt(0);

		switch(n) {
			case 'V': 
			displayTableInterface = new DisplayVacant();
			printTables(displayTableInterface);
			break;
			case 'v': 
			displayTableInterface = new DisplayVacant();
			printTables(displayTableInterface);
			break;
			case 'O': 
			displayTableInterface = new DisplayOccupied();
			printTables(displayTableInterface);
			break;
			case 'o': 
			displayTableInterface = new DisplayOccupied();
			printTables(displayTableInterface);
			break;
			case 'R': 
			displayTableInterface = new DisplayReserved();
			printTables(displayTableInterface);
			break;
			case 'r': 
			displayTableInterface = new DisplayReserved();
			printTables(displayTableInterface);
			break;
		}
		sc.close();
	}
}
