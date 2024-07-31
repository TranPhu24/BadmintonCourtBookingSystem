package group6.pojo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import group6.pojo.Manager;

import org.junit.jupiter.api.Test;

class ManagerTest {

	@Test
	public void testConstructor() {
		Manager m=new Manager( 123L, "Trần Hoàng Phú");
		assertEquals(123, m.getManagerId());
		assertEquals("Trần Hoàng Phú", m.getManagerName());
	}
	
	@Test
	public void testGetterandSetter() {
		Manager m=new Manager();
		Long managerId= 123L;
		String managerName="Trần Hoàng Phú";
		m.setManagerId(managerId);
		m.setManagerName(managerName);
		
		User user = new User();
        m.setUser(user);
        assertEquals(user, m.getUser());
        
        Set<Court> courts = new HashSet<>();
        m.setCourts(courts);
        assertEquals(courts, m.getCourts());
        
        Set<Slot> slots = new HashSet<>();
        m.setSlots(slots);
        assertEquals(slots, m.getSlots());
        
        Set<Booking> bookings = new HashSet<>();
        m.setBooking(bookings);
        assertEquals(bookings, m.getBooking());
		
	}

}
