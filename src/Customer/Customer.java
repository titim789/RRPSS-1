package Customer;

public class Customer {
	private int customerId;
	private String name;
	private String phone;
	private boolean member;
	
	public Customer() {}
	
	public Customer(int customerId, String name, String phone, boolean member) {
		// TODO - implement Staff.Staff
		this.customerId = customerId;
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

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
