package group6.dto;

import java.sql.Time;

public class CourtDTO {

    private Long courtId;
    private String location;
    private Time startTime;
    private Time endTime;
    private float price;
    private String adminId;
    private String managerId;

    public CourtDTO() {
    }

    public CourtDTO(Long courtId, String location, Time startTime, Time endTime, float price, String adminId, String managerId) {
        this.courtId = courtId;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.adminId = adminId;
        this.managerId = managerId;
    }
    public CourtDTO( String location, Time startTime, Time endTime, float price, String adminId, String managerId) {
    	this.location = location;
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.price = price;
    	this.adminId = adminId;
    	this.managerId = managerId;
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

    public Time existingManager() {
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

	public Time getStartTime() {
		return startTime;
	}
    
}
