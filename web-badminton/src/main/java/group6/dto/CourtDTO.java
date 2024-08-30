package group6.dto;

import java.sql.Time;
import java.util.Set;

public class CourtDTO {
    private Long courtId;
    private String location;
    private Time startTime;
    private Time endTime;
    private double price;
    private Long paymentId;
    private String managerId;
    
    public CourtDTO() {}
    
	public CourtDTO(Long courtId, String location, Time startTime, Time endTime, double price,Long paymentId, String managerId) {
		super();
		this.courtId = courtId;
		this.location = location;
		this.startTime = startTime;
        this.endTime = endTime;
		this.price = price;
		this.paymentId = paymentId;
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
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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
