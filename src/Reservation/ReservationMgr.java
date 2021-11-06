package Reservation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ReservationMgr {
	
	//-----------------Table Manager-------------------------//
	private TableMgr tableManager = new TableMgr();
	
	//-----------------Reservations -------------------------//
	private ArrayList<Reservation> listOfReservations = new ArrayList<Reservation>();
		
	//-----------------Date Time Format-------------------------//
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy,HH:mm");
		
	//-----------------Reservation Display---------------------------//
	private DisplayReservation displayReservation = new DisplayReservation();
	
	public ReservationMgr(){
		load();
	}
	
	//-----------------Print Table---------------------------//
	public void displayTableDetails(){
		tableManager.displayTbl();
	}
	
	
	//-----------------Add New Reservation---------------------------//
	public void newReservation(int tableId, int customerId, String calen, int noOfPax, String name, String contact){
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int i = year*10000 + month*10000 + day*100 + hours*minutes ;
		
		Reservation reservation = new Reservation();
		reservation.setReservationId(i);
		reservation.setTableId(tableId);
		reservation.setCustomerId(customerId);
		reservation.setDateTime(calen);
		reservation.setNoOfPax(noOfPax);
		reservation.setCustomerName(name);
		reservation.setContact(contact);
		
		listOfReservations.add(reservation);
		tableManager.editTableDetail(tableId,"RESERVED");
	}
	
	//-----------------Remove Reservation By ID---------------------------//
	public void removeReservationId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Reservation Id to be deleted : ");
		int resvId = sc.nextInt();
		
		int i;
		for(i=0; i<listOfReservations.size();i++)
		{
			if(listOfReservations.get(i).getReservationId() == resvId) {
				tableManager.editTableDetail(listOfReservations.get(i).getTableId(),"VACANT");
				listOfReservations.remove(i);
				System.out.println("reservationID: " + resvId + " has been removed.");
				return;
			}
		}
		System.out.println("reservationID: " + resvId +" not found.");
	}
	
	//-----------------Remove Reservation By ID---------------------------//
	public void removeReservationTime() {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -5);
		
		try {
		int i;
		for(i=0; i<listOfReservations.size();i++){
			Date rDate = sdf.parse(listOfReservations.get(i).getDateTime());
			Calendar calen = Calendar.getInstance();
			calen.setTime(rDate);
			
			if(cal.after(calen)){
				tableManager.editTableDetail(listOfReservations.get(i).getTableId(),"VACANT");
				listOfReservations.remove(i);
			}
		}
		}catch(ParseException e){}
	}
	
	//-----------------Display Reservation---------------------------//
    public void displayResv(int n) {
    	
    	removeReservationTime(); // remove reservation the past 10 mins of current time
    	
		switch(n) {
			case 0: 
			if(!listOfReservations.isEmpty()) {
				displayReservation.reservationDisplayAll(listOfReservations);
				int m = displayReservation.removeReservationDisplay();
				switch(m){
					case 0:
						removeReservationId();
						break;
					case 1:
						break;
				}
			}
			else System.out.println("There are no Reservations!!");
			break;
			case 1: 
			int term = displayReservation.removeReservationDisplay();
			if(checkCustResv(term)) {
				displayReservation.reservationDisplayCustomer(listOfReservations, term);
				int m = displayReservation.removeReservationDisplay();
				switch(m){
					case 0:
						removeReservationId();
						break;
					case 1:
						break;
				}
			}
			else System.out.println("Customer ID "+ term +" has no reservations!!");
			break;
		}
	}
    
    //-----------------Check Customer Reservation---------------------------//
  	public boolean checkCustResv(int customerId){
  		for(Reservation resv : listOfReservations) {
  			if (resv.getCustomerId() == customerId) {
  				return true;
  			}
  		}
  		return false;
  	}
    
    //-----------------Update Existing reservations---------------------------//
  	public void updateReservation(int editTerm) {
		
		if(checkCustResv(editTerm)) {
			displayReservation.reservationDisplayCustomer(listOfReservations, editTerm);
		
			System.out.print("\nEnter Reservation Id to update : ");
			Scanner scan = new Scanner(System.in);
			int resvTerm = scan.nextInt();
		
			int choice;
			int tableId = -1; int cusId = -1;String date = "";int noPax = -1;String cName = "";String contactNo = "";
			do{
				choice = displayReservation.updateReservationDisplay();
				switch(choice){
					case 1:
						System.out.print("Enter new Table ID : ");
						tableId = scan.nextInt();
						break;
					case 2:
						System.out.print("Enter new Customer ID : ");
						cusId = scan.nextInt();
						break;
					case 3:
						System.out.print("Enter new Date Time in (dd/MM/yyyy,HH:mm) format : ");
						date = scan.next();
						break;
					case 4:
						System.out.print("Enter new Number of People : ");
						noPax = scan.nextInt();
						break;
					case 5:
						System.out.print("Enter new Customer Name : ");
						cName = scan.next();
						break;
					case 6:
						System.out.print("Enter new Contact Number : ");
						contactNo = scan.next();
						break;
				}
			}while(choice != 7);
			
			int tid = -1; int cid = -1;String dt = "";int pax = -1;String name = "";String contact = "";
			
			for(Reservation resv : listOfReservations) {
				
				tid = resv.getTableId();
				cid = resv.getCustomerId();
				dt = resv.getDateTime();
				pax = resv.getNoOfPax();
				name = resv.getCustomerName();
				contact = resv.getContact();
				
				if (resv.getReservationId() == resvTerm && resv.getCustomerId() == editTerm) {
					if(tableId == -1) tableId = tid;
					if(cusId == -1) cusId = cid;
					if(date == "") date = dt;
					if(noPax == -1) noPax = pax;
					if(cName == "") cName = name;
					if(contactNo == "") contactNo = contact;
					
					if(tableId != tid){ // change in table
						tableManager.editTableDetail(tid,"VACANT");
						tableManager.editTableDetail(tableId,"RESERVED");
					}
					resv.setTableId(tableId);
					resv.setCustomerId(cusId);
					resv.setDateTime(date);
					resv.setNoOfPax(noPax);
					resv.setCustomerName(cName);
					resv.setContact(contactNo);
				}
			}
	  	
	  	}
		else System.out.println("This Customer has no reservations!!");
  	}

  	//-----------------Save--------------------------//
  	public void save() {
  		tableManager.save();
  		try {
  		    FileOutputStream fos = new FileOutputStream("reservation.txt");
  		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
  		    oos.writeObject(listOfReservations); // write MenuArray to ObjectOutputStream
  		    oos.close(); 
  		} catch(Exception ex) {
  		    ex.printStackTrace();
  		}
  	}
  	
  	//-----------------Load---------------------------//
  	@SuppressWarnings("unchecked")
  	public void load() {
  		tableManager.load();
  		try{
  		    FileInputStream readData = new FileInputStream("reservation.txt");
  		    ObjectInputStream readStream = new ObjectInputStream(readData);
  		  listOfReservations = (ArrayList<Reservation>) readStream.readObject();
  		    readStream.close();
  		}catch (Exception e) {
  		    e.printStackTrace();
  		}
  	}
	
}
