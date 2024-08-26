package group6.pojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class PaymentTest {

    private Payment payment;
    private Customer customer;
//    private Set<Court> courts;

    @BeforeEach
    public void setUp() {
        payment = new Payment();
        customer = new Customer();
//        courts = new HashSet<>();

//        payment.setPaymentId(100);
        payment.setAmount(100.0f);
        payment.setStatus("Paid");
        payment.setCustomer(customer);
//        payment.setCourts(courts);
    }

//    @Test
//    public void testGetPaymentId() {
//        assertEquals(1L, payment.getPaymentId());
//    }
//
//    @Test
//    public void testSetPaymentId() {
//        payment.setPaymentId(2L);
//        assertEquals(2L, payment.getPaymentId());
//    }

    @Test
    public void testGetAmount() {
        assertEquals(100.0f, payment.getAmount());
    }

    @Test
    public void testSetAmount() {
        payment.setAmount(200.0f);
        assertEquals(200.0f, payment.getAmount());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Paid", payment.getStatus());
    }

    @Test
    public void testSetStatus() {
        payment.setStatus("Pending");
        assertEquals("Pending", payment.getStatus());
    }

    @Test
    public void testGetCustomer() {
        assertEquals(customer, payment.getCustomer());
    }

    @Test
    public void testSetCustomer() {
        Customer newCustomer = new Customer();
        payment.setCustomer(newCustomer);
        assertEquals(newCustomer, payment.getCustomer());
    }

//    @Test
//    public void testGetCourts() {
//        assertEquals(courts, payment.getCourts());
//    }
//
//    @Test
//    public void testSetCourts() {
//        Set<Court> newCourts = new HashSet<>();
//        payment.setCourts(newCourts);
//        assertEquals(newCourts, payment.getCourts());
//    }
}
