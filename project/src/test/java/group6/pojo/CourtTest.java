package group6.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourtTest {

    private Court court;

    @BeforeEach
    public void setUp() {
        court = new Court("Location A", "08:00 - 20:00", 100.0);
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
    public void testGetAndSetOperatingHours() {
        String operatingHours = "09:00 - 21:00";
        court.setOperatingHours(operatingHours);
        assertEquals(operatingHours, court.getOperatingHours());
    }

    @Test
    public void testGetAndSetPrice() {
        double price = 120.0;
        court.setPrice(price);
        assertEquals(price, court.getPrice());
    }

    @Test
    public void testGetAndSetAdmin() {
        Admin admin = new Admin();
        court.setAdmin(admin);
        assertEquals(admin, court.getAdmin());
    }

    @Test
    public void testGetAndSetBooking() {
        Booking booking = new Booking();
        court.setBooking(booking);
        assertEquals(booking, court.getBooking());
    }

    @Test
    public void testGetAndSetPayment() {
        Payment payment = new Payment();
        court.setPayment(payment);
        assertEquals(payment, court.getPayment());
    }

    @Test
    public void testGetAndSetManager() {
        Manager manager = new Manager();
        court.setManager(manager);
        assertEquals(manager, court.getManager());
    }

    @Test
    public void testGetAndSetSlots() {
        Set<Slot> slots = new HashSet<>();
        Slot slot1 = new Slot();
        Slot slot2 = new Slot();
        slots.add(slot1);
        slots.add(slot2);

        court.setSlots(slots);
        assertEquals(slots, court.getSlots());
    }

    @Test
    public void testDefaultConstructor() {
        Court newCourt = new Court();
        assertNull(newCourt.getLocation());
        assertNull(newCourt.getOperatingHours());
        assertEquals(0.0, newCourt.getPrice());
    }

    @Test
    public void testConstructorWithParameters() {
        Court newCourt = new Court("Location C", "10:00 - 22:00", 150.0);
        assertEquals("Location C", newCourt.getLocation());
        assertEquals("10:00 - 22:00", newCourt.getOperatingHours());
        assertEquals(150.0, newCourt.getPrice());
    }
}
