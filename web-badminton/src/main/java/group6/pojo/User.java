package group6.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "UserId")
    private String userId;
	
	@Column(name="userName")
	private String UserName;
	@Column(name="passWord")
	private String password;
	@Column(name = "role")
	private String role;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer customer;
    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Manager manager;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Staff staff;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Booking> bookings= new HashSet<Booking>();
	
	@ManyToOne
	@JoinColumn(name = "AdminId")
	private Admin admin;
	
	
	public User() {
		super();
	}

	public User(String UserID,String userName, String password, String role) {
		super();
		this.userId=UserID;
		UserName = userName;
		this.password = password;
		this.role = role;
	}



	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getUserID() {
		return userId;
	}

	public void setUserID(String userId) {
		this.userId = userId;
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
