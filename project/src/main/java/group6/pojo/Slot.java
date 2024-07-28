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

    public Slot(Long slotId,Time startTime, Time endTime) {
        super();
        this.slotId = slotId;
        this.startTime = startTime;
        this.endTime = endTime;
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

  
}
