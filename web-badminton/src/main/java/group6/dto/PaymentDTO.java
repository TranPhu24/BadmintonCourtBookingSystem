package group6.dto;

import java.util.Set;

public class PaymentDTO {
    private Long paymentId;
    private float amount;
    private String status;
    private String customerId;


    public PaymentDTO() {
    }

    public PaymentDTO(Long paymentId, float amount, String status, String customer) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.customerId = customer;
    }

    public Long getPaymentId() {
        return paymentId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customer) {
        this.customerId = customer;
    }
}
