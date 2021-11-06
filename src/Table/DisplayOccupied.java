package Table;

import java.util.*;

public class DisplayOccupied implements DisplayTableInterface{

    public DisplayOccupied(){}

    public void displayTables(ArrayList<Table>ListOfTables){
        for(Table table : ListOfTables){
            if(table.getTableStatus().equals("OCCUPIED"))
                table.displayStatus();
        }
    }

}