package group6.dao;

import group6.pojo.Slot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

public class SlotDAOTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private SlotDAO slotDAO;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        slotDAO = new SlotDAO("test-unit");
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testSave() {
        Slot slot = new Slot();
        slot.setStartTime(Time.valueOf("08:00:00"));
        slot.setEndTime(Time.valueOf("10:00:00"));

        slotDAO.save(slot);
        Slot savedSlot = em.find(Slot.class, slot.getSlotId());
        assertNotNull(savedSlot);
        assertEquals(slot.getStartTime(), savedSlot.getStartTime());
        assertEquals(slot.getEndTime(), savedSlot.getEndTime());
    }

    @Test
    public void testGetSlots() {
        Slot slot1 = new Slot();
        slot1.setStartTime(Time.valueOf("08:00:00"));
        slot1.setEndTime(Time.valueOf("10:00:00"));
        Slot slot2 = new Slot();
        slot2.setStartTime(Time.valueOf("10:00:00"));
        slot2.setEndTime(Time.valueOf("12:00:00"));

        slotDAO.save(slot1);
        slotDAO.save(slot2);

        List<Slot> slots = slotDAO.getSlots();
        assertNotNull(slots);
        assertEquals(2, slots.size());

    }

    @Test
    public void testFindById() {
        Slot slot = new Slot();
        slot.setStartTime(Time.valueOf("08:00:00"));
        slot.setEndTime(Time.valueOf("10:00:00"));

        slotDAO.save(slot);
        Slot savedSlot = slotDAO.findById(slot.getSlotId());
        assertNotNull(savedSlot);
        assertEquals(slot.getStartTime(), savedSlot.getStartTime());
        assertEquals(slot.getEndTime(), savedSlot.getEndTime());
    }

    @Test
    public void testDelete() {
        Slot slot = new Slot();
        slot.setStartTime(Time.valueOf("08:00:00"));
        slot.setEndTime(Time.valueOf("10:00:00"));

        slotDAO.save(slot);
        slotDAO.delete(slot.getSlotId());
        Slot deletedSlot = em.find(Slot.class, slot.getSlotId());
        assertNull(deletedSlot);
    }

    @Test
    public void testUpdate() {
        Slot slot = new Slot();
        slot.setStartTime(Time.valueOf("08:00:00"));
        slot.setEndTime(Time.valueOf("10:00:00"));

        slotDAO.save(slot);

        slot.setStartTime(Time.valueOf("09:00:00"));
        slot.setEndTime(Time.valueOf("11:00:00"));
        slotDAO.update(slot);

        Slot updatedSlot = slotDAO.findById(slot.getSlotId());
        assertNotNull(updatedSlot);
        assertEquals(Time.valueOf("09:00:00"), updatedSlot.getStartTime());
        assertEquals(Time.valueOf("11:00:00"), updatedSlot.getEndTime());
    }
}