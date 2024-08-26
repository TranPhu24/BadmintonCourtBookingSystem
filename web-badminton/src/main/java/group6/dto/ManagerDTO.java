package group6.dto;

import java.util.Set;

public class ManagerDTO {
    private String managerId;
    private String managerName;
    private String userId;
    public ManagerDTO() {
    }

    public ManagerDTO(String managerId, String managerName, String user) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.userId = user;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}
