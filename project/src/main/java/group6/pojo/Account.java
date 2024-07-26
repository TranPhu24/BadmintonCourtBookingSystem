package group6.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	@Id
	@Column(name = "id")
	private String AccountID;
	@Column(name="userName")
	private String UserName;
	@Column(name="passWord")
	private String password;
	@Column(name = "role")
	private String role;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;
	@ManyToOne
    @JoinColumn(name = "ManagerID")
    private Manager manager;
	@ManyToOne
	@JoinColumn(name = "AdminId")
	private Admin admin;
	@ManyToOne
    @JoinColumn(name = "StaffId")
    private Staff staff;
	
	public Account() {
		super();
	}

	public Account(String AccountID,String userName, String password, String role) {
		super();
		this.AccountID=AccountID;
		UserName = userName;
		this.password = password;
		this.role = role;
	}

	public String getAccountId() {
		return AccountID;
	}

	public void setAccountId(String accountId) {
		AccountID = accountId;
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
	
	
	
}
