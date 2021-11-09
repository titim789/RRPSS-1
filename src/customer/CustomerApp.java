package customer;

public class CustomerApp {
	
	public static void main(String[] args) {
		CustomerMgr customermgr = new CustomerMgr();
		// System.out.println(customermgr.isCustomerExist(20));
		customermgr.init();
		
		// customermgr.save();
	}
}