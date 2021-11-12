package staff;

import java.io.Serializable;


/**
 * This class is for various attributes and methods of a staff member object.
 * @author Marcus
 * @version 1.0
 */

public class Staff implements Serializable{
	/**
	 * initialise staff Id integer
	*/
	private int staffId;
	
	/**
	 * initialise staff name string
	*/
	private String staffName;
	
	/**
	 * initialise staff gender string
	 */
	private String gender;

	/**
	 * initialise staff job title string
	*/
	private String jobTitle;

	/**
	 * Creating a new staff object
	 * 
	 * @param StaffId pass in a staff ID (int) of new staff object
	 * @param staffName pass in a staff name (string) of new staff object
	 * @param gender pass in a staff ID (string) of new staff object
	 * @param jobTitle pass in a job title (string) of new staff object
	 */
	public Staff(int StaffId, String staffName, String gender, String jobTitle) {
		// TODO - implement Staff.Staff
		this.staffName = staffName;
		this.gender = gender;
		this.staffId = StaffId;
		this.jobTitle = jobTitle;
	}

	
	/** 
	 * returns name of a staff object
	 * @return String returns the name of this particular staff object
	 */
	public String getStaffName() {
		return this.staffName;
	}

	
	/** 
	 * set a new name for a staff object
	 * @param staffName pass in the name(string) for this particular staff object
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	
	/** 
	 * returns gender of a staff object
	 * @return String returns the gender(string) of this particular staff object
	 */
	public String getGender() {
		return this.gender;
	}

	
	/** 
	 * set the gender of a staff object
	 * @param gender pass in the name(string) for this particular staff object
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	/** 
	 * returns ID of a staff object
	 * @return int returns the staff ID of this particular staff object
	 */
	public int getStaffId() {
		return this.staffId;
	}

	
	/** 
	 * set ID of a staff object
	 * @param StaffId pass in the ID (int) for this particular staff object
	 */
	public void setStaffId(int StaffId) {
		this.staffId = StaffId;
	}

	
	/** 
	 * returns job title of a staff object
	 * @return String returns the job title of this particular staff object
	 */
	public String getJobTitle() {
		// TODO - implement Staff.setStaffTitle
		return this.jobTitle;
	}

	
	/** 
	 * set job title of a staff object
	 * @param jobTitle pass in the job title (string) for this particular staff object
	 */
	public void setJobTitle(String jobTitle) {
		// TODO - implement Staff.setJobTitle
		this.jobTitle = jobTitle;
	}
}