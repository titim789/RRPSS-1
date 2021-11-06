package Customer;

public class CustomerApp {
	
	public static void main(String[] args) {
		CustomerMgr run = new CustomerMgr();
		ReadCustomerList readList = new ReadCustomerList();
		run.displayCustomerList();
//		readList.readCustomerFromFile("customerList.txt");
		run.addCustomer();
//		run.removeCustomer();
	}
}