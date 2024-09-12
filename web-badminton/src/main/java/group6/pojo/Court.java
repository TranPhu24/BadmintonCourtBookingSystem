package group6.pojo;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private float price;

    @OneToMany(mappedBy = "court",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Booking> bookings= new HashSet<Booking>();

    @ManyToOne
    @JoinColumn(name = "AdminId")
    private Admin admin;
    
    @ManyToOne
    @JoinColumn(name = "ManagerId")
    private Manager manager;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "SLOT_COURT",
        joinColumns = @JoinColumn(name = "court_id"),
        inverseJoinColumns = @JoinColumn(name = "slot_id")
    )
    private Set<Slot> slots = new HashSet<>();
    
	public Court() {
		super();
	}


	public Court(String location, Time startTime, Time endTime, float price,Admin admin, Manager manager) {
		super();
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.manager = manager;

		this.admin = admin;
	}


	public Court(Long courtId, String location, Time startTime, Time endTime, float price,
			Admin admin, Manager manager) {
		super();
		this.courtId = courtId;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.admin = admin;
		this.manager = manager;
	}


	public Long getCourtId() {
		return courtId;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void setCourtId(Long courtId) {
		this.courtId = courtId;
	}

	public Set<Slot> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slot> slots) {
        this.slots = slots;
    }

    
}

