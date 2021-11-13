package order;
import java.util.Scanner;

public class OrderUI {
	/**
	 * The UI for the order class
	 */
	public OrderUI() {
	}
	
	/**
	 * A method to ask the user for an input for an order ID
	 * @return The order ID
	 */
	public int getOrderId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter order ID: ");
		int orderId = sc.nextInt();
		return orderId;
	}
	

}
