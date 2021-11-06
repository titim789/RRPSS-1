package Reservation;

import Table.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ReservationMgr {

	private List<Integer> tableSize = Arrays.asList(2,4,6,8,10);
	private ArrayList<Table> ListOfTables = new ArrayList<Table>();
	
	//-----------------Read Files -------------------------//
	private SaveFile saveFile = new SaveFile();
	
	//-----------------Read Files -------------------------//
	private ReadTableFile readTableFile = new ReadTableFile();
	private ReadReservationFile readReservationFile = new ReadReservationFile();
	
	//-----------------Display---------------------------//
	private TableDisplay tDisplay; // print Table display 
	DisplayAllReservations allReservations = new DisplayAllReservations();
	
	//-----------------Reservation---------------------------//
	private AddReservation addReservation = new AddReservation();
	private RemoveReservationId removeReservationId = new RemoveReservationId();
	private UpdateReservation updateReservation = new UpdateReservation();

	public ReservationMgr(){
		// create tables of random sizes(2,4,6,8,10)
		File newFile = new File("tables.txt");
		if (newFile.length() == 0) {
			try{
			Random rand = new Random();
			for(int i=0;i<30;i++){
				int randomElement = tableSize.get(rand.nextInt(tableSize.size()));
				Table table = new Table(i,randomElement);
				ListOfTables.add(table);
				String outputText = ListOfTables.get(i).getTableId() + "|" + ListOfTables.get(i).getNoOfPax() + 
									"|" + ListOfTables.get(i).getTableStatus();
				saveFile.saveToFile("tables.txt", outputText, true);
			}
			}catch(IOException e){}
		}
		else { System.out.println("File is not empty ..."); }
	}

	// method to print
	public void printTableStatus(){
		tDisplay = new TableDisplay(readTableFile.readTablesFromFile("tables.txt"));
		tDisplay.DisplayTable();
	}
	
	//Add new Reservation
	public void addNewReservation(){
		addReservation.newReservation();
	}
	
	//Display All Reservation
	public void DisplayReservations() {
		allReservations.ReservationDisplay(readReservationFile.readReservationFromFile("reservations.txt"));
	}
	
	//Remove reservation by id
	public void removeReservation() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter reservation id to delete:");
		String removeTerm = s.next();
		
		removeReservationId.removeReservation("reservations.txt", removeTerm);
		s.close();
	}

	//Update Existing reservations
	public void updateReservation() {
		
		String filepath = "reservations.txt";
		updateReservation.updateReservation(filepath);
	}
}