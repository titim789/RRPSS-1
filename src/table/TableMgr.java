package table;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TableMgr {
	
	//-----------------Tables -------------------------//
	private List<Integer> tableSize = Arrays.asList(2,4,6,8,10);
	private ArrayList<Table> listOfTables = new ArrayList<Table>();
	
	//-----------------Display Table-------------------------//
	private TableUI tableUI = new TableUI();
	
	//-----------------Constructor-------------------------//
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
		}
		else {
			System.out.println("Array is not empty ...");	
		}*/
	}
	
	//---------------------Get Table Array-------------------------//
	public ArrayList<Table> getTableList(){
		return listOfTables;
	}
	
	//----------------------Display----------------------------//
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
	//-----------------Check Vacant---------------------------//
	public boolean checkVacant(){
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("VACANT")) {
				return true;
			}
		}
		return false;
	}
	
	//-----------------Check Vacant---------------------------//
	public boolean checkOccupied(){
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("OCCUPIED")) {
				return true;
			}
		}
		return false;
	}
		
	//-----------------Check Vacant---------------------------//
	public boolean checkReserve(){
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("RESERVED")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAvailability(){
		int pax = tableUI.getSizeCheck();
		for(Table table : listOfTables) {
			if ((table.getTableStatus()).equals("VACANT") && table.getNoOfPax() == pax) {
				tableUI.displayTablePax(listOfTables, pax);
				return true;
			}
		}
		return false;
	}
	
	
	//-----------------Update Table---------------------------//
	public void editTableDetail(int num, String newstatus){
		for(Table table : listOfTables) {
			if (table.getTableId() == num) {
				listOfTables.get(num).setTableStatus(newstatus);
			}
		}
	}
	
	//-----------------Save--------------------------//
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
	@SuppressWarnings("unchecked")
	public void load() {
		try{
		    FileInputStream readData = new FileInputStream("tables.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfTables = (ArrayList<Table>) readStream.readObject();
		    readStream.close();
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}	
}
