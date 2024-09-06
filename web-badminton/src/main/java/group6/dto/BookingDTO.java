package group6.dto;

import java.sql.Date;
import java.sql.Time;

public class BookingDTO {
    private Long bookingId;
    private String bookingType;
    private String bookingDay;
    private Date bookingDate;
    private String customerId;  
    private Long courtId;     
    private Long slotId;      
    private Long paymentId;      

    public BookingDTO() {
    }

    public BookingDTO(Long bookingId, String bookingType, String bookingDay, Date bookingDate, String customerId, Long courtId, Long slotId, Long paymentId) {
        this.bookingId = bookingId;
        this.bookingType = bookingType;
        this.bookingDay = bookingDay;
        this.bookingDate = bookingDate;
        this.customerId = customerId;
        this.courtId = courtId;
        this.slotId = slotId;
        this.paymentId = paymentId;
    }

    public BookingDTO(String bookingType, String bookingDay, Date bookingDate, String customerId, Long courtId, Long slotId, Long paymentId) {
        this.bookingType = bookingType;
        this.bookingDay = bookingDay;
        this.bookingDate = bookingDate;
        this.customerId = customerId;
        this.courtId = courtId;
        this.slotId = slotId;
        this.paymentId = paymentId;
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

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
    
}
