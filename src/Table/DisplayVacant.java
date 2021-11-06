package Table;

import java.util.*;

public class DisplayVacant implements DisplayTableInterface{

    public DisplayVacant(){}

    public void displayTables(ArrayList<Table>ListOfTables){
        for(Table table : ListOfTables){
            if(table.getTableStatus().equals("VACANT"))
                table.displayStatus();
        }
    }
}
