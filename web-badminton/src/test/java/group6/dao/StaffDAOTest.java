package group6.dao;

import group6.pojo.Staff;
import org.junit.jupiter.api.*;
import group6.pojo.User;
import group6.pojo.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StaffDAOTest {

    private StaffDAO staffDAO;
    private UserDAO userDAO;
    private EntityManagerFactory emf;
    private EntityManager em;
    Staff staff1;
    Staff staff2;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        staffDAO = new StaffDAO("test-unit");
        userDAO = new UserDAO("test-unit");

        User user1 = new User("user1", "username1", "password1", "role1");
        User user2 = new User("user2", "username2", "password2", "role2");
        userDAO.save(user1);
        userDAO.save(user2);

        staff1 = new Staff("123", "Staff A");
        staff1.setUser(user1);

        staff2 = new Staff("124", "Staff B");
        staff2.setUser(user2);

        staffDAO.save(staff1);
        staffDAO.save(staff2);
    }

    @AfterEach
    void tearDown() {
        staffDAO.delete(staff1.getStaffId());
        staffDAO.delete(staff2.getStaffId());
        em.close();
        emf.close();
    }

    @Test
    void testSaveAndFind() {
        Staff foundStaff = staffDAO.findById("123");
        assertNotNull(foundStaff);
        assertEquals("Staff A", foundStaff.getStaffName());
        
        Staff foundStaff2 = staffDAO.findById("124");
        assertNotNull(foundStaff2);
        assertEquals("Staff B", foundStaff2.getStaffName());
    }

    @Test
    void testGetStaffs() {
        List<Staff> staffs = staffDAO.getStaffs();
        assertNotNull(staffs);
        assertTrue(staffs.size() >= 2);
    }

    @Test
    void testUpdate() {
        staff1.setStaffName("Staff A Updated");
        staffDAO.update(staff1);

        Staff updatedStaff = em.find(Staff.class, "123");
        assertNotNull(updatedStaff);
        assertEquals("Staff A Updated", updatedStaff.getStaffName());
    }

    @Test
    void testDelete() {
        staffDAO.delete("123");
        Staff deletedStaff = em.find(Staff.class, "123");
        assertNull(deletedStaff);
    }
}
