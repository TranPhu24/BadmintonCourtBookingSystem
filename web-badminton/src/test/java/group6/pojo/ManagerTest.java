package group6.pojo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ManagerTest {

    @Test
    public void testConstructor() {
        Manager m = new Manager("123", "Trần Hoàng Phú");
        assertEquals("123", m.getManagerId());
        assertEquals("Trần Hoàng Phú", m.getManagerName());
    }

    @Test
    public void testGetterAndSetter() {
        Manager m = new Manager();
        String managerId = "123";
        String managerName = "Trần Hoàng Phú";
        
        m.setManagerId(managerId);
        assertEquals(managerId, m.getManagerId());

        m.setManagerName(managerName);
        assertEquals(managerName, m.getManagerName());
        
        User user = new User();
        m.setUser(user);
        assertNotNull(m.getUser()); 
        assertEquals(user, m.getUser());

        Set<Court> courts = new HashSet<>();
        m.setCourts(courts);
        assertNotNull(m.getCourts()); 
        assertEquals(courts, m.getCourts());

        Set<Slot> slots = new HashSet<>();
        m.setSlots(slots);
        assertNotNull(m.getSlots()); 
        assertEquals(slots, m.getSlots());
    }
}
