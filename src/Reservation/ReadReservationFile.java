package Reservation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ReadReservationFile{
	
	private ArrayList<Reservation> ListOfReservations = new ArrayList<Reservation>();
	
	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy,HH:mm");
	
	private RemoveReservation removeReservationTime = new RemoveReservationTime();
	
	public ReadReservationFile(){
		
	}
	
	public ArrayList<Reservation> readReservationFromFile(String fileName) {
		ListOfReservations.clear();
		String tempFile = "tempo.txt";
		File file  = new File(fileName);
		File tempfile = new File(tempFile);
		copyContent(file, tempfile);

		Calendar cal = Calendar.getInstance();

		try{
		Scanner s = new Scanner(file);
			while(s.hasNextLine()){
				String line = s.nextLine();
				String[] items = line.split("\\|");

				Date rDate = sdf.parse(items[3]);
				Calendar calen = Calendar.getInstance();
				calen.setTime(rDate);
	
				if(cal.after(calen)){ // if reservation after current time
					removeReservationTime.removeReservation("tempo.txt", items[3]); // remove reservation
				}
				else{
					Reservation reservation = new Reservation();
					reservation.setReservation_id(Integer.parseInt(items[0]));
					reservation.setTableId(Integer.parseInt(items[1]));
					reservation.setCustomer_id(Integer.parseInt(items[2]));
					reservation.setDateTime(items[3]);
					reservation.setNoOfPax(Integer.parseInt(items[4]));
					reservation.setCustomerName(items[5]);
					reservation.setContact(items[6]);

					ListOfReservations.add(reservation);
				}
			}
		s.close();
		file.delete();
		File dump = new File(fileName);
		tempfile.renameTo(dump);
		}
		catch(ParseException e){}
		catch(IOException e){}
		return ListOfReservations;
	}
	

	private static void copyContent(File a, File b){
		try{
	    	FileInputStream in = new FileInputStream(a);
	    	FileOutputStream out = new FileOutputStream(b);
	
	    	byte[] buffer = new byte[1024];
	
		    int length;
		    /*copying the contents from input stream to
		     * output stream using read and write methods
		     */
		    while ((length = in.read(buffer)) > 0){
		    	out.write(buffer, 0, length);
		    }
	
		    //Closing the input/output file streams
		    in.close();
		    out.close();
	
		    //System.out.println("File copied successfully!!");
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		 }
	}

}
