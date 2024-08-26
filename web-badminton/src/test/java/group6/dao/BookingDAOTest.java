package group6.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Booking;
import group6.pojo.Customer;
import group6.pojo.Manager;
import group6.pojo.User;

public class BookingDAOTest {
	 private static EntityManagerFactory emf;
	 private static EntityManager em;
     private static BookingDAO bookingDAO;
     private static ManagerDAO managerDAO;
     private static CustomerDAO customerDAO;
     private static List<Booking> bookings;
     private static Booking booking;
     private static Booking booking2;
    
    @BeforeEach
    void setUp() {
    	emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        bookingDAO = new BookingDAO("test-unit");
        managerDAO = new ManagerDAO("test-unit");
        customerDAO = new CustomerDAO("test-unit");
        User userC1 = new User("C1","","","");
        User userC2 = new User("C2","","","");
        User userM1 = new User("M1","","","");
        User userM2 = new User("M2","","","");
        UserDAO userDAO=new UserDAO("test-unit");
        userDAO.save(userC1);
        userDAO.save(userC2);
        userDAO.save(userM1);
        userDAO.save(userM2);
        
        Customer customer1=new Customer("c1","123","123","123",userC1);
        Customer customer2=new Customer("c2","456","456","456",userC2);
        customerDAO.save(customer1);
        customerDAO.save(customer2);
        
        Manager manager1=new Manager("m1","hi",userM1);
        Manager manager2=new Manager("m2","hihi",userM2);
        managerDAO.save(manager1);
        managerDAO.save(manager2);
        
        
        booking = new Booking("Badminton",Date.valueOf("2024-01-01"),Time.valueOf("10:00:00"),customer1,manager1);
        booking2 = new Booking("Badminton2",Date.valueOf("2024-02-02"),Time.valueOf("20:00:00"),customer2,manager2);

        /*testcreate*/
    	bookingDAO.createBooking(booking);
    	bookingDAO.createBooking(booking2);
    	/*textget*/
        bookings = bookingDAO.getBookings();
    	
        
    }
    @AfterEach
    void tearDown() {
    	if (bookings != null && !bookings.isEmpty()) {
            for (Booking b : bookings) {
            	bookingDAO.deleteBooking(b.getBookingId());
            }
        }
    	em.close();
        emf.close();
    }
    @Test
    public void testCreateAndFindBooking() {
        Booking savedBooking = bookingDAO.findById(booking.getBookingId());
        assertNotNull(savedBooking);
        assertEquals("Badminton", savedBooking.getBookingType());
    }

    @Test
    public void testUpdateBooking() {
        booking.setBookingType("Badminton123456");
        bookingDAO.updateBooking(booking);
        
        Booking updatedBooking = bookingDAO.findById(booking.getBookingId());
        assertEquals("Badminton123456", updatedBooking.getBookingType());
    }

    @Test
    public void testDeleteBooking() {
        bookingDAO.deleteBooking(booking.getBookingId());
        Booking deletedBooking = bookingDAO.findById(booking.getBookingId());
        assertNull(deletedBooking);
    }

    @Test
    public void testGetBookings() { 	
        assertEquals(2, bookings.size());
    }
}
