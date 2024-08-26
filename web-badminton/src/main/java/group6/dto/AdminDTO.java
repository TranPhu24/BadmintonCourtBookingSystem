package group6.dto;

import java.util.Set;

public class AdminDTO {
    private String adminID;
    private String adminName;

    public AdminDTO() {
    }

	public AdminDTO(String adminID, String adminName) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

    
}
