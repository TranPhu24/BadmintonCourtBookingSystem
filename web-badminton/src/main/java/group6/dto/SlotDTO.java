package group6.dto;

import java.sql.Time;
import java.util.Set;

public class SlotDTO {
    private Long slotId;
    private Time startTime;
    private Time endTime;
    private String staffId;
    private String managerId;

    public SlotDTO() {
    }

    public SlotDTO(Long slotId, Time startTime, Time endTime, String staff, String manager) {
        this.slotId = slotId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.staffId = staff;
        this.managerId = manager;
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

    public String getStaff() {
        return staffId;
    }

    public void setStaff(String staff) {
        this.staffId = staff;
    }

    
}
