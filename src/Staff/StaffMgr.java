package Staff;

import java.util.ArrayList;
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
	private ArrayList<Staff> ListOfStaff;
	
	
	// when initialise StaffMgr(), a list of <staff> objects are created
	public StaffMgr() {
		ListOfStaff = loadStaffList("StaffList.txt");
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
				// return last id
				int staffId = returnNextAvailStaffId("StaffList.txt");
				String name = staffui.getStaffName();
				String gender = staffui.getStaffGender();				
				String title = staffui.getStaffTitle();
				addStaff(staffId, name, gender, title);
				System.out.println("Staff List Updated..");
				displayStaffList();
				break;
			
			
			// remove staff
			case 3:
			String staffId1 = staffui.getRemoveId();
			removeStaff(staffId1);
			System.out.println("Staff List Updated..");
			displayStaffList();
			break;
			
			case 4:
				// insert function to go back one level
				break;
				
			// quit
			case 5:
				choice = 5;
				System.out.println("Program Terminated");
				break;
		}
		
	}}
	
	// pass in a file name, and returns a list of <staff> objects
	public ArrayList<Staff> loadStaffList(String fileName){
		ArrayList<Staff> ListOfStaff = new ArrayList<Staff>();
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
				
				// takes the corresponding array[0], fit into staff object
				Staff staff = new Staff();
				int i = Integer.parseInt(values[0]);
				staff.setStaff_id(i);
				staff.setStaff_name(values[1]);
				staff.setGender(values[2]);
				staff.setJob_title(values[3]);
				
				// append this staff object into the the array list of staff
				ListOfStaff.add(staff);
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
	
	// function to display the list of staff
	public void displayStaffList() {
		try {
			FileReader fr = new FileReader("StaffList.txt");
			BufferedReader br = new BufferedReader(fr);
			//to store a line
			String line = "";
			System.out.println("Staff List");
			System.out.printf("StaffId\t\tName\tGender\tTitle\n");
			// to consume the header row of csv
			String headerLine = "";
			headerLine = br.readLine();
			// keeps instanciating staff object until no more rows
			while((line = br.readLine()) != null) {			
				// split a line of string into an array
				// [0] is id, [1] is name etc...
				String[] values = line.split(",");
				
				String id = values[0];
				String name = values[1];
				String title = values[2];
				String gender = values[3];
				System.out.printf("%s\t\t%s\t%s\t%s\n", id, name, gender, title);
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
		}
	
	public void addStaff(int staffId, String name, String gender, String title) {
		String outputText = staffId + "," + name + "," + gender + "," + title;
		// read file
		File file1 = new File("staffList.txt");
		
		// initialise writer object, append new row using printwriter
		FileWriter fw = null;
		try {
			fw = new FileWriter(file1,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(outputText);
		pw.close();
	}

	public int returnNextAvailStaffId(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			//to store a line
			String line = "";
			String line2 = "";
			
			while((line = br.readLine()) != null) {
				//// test printing the file
				// System.out.println(line);
				String[] values = line.split(",");	
//				System.out.println(line);
				line2 = line;
			}
			
			String[] lastrow = line2.split(",");
			int a = Integer.parseInt(lastrow[0]);
			return a+1;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// catch IO exception for br.readline()
			e.printStackTrace();
		}
		return 0;
	}
	
	public void removeStaff(String staffId) {
		
		String tempFile = "temp2.txt";
		
		File oldFile = new File("StaffList.txt");
		File newFile = new File(tempFile);
		
		String currentline;
		String data[];
		
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader("StaffList.txt");
			BufferedReader br = new BufferedReader(fr);
			
			// keep reading next row until data[0] matches
			while((currentline = br.readLine())!= null) {
				data = currentline.split(",");
				if(!(data[0].equalsIgnoreCase(staffId))) {
					pw.println(currentline);
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
		
			// in order search for record and delete
			// use a WRITER write to temp txt
			// copy the temp.txt content into the staffList
			
		  PrintWriter writer2 = null;
			try {
				writer2 = new PrintWriter(oldFile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			writer2.print("");
			writer2.close();
			
		  FileReader fin = new FileReader("temp2.txt");  
		  FileWriter fout = new FileWriter("staffList.txt", true);  
		  int c;  
		  while ((c = fin.read()) != -1) {  
		   fout.write(c);  
		  }  
//		  System.out.println("Copy finish...");  
		  fin.close();  
		  fout.close();  
		  
		  PrintWriter writer = null;
			try {
				writer = new PrintWriter(tempFile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			writer.print("");
			writer.close();
			}
			catch(Exception e) {}
	}
	
}