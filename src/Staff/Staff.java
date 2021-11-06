package Staff;

public class Staff {
	private String staff_name;
	private String gender;
	private int staff_id;
	private String job_title;
	
	public Staff() {};
	
	public Staff(String staff_name, String gender, int staff_id, String job_title) {
		// TODO - implement Staff.Staff
		this.staff_name = staff_name;
		this.gender = gender;
		this.staff_id = staff_id;
		this.job_title = job_title;
		throw new UnsupportedOperationException();
	}

	public String getStaff_name() {
		return this.staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStaff_id() {
		return this.staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getJob_title() {
		// TODO - implement Staff.getJob_title
		return this.job_title;
	}

	public void setJob_title(String job_title) {
		// TODO - implement Staff.setJob_title
		this.job_title = job_title;
	}

}