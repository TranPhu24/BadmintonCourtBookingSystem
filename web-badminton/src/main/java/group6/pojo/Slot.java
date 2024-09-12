package group6.pojo;

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
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SLOT")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SlotID")
    private Long slotId;


    @Column(name = "startTime")
    private Time startTime;

    @Column(name = "endTime")
    private Time endTime;
    
    @ManyToOne
    @JoinColumn(name = "StaffId")
    private Staff staff;
    
    @ManyToOne
    @JoinColumn(name = "ManagerId")
    private Manager manager;
    
    @OneToMany(mappedBy = "court",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Booking> bookings= new HashSet<Booking>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "SLOT_COURT",
        joinColumns = @JoinColumn(name = "slot_id"),
        inverseJoinColumns = @JoinColumn(name = "court_id")
    )
    private Set<Court> courts=new HashSet<>();

    public Slot() {
        super();
    }

    public Slot(Time startTime, Time endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }
    

    public Slot(Time startTime, Time endTime, Manager manager, Staff staff) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.staff = staff;
		this.manager = manager;
	}

	public Staff getStaff() {
		return staff;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Set<Court> getCourts() {
		return courts;
	}

	public void setCourts(Set<Court> courts) {
		this.courts = courts;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	

  
}
