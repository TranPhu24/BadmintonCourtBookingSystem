package group6.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Admin;
import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.pojo.Payment;
import group6.pojo.User;

public class CourtDAOTest {
	private static EntityManagerFactory emf;
    private static EntityManager em;
    private static CourtDAO courtDAO;
    private static ManagerDAO managerDAO;
    private static PaymentDAO paymentDAO;
    private static UserDAO userDAO;
    private static AdminDAO adminDAO;
    private static BookingDAO bookingDAO;
    private static List<Court> courts;
    private static Court court;
    private static Court court2;
    
    @BeforeAll
    public static void setUp() {
    	emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        courtDAO = new CourtDAO("test-unit");
        userDAO = new UserDAO("test-unit");
        managerDAO=new ManagerDAO("test-unit");
        paymentDAO=new PaymentDAO("test-unit");
        bookingDAO=new BookingDAO("test-unit");
        adminDAO=new AdminDAO("test-unit");
        User userM1 = new User("M1","","","");
        User userM2 = new User("M2","","","");
        userDAO.save(userM1);
        userDAO.save(userM2);
        Manager manager1=new Manager("m1","hi",userM1);
        Manager manager2=new Manager("m2","hihi",userM2);
        managerDAO.save(manager1);
        managerDAO.save(manager2);
        Admin admin =new Admin("1","admin");
        adminDAO.save(admin);
         
        
        
        Booking booking=new Booking();
        Booking booking2=new Booking();
        bookingDAO.createBooking(booking);
        bookingDAO.createBooking(booking2);
        Payment payment = new Payment();   
        Payment payment2 = new Payment();   
        paymentDAO.save(payment);
        paymentDAO.save(payment2);
        
        court = new Court("Location A",Time.valueOf("08:00:00"), Time.valueOf("20:00:00"),100.0,admin,booking,manager1,payment);
        court2 = new Court("Location B",Time.valueOf("10:00:00"),Time.valueOf("23:00:00"),200.0,admin,booking2,manager2,payment2);
        
        courtDAO.createCourt(court);
        courtDAO.createCourt(court2);
        
        courts = courtDAO.getCourts();
    }
    
    @AfterAll
    public static void tearDown() {
    	for (Court c : courts) {
        	courtDAO.deleteCourt(c.getCourtId());
        }       
    	em.close();
        emf.close();
    }
    
    @Test
    public void testUpdateCourt() {
        court.setLocation("Location C - Updated");
        court.setStartTime(Time.valueOf("11:00:00"));
        court.setEndTime(Time.valueOf("23:00:00"));
        court.setPrice(160.0);
        courtDAO.updateCourt(court);

        Court updatedCourt = courtDAO.findById(court.getCourtId());
        assertEquals("Location C - Updated", updatedCourt.getLocation());
        assertEquals(Time.valueOf("11:00:00"), updatedCourt.getStartTime());
        assertEquals(Time.valueOf("23:00:00"), updatedCourt.getEndTime());
        assertEquals(160.0, updatedCourt.getPrice());
    }
    @Test
    public void testCreateAndFintCourt() {
        Court savedCourt = courtDAO.findById(court.getCourtId());
        assertNotNull(savedCourt);
        assertEquals("Location C - Updated", savedCourt.getLocation());
        assertEquals(Time.valueOf("11:00:00"), savedCourt.getStartTime());
        assertEquals(Time.valueOf("23:00:00"), savedCourt.getEndTime());
        assertEquals(160.0, savedCourt.getPrice());
    }

    @Test
    public void testDeleteCourt() {
        courtDAO.deleteCourt(court2.getCourtId());
        Court deletedCourt = courtDAO.findById(court2.getCourtId());
        assertNull(deletedCourt);
    }

    @Test
    public void testGetCourts() {
        assertTrue(courts.size() >= 2);
    }
}