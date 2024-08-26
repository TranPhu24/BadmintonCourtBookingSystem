package group6.service;

import group6.dto.PaymentDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Customer;
import group6.pojo.Payment;
import group6.repository.CustomerRepository;
import group6.repository.PaymentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    private PaymentService paymentService;
    private PaymentRepository paymentRepository;
    private CustomerRepository customerRepository;
    private Payment payment;
    private PaymentDTO paymentDTO;
    private Customer customer;

    @BeforeEach
    void setUp() {
        paymentRepository = Mockito.mock(PaymentRepository.class);
        customerRepository = Mockito.mock(CustomerRepository.class);
        paymentService = new PaymentService(paymentRepository,customerRepository);

        customer = new Customer();
        customer.setCustomerId("1");
        customer.setCustomerName("Customer 1");

        payment = new Payment();
        payment.setPaymentId(1L);
        payment.setAmount(100.0f);
        payment.setStatus("Paid");
        payment.setCustomer(customer);

        paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(1L);
        paymentDTO.setAmount(100.0f);
        paymentDTO.setStatus("Paid");
        paymentDTO.setCustomerId("1");
    }

    @Test
    void createPayment() throws DataNotFoundException {
        when(customerRepository.findById("1")).thenReturn(Optional.of(customer));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment createdPayment = paymentService.createPayment(paymentDTO);

        assertNotNull(createdPayment);
        assertEquals(payment, createdPayment);

        verify(customerRepository, times(1)).findById("1");
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void createPayment_customerNotFound() {
        when(customerRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> paymentService.createPayment(paymentDTO));

        verify(customerRepository, times(1)).findById("1");
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    void updatePayment() throws DataNotFoundException {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(customerRepository.findById("1")).thenReturn(Optional.of(customer));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment updatedPayment = paymentService.updatePayment(1L, paymentDTO);

        assertNotNull(updatedPayment);
        assertEquals(payment, updatedPayment);

        verify(paymentRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).findById("1");
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void updatePayment_notFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> paymentService.updatePayment(1L, paymentDTO));

        verify(paymentRepository, times(1)).findById(1L);
        verify(customerRepository, never()).findById(anyString());
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    void getAllPayments() {
        when(paymentRepository.findAll()).thenReturn(Arrays.asList(payment));

        List<Payment> payments = paymentService.getAllPayments();

        assertNotNull(payments);
        assertEquals(1, payments.size());
        assertEquals(payment, payments.get(0));

        verify(paymentRepository, times(1)).findAll();
    }

    @Test
    void getPayment() throws DataNotFoundException {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        Payment retrievedPayment = paymentService.getPayment(1L);

        assertNotNull(retrievedPayment);
        assertEquals(payment, retrievedPayment);

        verify(paymentRepository, times(1)).findById(1L);
    }

    @Test
    void getPayment_notFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> paymentService.getPayment(1L));

        verify(paymentRepository, times(1)).findById(1L);
    }
}
