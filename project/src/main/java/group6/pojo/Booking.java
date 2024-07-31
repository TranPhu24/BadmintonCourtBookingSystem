package group6.pojo;

import java.sql.Date;
import java.sql.Time;
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
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BookingID")
    private Long bookingId; 

    @Column(name = "bookingType")
    private String bookingType;

    @Column(name = "bookingDate")
    private Date bookingDate;

    @Column(name = "bookingTime")
    private Time bookingTime;
    
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
    
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Court> courts = new HashSet<Court>();
   	
    public Booking() {
        super();
    }

    public Booking(Long bookingId,String bookingType, Date bookingDate, Time bookingTime) {
        super();
        this.bookingType = bookingType;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    
    

    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Court> getCourts() {
		return courts;
	}

	public void setCourts(Set<Court> courts) {
		this.courts = courts;
	}

	public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

   

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }
}
