package group6.repository;

import java.util.List;

import group6.pojo.Payment;

public interface IPaymentRepository {
	List<Payment> findAll();
    
    void save(Payment payment);
    
    void delete(String paymentID);
    
    Payment findById(String paymentID);
    
    void update(Payment payment);
}
