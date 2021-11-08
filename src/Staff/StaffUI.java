package Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffUI {
	
	public int displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to \n"
				+ "1 - Display Staff\n"
				+ "2 - Add Staff\n"
				+ "3 - Remove Staff\n"
				+ "4 - Back to main menu\n"
				+ "5 - Quit");
		int option = sc.nextInt();
		return option;
	}
	
	public String getStaffName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff Name");
		String name = sc.next();
		return name;
	}
	
	public String getStaffGender() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter Staff Gender (m/f)");
		String gender = sc2.next();
		return gender;
	}
	
	public String getStaffTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff Title");
		String title = sc.next();
		return title;
	}
	
	public int getRemoveId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff id to remove");
		int id = sc.nextInt();
		return id;
	}
	
}
