package Customer;

public class Customer {
	private int customer_id;
	private String name;
	private String phone;
	private boolean member;
	
	public Customer() {};
	
	public Customer(int customer_id, String name, String phone, boolean member) {
		// TODO - implement Staff.Staff
		this.customer_id = customer_id;
		this.name = name;
		this.phone = phone;
		this.member = member;
		throw new UnsupportedOperationException();
	}
	
	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCustomer_id() {
		return this.customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

}
