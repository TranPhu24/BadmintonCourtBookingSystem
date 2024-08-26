package group6.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

public class BookingDTO {
    private Long bookingId;
    private String bookingType;
    private Date bookingDate;
    private Time bookingTime;
    private String customerId;
    private String managerId;
    
	public BookingDTO() {
	}
	public BookingDTO(Long bookingId, String bookingType, Date bookingDate, Time bookingTime, String customerId,
			String managerId) {
		super();
		this.bookingId = bookingId;
		this.bookingType = bookingType;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.customerId = customerId;
		this.managerId = managerId;
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingType() {
		return bookingType;
	}
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Time getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	

    
}
