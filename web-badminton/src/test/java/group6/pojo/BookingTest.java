package group6.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingTest {

    private Booking booking;
    private Customer customer;
    private Court court;
    private Slot slot;
    private Payment payment;

    @BeforeEach
    public void setUp() {
        customer = new Customer(); 
        court = new Court("Location A", Time.valueOf("08:00:00"), Time.valueOf("20:00:00"), 100.0f, new Admin(), new Manager());
        slot = new Slot(); 
        payment = new Payment();

        booking = new Booking();
        booking.setBookingId(1L);
        booking.setBookingType("Badminton");
        booking.setBookingDay("Monday");
        booking.setBookingDate(Date.valueOf("2023-08-01"));
        booking.setCustomer(customer);
        booking.setCourt(court);
        booking.setSlot(slot);
        booking.setPayment(payment);
    }

    @Test
    public void testBookingInitialization() {
        assertNotNull(booking);
        assertEquals(1L, booking.getBookingId());
        assertEquals("Badminton", booking.getBookingType());
        assertEquals("Monday", booking.getBookingDay());
        assertEquals(Date.valueOf("2023-08-01"), booking.getBookingDate());
        assertEquals(customer, booking.getCustomer());
        assertEquals(court, booking.getCourt());
        assertEquals(slot, booking.getSlot());
        assertEquals(payment, booking.getPayment());
    }

    @Test
    public void testSetCustomer() {
        Customer newCustomer = new Customer();
        booking.setCustomer(newCustomer);
        assertEquals(newCustomer, booking.getCustomer());
    }

    @Test
    public void testSetCourt() {
        Court newCourt = new Court("Location B", Time.valueOf("09:00:00"), Time.valueOf("21:00:00"), 120.0f, new Admin(), new Manager());
        booking.setCourt(newCourt);
        assertEquals(newCourt, booking.getCourt());
    }
    
    @Test
    public void testSetSlot() {
        Slot newSlot = new Slot(); 
        booking.setSlot(newSlot);
        assertEquals(newSlot, booking.getSlot());
    }
    
    @Test
    public void testSetPayment() {
        Payment newPayment = new Payment(); 
        booking.setPayment(newPayment);
        assertEquals(newPayment, booking.getPayment());
    }
}
