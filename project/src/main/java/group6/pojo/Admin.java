package group6.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin {
	@Id
	@Column(name="AdminID")
	private String AdminID;
	@Column(name = "adminName")
	private String adminName;

	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Account> accounts=new HashSet<Account>();
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
