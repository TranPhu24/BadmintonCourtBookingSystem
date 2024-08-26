package group6.dto;

import java.util.Set;

public class CourtDTO {
    private Long courtId;
    private String location;
    private String operatingHours;
    private double price;
    private Long paymentId;
    private String managerId;
    
    public CourtDTO() {}
    
	public CourtDTO(Long courtId, String location, String operatingHours, double price,Long paymentId, String managerId) {
		super();
		this.courtId = courtId;
		this.location = location;
		this.operatingHours = operatingHours;
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
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
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

    
}
