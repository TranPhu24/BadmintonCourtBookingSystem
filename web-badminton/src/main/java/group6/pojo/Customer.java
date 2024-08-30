package group6.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "CustomerID")
    private String customerId;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "timeplay")
    private float timeplay;
    
    @OneToOne
    @JoinColumn(name = "UserId", unique = true)
    private User user;
    
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Booking> bookings= new HashSet<Booking>();
    

    
    
    public Customer() {
    	super();
    }

    public Customer(String customerId, String customerName, String email, String phone,float timeplay) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.timeplay = timeplay;
    }
   
    public Customer(String customerId, String customerName, String email, String phone,float timeplay, User user) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
        this.timeplay = timeplay;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	public float getTimeplay() {
		return timeplay;
	}

	public void setTimeplay(float timeplay) {
		this.timeplay = timeplay;
	}
    




	

}
