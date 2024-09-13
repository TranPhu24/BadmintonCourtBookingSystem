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

    @Column(name = "bookingDay")
    private String bookingDay;
    
    @Column(name = "bookingDate")
    private Date bookingDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "courtId")
    private Court court;
    
    @ManyToOne
    @JoinColumn(name = "slotId")
    private Slot slot;
    
    @ManyToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

    
    
    
	public Booking() {
		super();
	}
	public Booking(String bookingType, String bookingDay, Date bookingDate, User user,
			Court court, Slot slot, Payment payment) {
		super();
		this.bookingType = bookingType;
		this.bookingDay = bookingDay;
		this.bookingDate = bookingDate;
		this.user = user;
		this.court = court;
		this.slot = slot;
		this.payment = payment;
	}
	public Booking(Long bookingId, String bookingType, String bookingDay, Date bookingDate, User user,
			Court court, Slot slot, Payment payment) {
		super();
		this.bookingId = bookingId;
		this.bookingType = bookingType;
		this.bookingDay = bookingDay;
		this.bookingDate = bookingDate;
		this.user = user;
		this.court = court;
		this.slot = slot;
		this.payment = payment;
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

	public String getBookingDay() {
		return bookingDay;
	}

	public void setBookingDay(String bookingDay) {
		this.bookingDay = bookingDay;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	

    
}

