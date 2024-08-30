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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Manager;
import group6.pojo.Slot;
import group6.pojo.Staff;
import group6.pojo.User;

public class SlotDAOTest {

	private static EntityManagerFactory emf;
    private static EntityManager em;
    private static SlotDAO slotDAO;
    private static ManagerDAO managerDAO;
    private static StaffDAO staffDAO;
    private static List<Slot>slots;
    private static Slot slot1;
    private static Slot slot2;
    

    @BeforeAll
    public static void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        slotDAO = new SlotDAO("test-unit");
        managerDAO = new ManagerDAO("test-unit");
        staffDAO = new StaffDAO("test-unit");
        UserDAO userDAO=new UserDAO("test-unit");
        
        User user1 = new User("1","","","");
        User user2 = new User("2","","","");
        User user3 = new User("3","","","");
        User user4 = new User("4","","","");
        
        userDAO.save(user1);
        userDAO.save(user2);
        userDAO.save(user3);
        userDAO.save(user4);
        Staff staff1 = new Staff("staff1","name1",user1);
        Staff staff2 = new Staff("staff2","name2",user2);
        staffDAO.save(staff1);
        staffDAO.save(staff2);
        
        Manager manager1 =new Manager("manager1","name1",user3);
        Manager manager2 =new Manager("manager2","name1",user4);
        managerDAO.save(manager1);
        managerDAO.save(manager2);
        
        slot1 = new Slot(Time.valueOf("08:00:00"),Time.valueOf("10:00:00"),manager1,staff1);
        slot2 = new Slot(Time.valueOf("10:00:00"),Time.valueOf("12:00:00"),manager2,staff2);
        slotDAO.save(slot1);
        slotDAO.save(slot2);
       
        
        slots= slotDAO.getSlots();
        
        
        
    }

    @AfterAll
    public static void tearDown() {
    	if (slots != null && !slots.isEmpty()) {
            for (Slot s : slots) {
            	slotDAO.delete(s.getSlotId());
            }
        }
        em.close();
        emf.close();
    }

    @Test
    public void testSaveAndFind() {
        Slot savedSlot = em.find(Slot.class, slot1.getSlotId());
        assertNotNull(savedSlot);
        assertEquals(slot1.getStartTime(), savedSlot.getStartTime());
        assertEquals(slot1.getEndTime(), savedSlot.getEndTime());
    }

    @Test
    public void testGetSlots() {
        List<Slot> slots = slotDAO.getSlots();
        assertNotNull(slots);
        assertEquals(2, slots.size());

    }

    @Test
    public void testDelete() {       
        slotDAO.delete(slot2.getSlotId());
        Slot deletedSlot = em.find(Slot.class, slot2.getSlotId());
        assertNull(deletedSlot);
    }

    @Test
    public void testUpdate() {
        slot1.setStartTime(Time.valueOf("09:00:00"));
        slot1.setEndTime(Time.valueOf("11:00:00"));
        slotDAO.update(slot1);

        Slot updatedSlot = slotDAO.findById(slot1.getSlotId());
        assertNotNull(updatedSlot);
        assertEquals(Time.valueOf("09:00:00"), updatedSlot.getStartTime());
        assertEquals(Time.valueOf("11:00:00"), updatedSlot.getEndTime());
    }
}
