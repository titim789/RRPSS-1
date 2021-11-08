package Customer;

import java.util.Scanner;

public class CustomerUI {

	// empty constructor
	public CustomerUI() {}

    public int mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to \n"
        + "1 - Display Customer List\n"
        + "2 - Add Customer\n"
        + "3 - Remove Customer\n"
        + "4 - Back to main menu\n"
        + "5 - Quit");
        
        int option = sc.nextInt();
        return option;
    }

    public String getCustomerName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Name");
		String name = sc.next();
		return name;
	}
	
	public String getCustomerPhone() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter Customer Phone");
		String phone = sc2.next();
		return phone;
	}
	
	public String getCustomerMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("is customer member y/n");
		String member = sc.next();
		return member;
	}
	
	public int getRemoveId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer id to remove");
		int id = sc.nextInt();
		return id;
	}
    
    
}
