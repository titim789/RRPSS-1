package staff;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the UI for capturing user input for staff details and passing it to the StaffMgr class
 * @author Ng Li Wang
 */
public class StaffUI {
	
	/** 
	 * Gets the user input for staff name and passes it to the StaffMgr class
	 * @return String returns new staff object's name (string) based on user input
	 */
	public String getStaffName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff Name");
		String name = sc.next();
		name += sc.nextLine();
		return name;
	}
	
	
	/** 
	 * Gets gender of new staff object based on user input to pass in staffmgr class
	 * @return String returns new staff object's gender (string) based on user input
	 */
	public String getStaffGender() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter Staff Gender (m/f)");
		String gender = sc2.next();
		return gender;
	}
	
	
	/** 
	 * Gets staff title from user input of new staff object to pass into staffMgr class
	 * 
	 * @return String returns new staff object's title (string) based on user input
	 */
	public String getStaffTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff Title");
		String title = sc.next();
		return title;
	}
	
	
	/**
	 * Gets staff ID to be removed from the list of staff
	 * 
	 * @return int returns staff ID (int) to be removed based on user input
	 */
	public int getRemoveId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff id to remove");
		int id = sc.nextInt();
		return id;
	}
	
}
