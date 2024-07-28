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
	private Set<User> users=new HashSet<User>();
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Court> Court=new HashSet<Court>();
	public Admin() {
		super();
	}

	public Admin(String adminId, String adminName) {
		super();
		AdminID = adminId;
		this.adminName = adminName;
	}
	
	public String getAdminID() {
		return AdminID;
	}

	public void setAdminID(String adminID) {
		AdminID = adminID;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Court> getCourt() {
		return Court;
	}

	public void setCourt(Set<Court> court) {
		Court = court;
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
