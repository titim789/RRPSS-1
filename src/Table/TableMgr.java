package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TableMgr {
	
	//-----------------Tables -------------------------//
	private List<Integer> tableSize = Arrays.asList(2,4,6,8,10);
	private ArrayList<Table> listOfTables = new ArrayList<Table>();
	
	//-----------------Display Table-------------------------//
	private DisplayTable displayTable= new DisplayTable();
	
	
	//-----------------Constructor-------------------------//
	public TableMgr(){
		load();
		if(listOfTables.isEmpty()){
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
		}
	}
	
	//---------------------Get Table Array-------------------------//
	public ArrayList<Table> getTableList(){
		return listOfTables;
	}
	
	//----------------------Display----------------------------//
	public void displayTbl() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSelect Which Type of Table Status to view?");
		System.out.println("0 : Vacant");
		System.out.println("1 : Occupied");
		System.out.println("2 : Reserved");
		System.out.print("Enter your choice : ");
		int n = sc.nextInt();

		switch(n) {
			case 0: 
			if(checkVacant())
				displayTable.displayTableVacant(listOfTables);
			else System.out.println("No tables are Vacant!");
			break;
			case 1: 
			if(checkOccupied())
				displayTable.displayTableOccupied(listOfTables);
			else System.out.println("No tables are Occupied!");
			break;
			case 2: 
			if(checkReserve())
				displayTable.displayTableReserved(listOfTables);
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
		    FileInputStream readData = new FileInputStream("table.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    listOfTables = (ArrayList<Table>) readStream.readObject();
		    readStream.close();
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}	
}
