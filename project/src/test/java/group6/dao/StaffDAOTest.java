package group6.dao;

import group6.pojo.Staff;
import org.junit.jupiter.api.*;
import group6.pojo.User;
import group6.pojo.Payment;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StaffDAOTest {

    private static EntityManagerFactory emf;
    private static StaffDAO staffDAO;

    @BeforeAll
    public static void setUp() {
        emf = Persistence.createEntityManagerFactory("yourPersistenceUnitName");
        staffDAO = new StaffDAO("yourPersistenceUnitName");
    }

    @AfterAll
    public static void tearDown() {
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    public void testSave() {
    	StaffDAO staffDAO = new StaffDAO("test-unit");
        UserDAO userDAO = new UserDAO("test-unit");
        
        User user = new User();
        user.setUserName("user1");
        user.setPassword("pass2");
        userDAO.save(user);

        Staff s=new Staff();
    	s.setStaffName("Phan Quoc Dung");
    	s.setUser(user);
    	
    	
        staffDAO.save(s);
        
        Staff savedStaff = staffDAO.findById(s.getStaffId());
    	
    	assertNotNull(savedStaff);
    	assertEquals(s.getStaffName(), savedStaff.getStaffName());

    }

    @Test
    public void testGetStaffs() {
    	StaffDAO staffDAO = new StaffDAO("test-unit");
        UserDAO userDAO = new UserDAO("test-unit");
        
        User user1 = new User();
        user1.setUserName("user1");
        user1.setPassword("pass2");
        userDAO.save(user1);
        
        User user2 = new User();
        user2.setUserName("user2");
        user2.setPassword("pass2");
        userDAO.save(user2);

        Staff s1=new Staff();
    	s1.setStaffName("Phan Quoc Dung");
    	s1.setUser(user1);
    	
    	Staff s2=new Staff();
    	s2.setStaffName("Phan Quoc Dung");
    	s2.setUser(user1);

        staffDAO.save(s1);
        staffDAO.save(s2);

        List<Staff> staffs = StaffDAO.getStaffs();
        
        assertNotNull(staffs);
        assertEquals(2, staffs.size());
    }

    @Test
    public void testDelete() {
        staffDAO.delete(1L);
        Staff staff = staffDAO.findById(1L);
        assertNull(staff);
    }

    @Test
    public void testFindById() {
    	StaffDAO staffDAO = new StaffDAO("test-unit");
        UserDAO userDAO = new UserDAO("test-unit");
        
        User user = new User();
        user.setUserName("user1");
        user.setPassword("pass1");
        userDAO.save(user);

        Staff s=new Staff();
    	s.setStaffName("Phan Quoc Dung");
    	s.setUser(user); 

    	staffDAO.save(s);
    	Staff savedStaff = staffDAO.findById(m.getManagerId());
        assertNotNull(savedStaff);
        assertEquals(s.getStaffId(), savedStaff.getStaffId());
    }

    @Test
    public void testUpdate() {
    StaffDAO StaffDAO = new StaffDAO("test-unit");
    UserDAO userDAO = new UserDAO("test-unit");
    
    User user = new User();
    user.setUserName("user1");
    user.setPassword("pass1");
    userDAO.save(user);

    Staff s=new Staff();
	s.setStaffName("Phan Quoc Dung");
	s.setUser(user);
	staffDAO.save(m);

	
	s.setStaffName("Phan Quoc Dung");
	staffDAO.update(s);
	
	

	Staff updatedStaff = staffDAO.findById(s.getStaffId());
    assertNotNull(updatedStaff);
    assertEquals("Phan Quoc Dung", updatedStaff.getStaffName());
    }
}
