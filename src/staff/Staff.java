package Staff;

public class Staff {
	private int staffId;
	private String staffName;
	private String gender;
	private String jobTitle;

	public Staff(int StaffId, String staffName, String gender, String jobTitle) {
		// TODO - implement Staff.Staff
		this.staffName = staffName;
		this.gender = gender;
		this.staffId = StaffId;
		this.jobTitle = jobTitle;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int StaffId) {
		this.staffId = StaffId;
	}

	public String getJobTitle() {
		// TODO - implement Staff.setStaffTitle
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		// TODO - implement Staff.setJobTitle
		this.jobTitle = jobTitle;
	}
}