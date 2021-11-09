package customer;

public class CustomerApp {
	
	public static void main(String[] args) {
		CustomerMgr customermgr = new CustomerMgr();
		// System.out.println(customermgr.isCustomerExist(20));
		// sysout(customermgr.isCustomerExist(20));
		System.out.println(customermgr.getCustomerPhone(10));
		System.out.println(customermgr.getCustomerName(10));
		customermgr.init();
		
		// customermgr.save();
	}
}