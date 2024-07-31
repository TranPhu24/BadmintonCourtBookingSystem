package group6.dao;

import static org.junit.Assert.*;


import group6.pojo.Manager;
import group6.pojo.Slot;
import group6.pojo.User;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Time;
import java.util.List;

public class ManagerDAOTest {
    private EntityManager em;
    private EntityManagerFactory emf;
    private ManagerDAO managerDAO;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        managerDAO = new ManagerDAO("test-unit");

    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testSave() {
        ManagerDAO managerDAO = new ManagerDAO("test-unit");
        UserDAO userDAO = new UserDAO("test-unit");
        
        User user = new User();
        user.setUserName("user1");
        user.setPassword("pass1");
        userDAO.save(user);

    	Manager m=new Manager();
    	m.setManagerName("Tran Hoag Phu");
    	m.setUser(user);
    	
    	managerDAO.save(m);
    	Manager savedManager = managerDAO.findById(m.getManagerId());
    	
    	assertNotNull(savedManager);
    	assertEquals(m.getManagerName(), savedManager.getManagerName());
    }
    @Test
    public void testGetManagers() {

        ManagerDAO managerDAO = new ManagerDAO("test-unit");
        UserDAO userDAO = new UserDAO("test-unit");
        
        User user1 = new User();
        user1.setUserName("user1");
        user1.setPassword("pass1");
        userDAO.save(user1);

        User user2 = new User();
        user2.setUserName("user2");
        user2.setPassword("pass2");
        userDAO.save(user2);

        Manager m1 = new Manager();
        m1.setManagerName("Long");
        m1.setUser(user1); 

        Manager m2 = new Manager();
        m2.setManagerName("Phu");
        m2.setUser(user2); 

        managerDAO.save(m1);
        managerDAO.save(m2);

        List<Manager> managers = managerDAO.getManagers();
   
        assertNotNull(managers);
        assertEquals(2, managers.size());

    }
    
    @Test
    public void testFindById() {
        ManagerDAO managerDAO = new ManagerDAO("test-unit");
        UserDAO userDAO = new UserDAO("test-unit");
        
        User user = new User();
        user.setUserName("user1");
        user.setPassword("pass1");
        userDAO.save(user);

    	Manager m=new Manager();
    	m.setManagerName("Tran Hoang Phu");
    	m.setUser(user); 

        managerDAO.save(m);
        Manager savedManager = managerDAO.findById(m.getManagerId());
        assertNotNull(savedManager);
        assertEquals(m.getManagerId(), savedManager.getManagerId());
    }
    
    @Test
    public void testUpdate() {
        ManagerDAO managerDAO = new ManagerDAO("test-unit");
        UserDAO userDAO = new UserDAO("test-unit");
        
        User user = new User();
        user.setUserName("user1");
        user.setPassword("pass1");
        userDAO.save(user);

    	Manager m=new Manager();
    	m.setManagerName("Tran Hoang Phu");
    	m.setUser(user);
        managerDAO.save(m);

    	
    	m.setManagerName("Tran Hoang Phuu");
    	managerDAO.update(m);
    	
    	

        Manager updatedManager = managerDAO.findById(m.getManagerId());
        assertNotNull(updatedManager);
        assertEquals("Tran Hoang Phuu", updatedManager.getManagerName());
    }

}
