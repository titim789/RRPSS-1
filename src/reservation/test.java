package reservation;

public class test {
	public static void main(String []args) {
		ReservationMgr mgr = new ReservationMgr();
		mgr.newReservation(0, 1, "14/11/21,12:30", 4, "LiFang", "12345678");
		mgr.displayResv(0);
	}
}
