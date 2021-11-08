package Customer;

public class CustomerApp {
	
	public static void main(String[] args) {
		CustomerMgr customermgr = new CustomerMgr();
		
		System.out.println("Testing for getCustomerObj()");
		// pass in customer id and return customer object
		Customer c =  customermgr.getCustomerObj(5);
		System.out.println(c.getName());
		System.out.println("isMember?" + c.isMember());

		
		// customermgr.init();



	}
}