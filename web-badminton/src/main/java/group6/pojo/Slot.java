package group6.pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Table(name = "SLOT")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SlotID")
    private Long slotId;


    @Column(name = "startTime")
    private LocalDateTime startTime;
    
    @Column(name = "endTime")
    private LocalDateTime endTime;
    
    @ManyToOne
    @JoinColumn(name = "StaffId")
    private Staff staff;
    
    @ManyToOne
    @JoinColumn(name = "ManagerId")
    private Manager manager;
    
    @ManyToMany
    @JoinTable(
        name = "SLOT_COURT",
        joinColumns = @JoinColumn(name = "slot_id"),
        inverseJoinColumns = @JoinColumn(name = "court_id")
    )
    private Set<Court> courts;

    public Slot() {
        super();
    }

    public Slot(LocalDateTime startTime, LocalDateTime endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }
    

    public Slot(LocalDateTime startTime, LocalDateTime endTime, Manager manager, Staff staff) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.staff = staff;
		this.manager = manager;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Court> getCourts() {
		return courts;
	}

	public void setCourts(Set<Court> courts) {
		this.courts = courts;
	}

	public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

  
}
