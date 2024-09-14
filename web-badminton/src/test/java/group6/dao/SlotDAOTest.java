package group6.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Manager;
import group6.pojo.Slot;
import group6.pojo.Staff;
import group6.pojo.User;

public class SlotDAOTest {

	private  EntityManagerFactory emf;
    private  EntityManager em;
    private  SlotDAO slotDAO;
    private  ManagerDAO managerDAO;
    private  StaffDAO staffDAO;
    private  List<Slot>slots;
    private  Slot slot1;
    private Slot slot2;
    

    @BeforeEach
    public  void setUp() {
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
       
    }

    @AfterEach
    public void tearDown() {
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
        Slot savedSlot = slotDAO.findById(slot1.getSlotId());
        assertNotNull(savedSlot);
        assertEquals(slot1.getStartTime(), savedSlot.getStartTime());
        assertEquals(slot1.getEndTime(), savedSlot.getEndTime());
    }

    @Test
    public void testGetSlots() {
        List<Slot> slots = slotDAO.getSlots();
        assertNotNull(slots);
        assertTrue(slots.size()>=2);

    }

    @Test
    public void testDelete() {       
        slotDAO.delete(slot2.getSlotId());
        Slot deletedSlot = slotDAO.findById(slot2.getSlotId());
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

    @Test
    public void testCheckSlotAvailable() {
        boolean isSlotAvailable = slotDAO.checkSlot(Time.valueOf("08:00:00"), Time.valueOf("10:00:00"));
        assertTrue(isSlotAvailable);  
    }

    @Test
    public void testCheckSlotNotAvailable() {
        boolean isSlotAvailable = slotDAO.checkSlot(Time.valueOf("05:00:00"), Time.valueOf("07:00:00"));
        assertFalse(isSlotAvailable);  
    }
