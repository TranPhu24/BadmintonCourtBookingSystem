package group6.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourtTest {

    private Court court;

    @BeforeEach
    public void setUp() {
        Admin admin = new Admin("1", "admin");
        Manager manager = new Manager("m1", "Manager1", null);
        court = new Court("Location A", Time.valueOf("08:00:00"), Time.valueOf("20:00:00"), 100.0f, admin, manager);
    }

    @Test
    public void testGetAndSetCourtId() {
        Long courtId = 1L;
        court.setCourtId(courtId);
        assertEquals(courtId, court.getCourtId());
    }

    @Test
    public void testGetAndSetLocation() {
        String location = "Location B";
        court.setLocation(location);
        assertEquals(location, court.getLocation());
    }

    @Test
    public void testGetAndSetStartTime() {
        Time startTime = Time.valueOf("09:00:00");
        court.setStartTime(startTime);
        assertEquals(startTime, court.getStartTime());
    }

    @Test
    public void testGetAndSetEndTime() {
        Time endTime = Time.valueOf("21:00:00");
        court.setEndTime(endTime);
        assertEquals(endTime, court.getEndTime());
    }

    @Test
    public void testGetAndSetPrice() {
        float price = 120.0f;
        court.setPrice(price);
        assertEquals(price, court.getPrice());
    }

    @Test
    public void testGetAndSetAdmin() {
        Admin admin = new Admin("2", "admin2");
        court.setAdmin(admin);
        assertEquals(admin, court.getAdmin());
    }

    @Test
    public void testGetAndSetManager() {
        Manager manager = new Manager("m2", "Manager2", null);
        court.setManager(manager);
        assertEquals(manager, court.getManager());
    }

    @Test
    public void testGetAndSetBookings() {
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        Set<Booking> bookings = new HashSet<>();
        bookings.add(booking1);
        bookings.add(booking2);

        court.setBookings(bookings);
        assertEquals(bookings, court.getBookings());
    }

    @Test
    public void testDefaultConstructor() {
        Court newCourt = new Court();
        assertNull(newCourt.getLocation());
        assertEquals(0.0, newCourt.getPrice());
    }

    @Test
    public void testConstructorWithParameters() {
        Admin admin = new Admin("3", "admin3");
        Manager manager = new Manager("m3", "Manager3", null);
        Court newCourt = new Court("Location C", Time.valueOf("10:00:00"), Time.valueOf("23:00:00"), 150.0f, admin, manager);
        assertEquals("Location C", newCourt.getLocation());
        assertEquals(Time.valueOf("10:00:00"), newCourt.getStartTime());
        assertEquals(Time.valueOf("23:00:00"), newCourt.getEndTime());
        assertEquals(150.0, newCourt.getPrice());
        assertEquals(admin, newCourt.getAdmin());
        assertEquals(manager, newCourt.getManager());
    }
}
