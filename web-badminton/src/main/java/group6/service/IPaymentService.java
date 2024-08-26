package group6.service;

import java.util.List;

import group6.dto.PaymentDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Payment;

public interface IPaymentService {
    Payment createPayment(PaymentDTO paymentDTO);
    Payment updatePayment(Long id, PaymentDTO paymentDTO) throws DataNotFoundException;
    List<Payment> getAllPayments();
    Payment getPayment(Long id) throws DataNotFoundException;
}
