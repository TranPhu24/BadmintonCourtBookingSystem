package group6.service;

import java.util.List;

import group6.pojo.Payment;

public interface IPaymentService {
	List<Payment> findAll();
    
    void save(Payment payment);
    
    void delete(String paymentID);
    
    Payment findById(String paymentID);
    
    void update(Payment payment);
}
