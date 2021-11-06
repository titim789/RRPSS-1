package Staff;

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
	
	public String getRemoveId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff id to remove");
		String id = sc.next();
		return id;
	}
	
	public void displayMenu2() {
		// load staff list function
		StaffMgr staffmgr = new StaffMgr();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do you want to \n"
				+ "1 - Display Staff\n"
				+ "2 - Add Staff\n"
				+ "3 - Remove Staff\n"
				+ "4 - Back to main menu\n"
				+ "5 - Quit");
		int option = sc.nextInt();
		
		while(option != 5) {
			switch(option) {
			// Display staff
			case 1:
				staffmgr.displayStaffList();
				break;
			
			// Add staff
			case 2:
//				System.out.println("Enter Staff Id");
//				int staffId = sc.nextInt();
				
				// return last id
				int staffId = staffmgr.returnNextAvailStaffId("StaffList.txt");
				
				System.out.println("Enter Staff Name");
				String name = sc.next();
				
				System.out.println("Enter Staff Gender (m / f)");
				String gender = sc.next();
				
				System.out.println("Enter Staff Title");
				String title = sc.next();
				
				staffmgr.addStaff(staffId, name, gender, title);
				System.out.println("Staff List Updated..");
				staffmgr.displayStaffList();
				break;
			
			
			// remove staff
			case 3:
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter Staff ID to remove:");
				String staffId1 = sc.next();
				staffmgr.removeStaff(staffId1);
				
				System.out.println("Staff List Updated..");
				staffmgr.displayStaffList();
				break;
			
			case 4:
				// insert function to go back one level
				break;
				
			// quit
			case 5:
				option = 5;
				System.out.println("Program Terminated");
				break;
		}
		System.out.println("Do you want to \n"
					+ "1 - Display Staff\n"
					+ "2 - Add Staff\n"
					+ "3 - Remove Staff\n"
					+ "4 - Back to main menu\n"
					+ "5 - Quit");
		option = sc.nextInt();
		}
		
	
	
	
}}
