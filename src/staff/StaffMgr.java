package staff;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.lang.String;

/**
 * This is the controller class for the staff members.
 * @author Ng Li Wang
 * @version 1.0
 */
public class StaffMgr{
	/**
	 * A static list of staff objects.
	*/
	private static ArrayList<Staff> listOfStaff;
	
	/**
	 * Constructor for StaffMgr, initializes the listOfStaff ArrayList, and loads the data from the file
	 */
	public StaffMgr() {
		listOfStaff = new ArrayList<Staff>();
		load();
	}
	
	
	/**
	 * Method to display the list of staff
	 */
	// function to display the list of staff
	public void displayStaffList() {
		System.out.println(String.format("|%-10s", "ID")
		+"|"+String.format("%-20s", "Staff Name")
		+"|"+String.format("%-20s", "Gender")
		+"|"+String.format("%-20s", "Staff Title")
		);

		for(Staff staff : listOfStaff) {
			// print out staff object's attributes
			System.out.println(String.format("|%-10s", staff.getStaffId())
			+"|"+String.format("%-20s", staff.getStaffName())
			+"|"+String.format("%-20s", staff.getGender())
			+"|"+String.format("%-20s", staff.getJobTitle())
			);
		}
		}

// function to add staff object to the list of staff
	/**
	 * Method to get added staff information from user
	 */
	public void addStaffOption() {
		StaffUI staffui = new StaffUI();
		int staffId = getLastId()+1;
		System.out.println("staffID to insert:"+staffId);
		
		// launch StaffUI to get staff info
		String name = staffui.getStaffName();
		String gender = staffui.getStaffGender();				
		String title = staffui.getStaffTitle();		

		addStaff(staffId, name, gender, title);
		System.out.println("Staff List Updated..");
		displayStaffList();
	}

	/**
	 * Method to add staff objects to the static list of staff
	 * @param staffId Id of the staff to be added
	 * @param name name of the staff to be added
	 * @param gender gender of the staff to be added
	 * @param title title of the staff to be added
	 */
	public void addStaff(int staffId, String name, String gender, String title){
		listOfStaff.add(new Staff(staffId, name, gender, title));
	}


	/**
	 * Method to remove staff, which calls UI to prompt user for removal ID
	 */
	public void removeStaffOption() {
		StaffUI staffui = new StaffUI();
		// remove staff object from the ArrayList of Staff
		int staffIdRemoval = staffui.getRemoveId();			
		displayStaffList();
		removeStaff(staffIdRemoval);	
	}

	/**
	 * Method to remove staff, based on staffIdRemoval
	 * @param staffIdRemoval the id of the staff member to be removed
	 */
	public void removeStaff(int staffIdRemoval) {
		ArrayList<Staff> tempList = new ArrayList<Staff>();
		
		// for each staff in listOfStaff, add to a temp list if staffId is not StaffIdRemoval
		for(Staff staff: listOfStaff) {
			if(staff.getStaffId() != staffIdRemoval) {
				tempList.add(staff);
			}
		}
		
		listOfStaff.clear();
		listOfStaff.addAll(tempList);
		
		// show what's after removal
		System.out.println("Staff List Updated..");
		displayStaffList();
	}
	
	/** 
	 * returns the last ID in the staff list
	 * @return int returns the last staff ID in the staff list
	 */
	// returns the last auto increment staff id in the list
	public int getLastId() {
		int lastId = 0;
		for(Staff staff : listOfStaff) {
			if(staff.getStaffId() > lastId) {
				lastId = staff.getStaffId();
			}
		}
		return lastId;
	}
	
	/**
	 * checks if the staffId is already in the ArrayList, if yes, return true
	 * @param staffId the id of the staff member to be searched for
	 * @return boolean true if the staff member is found, false otherwise
	 */
	// checks if the staffId is already in the ArrayList, if yes, return true
	public boolean checkStaffId(int staffId) {

		for(int i = 0; i < listOfStaff.size(); i++) {
			// System.out.println("staffId: "+listOfStaff.get(i).getStaffId());
			if(listOfStaff.get(i).getStaffId() == staffId) {
				return true;
			}
		}
		// System.out.println("Invalid Staff ID");
		return false;
	}
	
	/** 
	 * save the list of staff into the file
	 * @param fileName the database file name to save to
	 */
	// save staff list to csv file
	public void save(String fileName) {
		// empty content in file fileName, then write new content, attributes of ListOfStaff2, then close the file
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(fileName));
			pw.print("");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pw = new PrintWriter(new FileWriter(fileName, true));
			pw.println("staffId,staffName,gender,jobTitle");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// write new content to file fileName
		try {
			pw = new PrintWriter(new FileWriter(fileName, true));
			for(Staff staff: listOfStaff) {
				pw.println(staff.getStaffId() + "," + staff.getStaffName() + "," + staff.getGender() + "," + staff.getJobTitle());
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	/**
	 * Method to load the staff list from the database file
	 */
	public void load(){
   		// TODO - to impelemnt staffmgr.load
		   ArrayList<Staff> listOfStaff = new ArrayList<Staff>();
		   
		   try {
			BufferedReader br = new BufferedReader(new FileReader("staffList.txt"));
			//to store a line
			String line = "";
			
			// to consume the header row of csv
			String headerLine = "";
			headerLine = br.readLine();
			
			// keeps instanciating staff object until no more rows
			while((line = br.readLine()) != null) {			
				// split a line of string into an array
				// [0] is id, [1] is name etc...
				String[] values = line.split(",");
				
				// append this staff object into the the array list of staff
				listOfStaff.add(new Staff(Integer.parseInt(values[0]),values[1], values[2],  values[3]));
			}
		} 
		// catch blocks for reading csv or if not will throw error
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// catch IO exception for br.readline()
			e.printStackTrace();
		}
		this.listOfStaff = listOfStaff;
 	}

	/**
	 * Method to save the staff list to the database file 
	 */
	public void save(){
		// TODO - implement staffmgr.save
			
		// empty content in file fileName, then write new content, attributes of ListOfStaff2, then close the file
			PrintWriter pw = null;
			
			// empty out file content
			try {
				pw = new PrintWriter(new File("staffList.txt"));
				pw.print("");
				pw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// write in header row
			try {
				pw = new PrintWriter(new FileWriter("staffList.txt", true));
				pw.println("staffId,staffName,gender,jobTitle");
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			// write new content to file fileName
			try {
				pw = new PrintWriter(new FileWriter("staffList.txt", true));
				for(Staff staff: listOfStaff) {
					pw.println(staff.getStaffId() + "," + staff.getStaffName() + "," + staff.getGender() + "," + staff.getJobTitle());
				}
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

}