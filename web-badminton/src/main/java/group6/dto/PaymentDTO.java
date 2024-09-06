package group6.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentDTO {

    private Long paymentId;
    private float amount;
    private LocalDate paymentDate;
    private LocalTime paymentTime;
    private String status;
    private String customerId;
    private Long bookingId; 

    public Long getPaymentId() {
        return paymentId;
    }
    
    

    public PaymentDTO() {
		super();
	}



	public PaymentDTO(float amount, LocalDate paymentDate, LocalTime paymentTime, String status, String customerId) {
		super();
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.status = status;
		this.customerId = customerId;
	}



	public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}
