package group6.pojo;


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

    @Column(name = "operatinghours")
    private String operatingHours; 

    @Column(name = "price")
    private String price;
    
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

    public Court(String location, String operatingHours, String price) {
        super();
        this.location = location;
        this.operatingHours = operatingHours; 
        this.price = price;
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

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
