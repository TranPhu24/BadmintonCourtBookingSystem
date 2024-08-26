package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.Payment;

public interface IPaymentRepository {
	List<Payment> findAll();
    
    Payment save(Payment payment);
    
    void delete(Long paymentID);
    
    Optional<Payment> findById(Long paymentID);
    
    Payment update(Payment payment);
}
