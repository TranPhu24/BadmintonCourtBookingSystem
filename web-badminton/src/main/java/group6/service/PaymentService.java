package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.PaymentDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;
import group6.pojo.Customer;
import group6.pojo.Payment;
import group6.pojo.User;
import group6.repository.CourtRepository;
import group6.repository.CustomerRepository;
import group6.repository.PaymentRepository;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    public PaymentService(PaymentRepository paymentRepository,CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Payment createPayment(PaymentDTO paymentDTO) throws DataNotFoundException {
    	 Customer existingCustomers = customerRepository.findById(paymentDTO.getCustomerId())
                 .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + paymentDTO.getCustomerId()));
    	Payment newPayment = new Payment(
            paymentDTO.getPaymentId(),
            paymentDTO.getAmount(),
            paymentDTO.getStatus(),
            existingCustomers
        );
        
        return paymentRepository.save(newPayment);
    }

    @Override
    public Payment updatePayment(Long id, PaymentDTO paymentDTO) throws DataNotFoundException {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Payment not found with id " + id));
        Customer existingCustomers = customerRepository.findById(paymentDTO.getCustomerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + paymentDTO.getCustomerId()));
   	
        existingPayment.setAmount(paymentDTO.getAmount());
        existingPayment.setStatus(paymentDTO.getStatus());
        existingPayment.setCustomer(existingCustomers);
        
        return paymentRepository.save(existingPayment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
    @Override
    public Payment getPayment(Long id) throws DataNotFoundException {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Payment not found with id " + id));
    }
}
