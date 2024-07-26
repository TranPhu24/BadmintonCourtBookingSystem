package group6.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Time;

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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourtID")
    private Court court;

    public Slot() {
        super();
    }

    public Slot(Long slotId,Time startTime, Time endTime) {
        super();
        this.slotId = slotId;
        this.startTime = startTime;
        this.endTime = endTime;
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
