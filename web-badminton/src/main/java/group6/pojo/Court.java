package group6.pojo;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne; 
import javax.persistence.Table;

@Entity
@Table(name = "COURT")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CourtID")
    private Long courtId;

    @Column(name = "location")
    private String location;

    @Column(name = "startTime")
    private Time startTime;

    @Column(name = "endTime")
    private Time endTime;

    @Column(name = "price")
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "AdminId")
    private Admin admin;
    
    @ManyToOne
    @JoinColumn(name = "BookingId")
    private Booking booking;
    
    @ManyToOne
    @JoinColumn(name = "PaymentId")
    private Payment payment;
    
    @ManyToOne
    @JoinColumn(name = "ManagerId")
    private Manager manager;
    
    @ManyToMany(mappedBy = "courts")
    private Set<Slot> slots;
    
    public Court() {
        super();
    }

    public Court(String location, Time startTime, Time endTime, double price) {
        super();
        this.location = location;
        this.startTime = startTime;
		this.endTime = endTime;
        this.price = price;
    }

    
    
    public Court(String location,Time startTime, Time endTime, double price,Admin admin ,Booking booking,Manager manager ,Payment payment
			) {
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.booking = booking;
		this.payment = payment;
		this.manager = manager;
		this.admin =admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	public void setSlots(Set<Slot> slots) {
		this.slots = slots;
	}

	public Long getCourtId() {
        return courtId; 
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    

    public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
