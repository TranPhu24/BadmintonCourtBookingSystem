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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        paymentService = new PaymentService(paymentRepository, customerRepository);

        customer = new Customer();
        customer.setCustomerId("1");
        customer.setCustomerName("Customer 1");

        payment = new Payment();
        payment.setPaymentId(1L);
        payment.setAmount(100.0f);
        payment.setStatus("Paid");
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentTime(LocalTime.now());
        payment.setCustomer(customer);

        paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(1L);
        paymentDTO.setAmount(100.0f);
        paymentDTO.setStatus("Paid");
        paymentDTO.setPaymentDate(LocalDate.now());
        paymentDTO.setPaymentTime(LocalTime.now());
        paymentDTO.setCustomerId("1");
    }

    @Test
    void createPayment() throws DataNotFoundException {
        when(customerRepository.findById("1")).thenReturn(Optional.of(customer));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment createdPayment = paymentService.createPayment(paymentDTO);

        assertNotNull(createdPayment);
        assertEquals(payment.getAmount(), createdPayment.getAmount());
        assertEquals(payment.getStatus(), createdPayment.getStatus());
        assertEquals(payment.getPaymentDate(), createdPayment.getPaymentDate());
        assertEquals(payment.getPaymentTime(), createdPayment.getPaymentTime());
        assertEquals(payment.getCustomer(), createdPayment.getCustomer());

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
        when(paymentRepository.update(any(Payment.class))).thenReturn(payment);

        Payment updatedPayment = paymentService.updatePayment(1L, paymentDTO);

        assertNotNull(updatedPayment);
        assertEquals(paymentDTO.getAmount(), updatedPayment.getAmount());
        assertEquals(paymentDTO.getStatus(), updatedPayment.getStatus());
        assertEquals(paymentDTO.getPaymentDate(), updatedPayment.getPaymentDate());
        assertEquals(paymentDTO.getPaymentTime(), updatedPayment.getPaymentTime());
        assertEquals(customer, updatedPayment.getCustomer());

        verify(paymentRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).findById("1");
        verify(paymentRepository, times(1)).update(any(Payment.class));
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
        assertEquals(payment.getAmount(), payments.get(0).getAmount());
        assertEquals(payment.getStatus(), payments.get(0).getStatus());
        assertEquals(payment.getPaymentDate(), payments.get(0).getPaymentDate());
        assertEquals(payment.getPaymentTime(), payments.get(0).getPaymentTime());
        assertEquals(payment.getCustomer(), payments.get(0).getCustomer());

        verify(paymentRepository, times(1)).findAll();
    }

    @Test
    void getPayment() throws DataNotFoundException {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        Payment retrievedPayment = paymentService.getPayment(1L);

        assertNotNull(retrievedPayment);
        assertEquals(payment.getAmount(), retrievedPayment.getAmount());
        assertEquals(payment.getStatus(), retrievedPayment.getStatus());
        assertEquals(payment.getPaymentDate(), retrievedPayment.getPaymentDate());
        assertEquals(payment.getPaymentTime(), retrievedPayment.getPaymentTime());
        assertEquals(payment.getCustomer(), retrievedPayment.getCustomer());

        verify(paymentRepository, times(1)).findById(1L);
    }

    @Test
    void getPayment_notFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> paymentService.getPayment(1L));

        verify(paymentRepository, times(1)).findById(1L);
    }
}
