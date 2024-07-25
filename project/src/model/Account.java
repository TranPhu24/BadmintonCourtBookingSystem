package model;

public class Account {
	private String AccountID, UserName, password, role;

	public Account() {
		super();
	}

	public Account(String accountId, String userName, String password, String role) {
		AccountID = accountId;
		UserName = userName;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "\nAccountID=" + AccountID + ", UserName=" + UserName + ", password=" + password + ", role="
				+ role;
	}

	public String getAccountId() {
		return AccountID;
	}

	public void setAccountId(String accountId) {
		this.AccountID = accountId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
    public Boolean login(String username, String password) {
		return null;
    }

    public Boolean logout() {
		return null;
    }


}
