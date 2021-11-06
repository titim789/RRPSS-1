package Reservation;
import Table.*;

//import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AddReservation {
	
	private ArrayList<Table> ListOfTables = new ArrayList<Table>();
	private ReadTableFile readTableFile = new ReadTableFile();
	private EditTable editTable = new EditTable();
	private SaveFile saveFile = new SaveFile();
	
	public AddReservation() {}
	
	public void newReservation(){

		//File newFile = new File("reservations.txt");
		try{
			Random random = new Random();
			int i = random.nextInt((100 - 0) + 1) + 0;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Table id to be assigned : ");
			int table_id = sc.nextInt();
			System.out.print("Enter Customer id: ");
			int customer_id = sc.nextInt();
			System.out.print("Enter Date and Time in (dd/MM/yyyy,HH:mm) format: ");
			String cal = sc.next();
			System.out.print("Enter Number of people: ");
			int noOfpax = sc.nextInt();
			System.out.print("Enter Customer Name : ");
			String name = sc.next();
			System.out.print("Enter Contact Number : ");
			String contact = sc.next();

			Reservation reservation = new Reservation();
			reservation.setReservation_id(i);
			reservation.setTableId(table_id);
			reservation.setCustomer_id(customer_id);
			reservation.setDateTime(cal);
			reservation.setNoOfPax(noOfpax);
			reservation.setCustomerName(name);
			reservation.setContact(contact);
			String outputText = i + "|" + table_id + "|" + customer_id +  "|" + cal +
								"|" + noOfpax +  "|" + name + "|" + contact;
			if(checkReserve(table_id)){
				saveFile.saveToFile("reservations.txt", outputText, true);
				editTable.editTableDetail("tables.txt", table_id,"RESERVED");
				System.out.println("Table is Assigned!!\n");
			}
			else System.out.println("Table is already reserved or occupied!\n");
			sc.close();
		}
		catch(Exception e){}
	}
	
	private boolean checkReserve(int table_id){
		ListOfTables.clear();
		ListOfTables = readTableFile.readTablesFromFile("tables.txt");
		for(Table table : ListOfTables){
            if(table.getTableId() == table_id && table.getTableStatus().equals("RESERVED") && table.getTableStatus().equals("OCCUPIED"))
               return false;
        }
		ListOfTables.clear();
		return true;
	}
	
}
