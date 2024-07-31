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
        Staff staff = new Staff();
        Manager manager = new Manager();
        Set<Court> courts = new HashSet<>();
        Court court1 = new Court();
        Court court2 = new Court();
        courts.add(court1);
        courts.add(court2);

        slot.setSlotId(slotId);
        slot.setStartTime(startTime);
        slot.setEndTime(endTime);
        slot.setStaff(staff);
        slot.setManager(manager);
        slot.setCourts(courts);

        assertEquals(slotId, slot.getSlotId());
        assertEquals(startTime, slot.getStartTime());
        assertEquals(endTime, slot.getEndTime());
        assertEquals(staff, slot.getStaff());
        assertEquals(manager, slot.getManager());
        assertEquals(courts, slot.getCourts());
    }
    @Test
    public void testConstructor() {
        Long slotId = 451L;
        Time startTime = Time.valueOf("08:00:00");
        Time endTime = Time.valueOf("10:00:00");

        slot = new Slot(slotId, startTime, endTime);

        assertEquals(slotId, slot.getSlotId());
        assertEquals(startTime, slot.getStartTime());
        assertEquals(endTime, slot.getEndTime());
    }
    
}
