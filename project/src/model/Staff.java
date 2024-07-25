package model;

public class Staff {
	private String StaffID,staffNameString;

	public Staff(String staffId, String staffNameString) {
		super();
		StaffID = staffId;
		this.staffNameString = staffNameString;
	}

	public Staff() {
		super();
	}

	@Override
	public String toString() {
		return "\nStaffId=" + StaffID + "\nstaffNameString=" + staffNameString;
	}

	public String getStaffId() {
		return StaffID;
	}

	public void setStaffId(String staffId) {
		StaffID = staffId;
	}

	public String getStaffNameString() {
		return staffNameString;
	}

	public void setStaffNameString(String staffNameString) {
		this.staffNameString = staffNameString;
	}
	
}
