package order;
import java.util.Scanner;

public class OrderUI {
	public OrderUI() {
		
	}
	
	public int getOrderId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter order ID: ");
		int orderId = sc.nextInt();
		return orderId;
	}
	

}
