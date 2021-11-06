package Table;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTableFile{
	
	private ArrayList<Table> ListOfTables = new ArrayList<Table>();
	
	public ReadTableFile(){
	
	}
	
	public ArrayList<Table> readTablesFromFile(String fileName) {
		ListOfTables.clear();
		File file  = new File(fileName);
		try{
		Scanner s = new Scanner(file);
			while(s.hasNextLine()){
				String line = s.nextLine();
				String[] items = line.split("\\|");

				Table table = new Table();
				table.setTableId(Integer.parseInt(items[0]));
				table.setNoOfPax(Integer.parseInt(items[1]));
				table.setTableStatus(items[2]);

				ListOfTables.add(table);
			}
			s.close();
		}catch(IOException e){}
		return ListOfTables;
	}

}
