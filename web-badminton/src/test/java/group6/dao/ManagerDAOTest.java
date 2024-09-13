package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import group6.pojo.Manager;
import group6.pojo.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ManagerDAOTest {
	private ManagerDAO managerDAO;
    private UserDAO userDAO;
    private EntityManagerFactory emf;
    private EntityManager em;
    private Manager manager;
    private Manager manager2;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        managerDAO = new ManagerDAO("test-unit");
        userDAO = new UserDAO("test-unit");

        User user = new User("m1", "1", "1", "1");
        User user2 = new User("m2", "2", "2", "2");
        userDAO.save(user);
        userDAO.save(user2);

        manager = new Manager("m1","Tran Hoang Phu", user);
        manager2 = new Manager("m2","Phu 2", user2);
        managerDAO.save(manager);
        managerDAO.save(manager2);
    }

    @AfterEach
    void tearDown() {
    	managerDAO.delete(manager.getManagerId());
        managerDAO.delete(manager2.getManagerId());
        em.close();
        emf.close();
    }
    @Test
    public void testSaveAndFind() {
    	 Manager foundManager = managerDAO.findById(manager.getManagerId());
         assertNotNull(foundManager);
         assertEquals("Tran Hoang Phu", foundManager.getManagerName());

         Manager foundManager2 = managerDAO.findById(manager2.getManagerId());
         assertNotNull(foundManager2);
         assertEquals("Phu 2", foundManager2.getManagerName());
    }
    @Test
    public void testGetManagers() {
    	List<Manager> managers = managerDAO.getManagers();
        assertNotNull(managers);
        assertEquals(2, managers.size());
    }
    
   
    @Test
    public void testUpdate() {
    	manager.setManagerName("Tran Hoang Phu Updated");
        managerDAO.update(manager);

        Manager updatedManager = em.find(Manager.class, manager.getManagerId());
        assertNotNull(updatedManager);
        assertEquals("Tran Hoang Phu Updated", updatedManager.getManagerName());
    }
    
    @Test
    void testDelete() {
        managerDAO.delete(manager.getManagerId());
        Manager deletedManager = em.find(Manager.class, manager.getManagerId());
        assertNull(deletedManager);

        managerDAO.delete(manager2.getManagerId());
        deletedManager = em.find(Manager.class, manager2.getManagerId());
        assertNull(deletedManager);
    }

}
