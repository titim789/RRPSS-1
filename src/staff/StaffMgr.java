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

public class StaffMgr{
	private static ArrayList<Staff> listOfStaff;
	
	public StaffMgr() {
		listOfStaff = new ArrayList<Staff>();
		load();
	}
	

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
	
	// remove staff based on staffId, store into a temp ArrayList if staddId is not StaffIdRemoval
	public void removeStaff() {
		StaffUI staffui = new StaffUI();
		// remove staff object from the ArrayList of Staff
		int staffIdRemoval = staffui.getRemoveId();			
		displayStaffList();
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
	
	// function to add staff object to the list of staff
	public void addStaff() {
		StaffUI staffui = new StaffUI();
		int staffId = getLastId()+1;
		System.out.println("staffID to insert:"+staffId);
		
		// launch StaffUI to get staff info
		String name = staffui.getStaffName();
		String gender = staffui.getStaffGender();				
		String title = staffui.getStaffTitle();		

		System.out.println("Staff List Updated..");
		listOfStaff.add(new Staff(staffId, name, gender, title));
		displayStaffList();
	}

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

	// public void load() {
	// 	// TODO - implement Menu.load
	// 	try{
	// 	    FileInputStream readData = new FileInputStream("staffList.txt");
	// 	    ObjectInputStream readStream = new ObjectInputStream(readData);
	// 	    listOfStaff = (ArrayList<Staff>) readStream.readObject();
	// 	    readStream.close();
	// 	    //System.out.println(listOfMenuItems.toString());
	// 	}catch (Exception e) {
	// 	    e.printStackTrace();
	// 	}
		
	// }
	
	// public void save() {
	// 	// TODO - implement Menu.save
	// 	try {
	// 	    FileOutputStream fos = new FileOutputStream("staffList.txt");
	// 	    ObjectOutputStream oos = new ObjectOutputStream(fos);   
	// 	    oos.writeObject(listOfStaff); // write List of customer to ObjectOutputStream
	// 	    oos.close(); 
	// 	} catch(Exception ex) {
	// 	    ex.printStackTrace();
	// 	}
	// }
}