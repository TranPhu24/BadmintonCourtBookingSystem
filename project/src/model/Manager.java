package model;

public class Manager {
	private String ManagerID, ManagerName;

	public Manager(String managerId, String managerName) {
		super();
		ManagerID = managerId;
		ManagerName = managerName;
	}

	public Manager() {
		super();
	}

	@Override
	public String toString() {
		return "\nManagerId=" + ManagerID + "\nManagerName=" + ManagerName + "]";
	}

	public String getManagerId() {
		return ManagerID;
	}

	public void setManagerId(String managerId) {
		ManagerID = managerId;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}
	
	
}
