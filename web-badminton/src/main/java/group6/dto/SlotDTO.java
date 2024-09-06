package group6.dto;

import java.sql.Time;
import java.util.Set;

public class SlotDTO {
    private Long slotId;
    private Time startTime;
    private Time endTime;
    private String managerId; 
    private String staffId;  

    public SlotDTO() {
        super();
    }

    public SlotDTO(Long slotId, Time startTime, Time endTime, String managerId, String staffId) {
        super();
        this.slotId = slotId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.managerId = managerId;
        this.staffId = staffId;
    }
    public SlotDTO(Time startTime, Time endTime, String managerId, String staffId) {
    	super();
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.managerId = managerId;
    	this.staffId = staffId;
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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
