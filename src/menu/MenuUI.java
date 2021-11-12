package menu;

import java.util.Scanner;

/**
 * UI for MenuMgr
 * @author titus
 * @author Wei Xiang
 *
 */
public class MenuUI {
	
	/**
	 * constructor for menu UI class
	 */
	public MenuUI() {}
	
	/**
	 * Displays to the user the choices he/she has and returns the user input to the MenuMgr
	 * @return returns the user's choice
	 */
	public int getMenuTypeOption() {
		System.out.println("Choose Menu Type:\n"
				+ "1)\tMenu\n"
				+ "2)\tPromotions\n"
				+ "3)\tExit");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return choice;
	}

}
