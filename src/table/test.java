package table;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import reservation.Reservation;

public class test {
	public static void main(String []args) {
		ArrayList<Table> listOfTables = new ArrayList<Table>();
		listOfTables.add(new Table(0,4 ));
		listOfTables.add(new Table(1,6 ));
		listOfTables.add(new Table(2,4 ));
		listOfTables.add(new Table(3,10 ));
		listOfTables.add(new Table(4,4 ));
		listOfTables.add(new Table(5,2 ));
		listOfTables.add(new Table(6,4 ));
		listOfTables.add(new Table(7,6 ));
		listOfTables.add(new Table(8,10 ));
		listOfTables.add(new Table(9,10 ));
		listOfTables.add(new Table(10,2 ));
		listOfTables.add(new Table(11,6 ));
		listOfTables.add(new Table(12,8 ));
		listOfTables.add(new Table(13,4 ));
		listOfTables.add(new Table(14,4 ));
		listOfTables.add(new Table(15,4 ));
		listOfTables.add(new Table(16,8 ));
		listOfTables.add(new Table(17,10 ));
		listOfTables.add(new Table(18,10 ));
		listOfTables.add(new Table(19,4 ));
		listOfTables.add(new Table(20,4 ));
		listOfTables.add(new Table(21,2 ));
		listOfTables.add(new Table(22,4 ));
		listOfTables.add(new Table(23,4 ));
		listOfTables.add(new Table(24,6 ));
		listOfTables.add(new Table(25,2 ));
		listOfTables.add(new Table(26,2 ));
		listOfTables.add(new Table(27,6 ));
		listOfTables.add(new Table(28,4 ));
		listOfTables.add(new Table(29,8 ));
		
		try {
		    FileOutputStream fos = new FileOutputStream("tables.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(listOfTables); // write MenuArray to ObjectOutputStream
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
}
