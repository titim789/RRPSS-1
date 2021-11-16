package reservation;

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

import table.TableMgr;

public class ReservationMgr {
	
	//-----------------Table Manager-------------------------//
	private TableMgr tableManager = new TableMgr();
	
	//-----------------Reservations -------------------------//
	private ArrayList<Reservation> listOfReservations;
		
	//-----------------Date Time Format-------------------------//
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
	//-----------------Reservation Display---------------------------//
	private ReservationUI reservationUI = new ReservationUI();
	
	public ReservationMgr(){
		listOfReservations = new ArrayList<Reservation>();
		load();
	}
	
	//-----------------Print Table---------------------------//
	public void displayTableDetails(){
		tableManager.displayTbl();
	}
	
	//-----------------Check Availability---------------------------//
	public void checkAvail(int n){
		if(tableManager.checkAvailability(n)) {
			//tableManager.displaySizeVacant(n);
			System.out.println("Table Found.");
		}
		else{
			System.out.println("No table of Size "+ n + " is vacant!!");
		}
	}
	
	//-----------------Cusomter arrive delete reservation change to occupied---------------------------//
	public void customerArrive(int reservationId) {
		int i;
		for(i=0; i<listOfReservations.size();i++)
		{
			if(listOfReservations.get(i).getReservationId() == reservationId) {
				tableManager.editTableDetail(listOfReservations.get(i).getTableId(),"OCCUPIED");
				System.out.println("Customer "+ listOfReservations.get(i).getCustomerName() +" has arrived!");
				listOfReservations.remove(i);
				return;
			}
		}
		System.out.println("reservationID: " + reservationId +" not found.");
	}
	
	public void customerWalkin(int tableId) {
		tableManager.editTableDetail(tableId,"OCCUPIED");
	}
	
	//-----------------Customer paid and leave change to vacant---------------------------//
	public void customerLeave(int tableId) {
		tableManager.editTableDetail(tableId,"VACANT");
	}
	
	
	//-----------------Add New Reservation---------------------------//
	public void newReservation(int customerId, String calen, int noOfPax, String name, String contact){
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int i = year*10000 + month*10000 + day*100 + hours*minutes ;
		
		int tableId = tableManager.sizeMoreTableSize(noOfPax);
		
		if(tableId != -1) {
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
			
			System.out.println("New Reservation "+ i +" has been added.");
			System.out.println(name + " has made a new reservation.");
		}
		else {
			System.out.println("Reservation Not added as no available tables meet the capacity.");
		}
	}
	
	//-----------------Remove Reservation By ID---------------------------//
	public void removeReservationId() {
		int resvId = reservationUI.getReservationIdFromUser();
		
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
		cal.add(Calendar.MINUTE, -15);
		
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
    	
    	removeReservationTime(); // remove reservation the past 15 mins of current time
    	
		switch(n) {
			case 0: 
			if(!listOfReservations.isEmpty()) {
				reservationUI.reservationDisplayAll(listOfReservations);
				int m = reservationUI.removeReservationDisplay();
				switch(m){
					case 0:
						removeReservationId();
						break;
					case 1:
						int resvId = reservationUI.getReservationIdFromUser();
						customerArrive(resvId);
						break;	
					case 2:
						break;
				}
			}
			else System.out.println("There are no Reservations!!");
			break;
			case 1: 
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			String date = day+"/"+month+"/"+year;
			if(checkDateResv(date)) {
				reservationUI.reservationDisplayDate(listOfReservations, date);
				int m = reservationUI.removeReservationDisplay();
				switch(m){
					case 0:
						removeReservationId();
						break;
					case 1:
						int resvId = reservationUI.getReservationIdFromUser();
						customerArrive(resvId);
						break;	
					case 2:
						break;
				}
			}
			else System.out.println("No reservations for "+date+"!!");
			break;
			
			case 2: 
			int term = reservationUI.getCustomerIdFromUser();
			if(checkCustResv(term)) {
				reservationUI.reservationDisplayCustomer(listOfReservations, term);
				int m = reservationUI.removeReservationDisplay();
				switch(m){
					case 0:
						removeReservationId();
						break;
					case 1:
						int resvId = reservationUI.getReservationIdFromUser();
						customerArrive(resvId);
						break;	
					case 2:
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
	
	//-----------------Check Date Reservation---------------------------//
	public boolean checkDateResv(String date){
  		String dt,d;
  		for(Reservation resv : listOfReservations) {
  			dt = resv.getDateTime();
			String[] part = dt.split(" ");
			d = part[0];
  			if (d.equals(date)) {
  				return true;
  			}
  		}
  		return false;
  	}
    
    	//-----------------Update Existing reservations---------------------------//
  	public void updateReservation(int editTerm) {
		
		if(checkCustResv(editTerm)) {
			reservationUI.reservationDisplayCustomer(listOfReservations, editTerm);
		
			Scanner scan = new Scanner(System.in);
			int resvTerm = reservationUI.getReservationIdFromUser();
		
			int choice;
			int tableId = -1; int cusId = -1;String date = "";String time ="";int noPax = -1;String cName = "";String contactNo = "";
			do{
				choice = reservationUI.updateReservationDisplay();
				switch(choice){
					case 1:
						tableId = reservationUI.getTableIdFromUser();
						break;
					case 2:
						cusId = reservationUI.getCustomerIdFromUser();
						break;
					case 3:
						date = reservationUI.getDateFromUser();
						break;
					case 4:
						time = reservationUI.getTimeFromUser();
						break;
					case 5:
						noPax = reservationUI.getPaxFromUser();
						break;
					case 6:
						cName = reservationUI.getNameFromUser();
						break;
					case 7:
						contactNo = reservationUI.getContactFromUser();
						break;
				}
			}while(choice != 8);
			
			int tid = -1; int cid = -1;String dt = "";String d = "";String t = "";int pax = -1;String name = "";String contact = "";
			
			for(Reservation resv : listOfReservations) {
				
				tid = resv.getTableId();
				cid = resv.getCustomerId();
				dt = resv.getDateTime();
				String[] part = dt.split(" ");
				d = part[0];
				t = part[1];
				pax = resv.getNoOfPax();
				name = resv.getCustomerName();
				contact = resv.getContact();
				
				if (resv.getReservationId() == resvTerm && resv.getCustomerId() == editTerm) {
					if(tableId == -1) tableId = tid;
					if(cusId == -1) cusId = cid;
					if(date == "") date = d;
					if(time == "") time = t;
					if(noPax == -1) noPax = pax;
					if(cName == "") cName = name;
					if(contactNo == "") contactNo = contact;
					
					if(tableId != tid){ // change in table
						tableManager.editTableDetail(tid,"VACANT");
						tableManager.editTableDetail(tableId,"RESERVED");
					}
					resv.setTableId(tableId);
					resv.setCustomerId(cusId);
					resv.setDateTime(date+" "+time);
					resv.setNoOfPax(noPax);
					resv.setCustomerName(cName);
					resv.setContact(contactNo);
					
					System.out.println("Reservation " + resv.getReservationId() +" has been updated.");
				}
			}
	  	
	  	}
		else System.out.println("This Customer has no reservations!!");
  	}

  	//-----------------Save--------------------------//
  	public void save() {
  		tableManager.save();
  		try {
  		    FileOutputStream fos = new FileOutputStream("reservations.txt");
  		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
  		    oos.writeObject(listOfReservations);
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
  		    FileInputStream readData = new FileInputStream("reservations.txt");
  		    ObjectInputStream readStream = new ObjectInputStream(readData);
  		  listOfReservations = (ArrayList<Reservation>) readStream.readObject();
  		    readStream.close();
  		}catch (Exception e) {
  		    e.printStackTrace();
  		}
  	}
	
}
