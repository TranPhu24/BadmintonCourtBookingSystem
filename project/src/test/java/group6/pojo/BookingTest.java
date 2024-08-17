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
    private Manager manager;
    private Set<Court> courts;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
        manager = new Manager();
        courts = new HashSet<>();

        booking = new Booking();
        booking.setBookingId(1L);
        booking.setBookingType("Badminton");
        booking.setBookingDate(Date.valueOf("2023-08-01"));
        booking.setBookingTime(Time.valueOf("10:00:00"));
        booking.setCustomer(customer);
        booking.setCourts(courts);
    }

    @Test
    public void testBookingInitialization() {
        assertNotNull(booking);
        assertEquals(1L, booking.getBookingId());
        assertEquals("Badminton", booking.getBookingType());
        assertEquals(Date.valueOf("2023-08-01"), booking.getBookingDate());
        assertEquals(Time.valueOf("10:00:00"), booking.getBookingTime());
        assertEquals(customer, booking.getCustomer());
        assertEquals(courts, booking.getCourts());
    }

    @Test
    public void testSetCustomer() {
        Customer newCustomer = new Customer();
        booking.setCustomer(newCustomer);
        assertEquals(newCustomer, booking.getCustomer());
    }

    @Test
    public void testSetCourts() {
        Set<Court> newCourts = new HashSet<>();
        booking.setCourts(newCourts);
        assertEquals(newCourts, booking.getCourts());
    }
    
    @Test
    public void testAddCourt() {
        Court court = new Court();
        courts.add(court);
        booking.setCourts(courts);
        assertEquals(1, booking.getCourts().size());
    }
}
