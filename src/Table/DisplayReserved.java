package Table;

import java.util.*;

public class DisplayReserved implements DisplayTableInterface{

    public DisplayReserved(){}

    public void displayTables(ArrayList<Table>ListOfTables){
        for(Table table : ListOfTables){
            if(table.getTableStatus().equals("RESERVED"))
                table.displayStatus();
        }
    }

}