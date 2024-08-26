package group6.pojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class SlotTest {
    private Slot slot;

    @Test
    public void testGettersAndSetters() {
        Slot slot = new Slot();  

        Long slotId = 123L;
        LocalDateTime startTime = LocalDateTime.of(2024, 8, 24, 8, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 8, 24, 10, 0);
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
        LocalDateTime startTime = LocalDateTime.of(2024, 8, 24, 8, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 8, 24, 10, 0);

        slot = new Slot(startTime, endTime);

        assertEquals(startTime, slot.getStartTime());
        assertEquals(endTime, slot.getEndTime());
    }
}
