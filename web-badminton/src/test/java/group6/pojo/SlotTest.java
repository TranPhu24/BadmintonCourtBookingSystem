package group6.pojo;

import static org.junit.jupiter.api.Assertions.*;
import group6.pojo.Slot;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
class SlotTest {
	private Slot slot;

    @Test
    public void testGettersAndSetters() {
        Slot slot = new Slot();  
        
        Long slotId = 123L;
        Time startTime = Time.valueOf("08:00:00");
        Time endTime = Time.valueOf("10:00:00");
        slot.setSlotId(slotId);
        slot.setStartTime(startTime);
        slot.setEndTime(endTime);
        assertEquals(slotId, slot.getSlotId());
        assertEquals(startTime, slot.getStartTime());
        assertEquals(endTime, slot.getEndTime());
        
        Staff staff = new Staff();
        slot.setStaff(staff);
        assertNotNull(slot.getStaff());
        assertEquals(staff, slot.getStaff());

        
        Manager manager = new Manager();
        slot.setManager(manager);
        
        assertNotNull(slot.getManager());
        assertEquals(manager, slot.getManager());
        
        Set<Court> courts = new HashSet<>();
        slot.setCourts(courts);
        assertNotNull(slot.getCourts());
        assertEquals(courts, slot.getCourts());



    }
    @Test
    public void testConstructor() {
        Time startTime = Time.valueOf("08:00:00");
        Time endTime = Time.valueOf("10:00:00");

        slot = new Slot(startTime, endTime);

        assertEquals(startTime, slot.getStartTime());
        assertEquals(endTime, slot.getEndTime());
    }
    
}
