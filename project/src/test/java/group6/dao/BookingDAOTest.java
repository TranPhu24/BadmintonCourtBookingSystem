package group6.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Booking;
import group6.pojo.Customer;
import group6.pojo.Manager;

public class BookingDAOTest {

    private BookingDAO bookingDAO;
    
    @BeforeEach
    public void setUp() {
        bookingDAO = new BookingDAO("testPU");
    }

    @Test
    public void testCreateBooking() {
        Booking booking = new Booking();
        booking.setBookingType("Tennis");
        booking.setBookingDate(Date.valueOf("2024-08-16"));
        booking.setBookingTime(Time.valueOf("10:00:00"));

        bookingDAO.createBooking(booking);
        Booking savedBooking = bookingDAO.findById(booking.getBookingId());
        assertNotNull(savedBooking);
        assertEquals("Tennis", savedBooking.getBookingType());
    }

    @Test
    public void testFindById() {
        Booking booking = new Booking();
        booking.setBookingType("Tennis");
        booking.setBookingDate(Date.valueOf("2024-08-16"));
        booking.setBookingTime(Time.valueOf("10:00:00"));

        bookingDAO.createBooking(booking);
        Booking foundBooking = bookingDAO.findById(booking.getBookingId());
        assertNotNull(foundBooking);
        assertEquals("Tennis", foundBooking.getBookingType());
    }

    @Test
    public void testUpdateBooking() {
        Booking booking = new Booking();
        booking.setBookingType("Tennis");
        booking.setBookingDate(Date.valueOf("2024-08-16"));
        booking.setBookingTime(Time.valueOf("10:00:00"));

        bookingDAO.createBooking(booking);
        booking.setBookingType("Tennis");
        bookingDAO.updateBooking(booking);
        
        Booking updatedBooking = bookingDAO.findById(booking.getBookingId());
        assertEquals("Tennis", updatedBooking.getBookingType());
    }

    @Test
    public void testDeleteBooking() {
        Booking booking = new Booking();
        booking.setBookingType("Tennis");
        booking.setBookingDate(Date.valueOf("2024-08-16"));
        booking.setBookingTime(Time.valueOf("10:00:00"));

        bookingDAO.createBooking(booking);
        Long bookingId = booking.getBookingId();
        bookingDAO.deleteBooking(bookingId);
        
        Booking deletedBooking = bookingDAO.findById(bookingId);
        assertNull(deletedBooking);
    }

    @Test
    public void testGetBookings() {
        Booking booking1 = new Booking();
        booking1.setBookingType("Tennis");
        booking1.setBookingDate(Date.valueOf("2024-08-16"));
        booking1.setBookingTime(Time.valueOf("10:00:00"));
        
        Booking booking2 = new Booking();
        booking2.setBookingType("Tennis");
        booking2.setBookingDate(Date.valueOf("2024-08-17"));
        booking2.setBookingTime(Time.valueOf("11:00:00"));
        
        bookingDAO.createBooking(booking1);
        bookingDAO.createBooking(booking2);

        List<Booking> bookings = bookingDAO.getBookings();
        assertEquals(2, bookings.size());
    }
}
