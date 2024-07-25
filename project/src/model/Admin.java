package model;

public class Admin {
	private String AdminID, adminName;

	public Admin() {
		super();
	}

	public Admin(String adminId, String adminName) {
		super();
		AdminID = adminId;
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "\nAdminId=" + AdminID + "\nadminName=" + adminName;
	}

	public String getAdminId() {
		return AdminID;
	}

	public void setAdminId(String adminId) {
		AdminID = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
}
