package Reservation;

public class CheckReservation {
	
	DisplayCustomerReservations cusReservations = new DisplayCustomerReservations();
	private ReadReservationFile readReservationFile = new ReadReservationFile();
	
	public CheckReservation() {
		
	}
	
	public void checkReservation(int cid) {
		cusReservations.CustomerReservationDisplay(readReservationFile.readReservationFromFile("reservations.txt"),cid);
	}
}

