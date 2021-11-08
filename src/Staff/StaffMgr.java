package Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Staff.Staff;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.String;
import java.io.BufferedReader;

public class StaffMgr {
	private static ArrayList<Staff> ListOfStaff;
	
	public StaffMgr() {
		ListOfStaff = new ArrayList<Staff>();
		ListOfStaff = loadStaffList("staffList.txt");
	}
	
	public void init() {
		StaffUI staffui = new StaffUI();
		int choice;
		
		while((choice = staffui.displayMenu()) != 5) {
			switch(choice) {
			// Display staff
			case 1:
				displayStaffList();
				break;
			
			// Add staff
			case 2:	
				// an mgr function to get new staffId to be inserted
				int staffId = getLastId()+1;
				System.out.println("staffID to insert:"+staffId);
				
				// launch StaffUI to get staff info
				String name = staffui.getStaffName();
				String gender = staffui.getStaffGender();				
				String title = staffui.getStaffTitle();
				
				addStaff(staffId, name, gender, title);				

				System.out.println("Staff List Updated..");
				displayStaffList();
				break;
			
			
			// remove staff
			case 3:
			
			displayStaffList();
			
			// remove staff object from the ArrayList of Staff
			int staffIdRemoval = staffui.getRemoveId();			
			removeStaff(staffIdRemoval);

			// show what's after removal
			System.out.println("Staff List Updated..");
			displayStaffList();
			
			break;
			
			case 4:
				// insert function to go back one level
				// save ArrayList of Staff to csv file

				System.out.println("StaffList saved to file");
				displayStaffList();
				saveStaffList("StaffList.txt");
				break;
				
			// quit
			case 5:
				choice = 5;
				System.out.println("Program Terminated");
				break;
		}
		
	}}

	// checks if the staffId is already in the ArrayList, if yes, return true
	public boolean checkStaffId(int staffId) {
		ListOfStaff = loadStaffList("StaffList.txt");

		for(int i = 0; i < ListOfStaff.size(); i++) {
			System.out.println("staffId: "+ListOfStaff.get(i).getStaffId());
			if(ListOfStaff.get(i).getStaffId() == staffId) {
				return true;
			}
		}
		// System.out.println("Invalid Staff ID");
		return false;
	}
	
	// remove staff based on staffId, store into a temp ArrayList if staddId is not StaffIdRemoval
	private void removeStaff(int staffIdRemoval) {
		ArrayList<Staff> tempList = new ArrayList<Staff>();
		
		// for each staff in listOfStaff, add to a temp list if staffId is not StaffIdRemoval
		for(Staff staff: ListOfStaff) {
			if(staff.getStaffId() != staffIdRemoval) {
				tempList.add(staff);
			}
		}
		
		ListOfStaff.clear();
		ListOfStaff.addAll(tempList);
		
		System.out.println("Staff Removed..");
		displayStaffList();
	}

	// function to display the list of staff
	public void displayStaffList() {
		for(Staff staff : ListOfStaff) {
			// print out staff object's attributes
			System.out.println(staff.getStaffId() + " " + staff.getStaffName() + " " + staff.getGender() + " " + staff.getJobTitle());
		}
		}

	// save staff list to csv file
	private void saveStaffList(String fileName) {
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
			for(Staff staff: ListOfStaff) {
				pw.println(staff.getStaffId() + "," + staff.getStaffName() + "," + staff.getGender() + "," + staff.getJobTitle());
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// pass in a file name, and returns a list of <staff> objects
	public ArrayList<Staff> loadStaffList(String fileName){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
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
				ListOfStaff.add(new Staff(Integer.parseInt(values[0]),values[1], values[2],  values[3]));
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
		return ListOfStaff;
	}
	
	
	// function to add staff object to the list of staff
	public void addStaff(int staffId, String name, String gender, String title) {
			ListOfStaff.add(new Staff(staffId, name, gender, title));

	}

	// returns the last auto increment staff id in the list
	public int getLastId() {
		int lastId = 0;
		for(Staff staff : ListOfStaff) {
			if(staff.getStaffId() > lastId) {
				lastId = staff.getStaffId();
			}
		}
		return lastId;
	}

	
}