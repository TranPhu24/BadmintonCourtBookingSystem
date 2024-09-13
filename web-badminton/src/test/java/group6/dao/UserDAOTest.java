package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Payment;
import group6.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UserDAOTest {
    private EntityManager em;
    private EntityManagerFactory emf;
    private UserDAO userDAO;
    private User user;

    @BeforeEach
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        userDAO = new UserDAO("test-unit");
        user = new User();
        user.setUserID("126");
        user.setUserName("Duyen");
        user.setPassword("Duyen126");
        user.setRole("Customer");
        user.setRole("Customer");
        userDAO.save(user);
    }

    @AfterEach
    public void tearDown() {
    	userDAO.delete(user.getUserID());
        em.close();
        emf.close();
    }

    @Test
    public void testSaveAndFind() {
        User savedUser = userDAO.findById(user.getUserID());
        assertNotNull(savedUser);
        assertEquals(user.getUserName(), savedUser.getUserName());
        assertEquals(user.getPassword(), savedUser.getPassword());
        assertEquals(user.getRole(), savedUser.getRole());
    }
    @Test
    public void testUpdate() {
        user.setUserName("updatedDuyen");
        user.setPassword("updatedDuyen126");
        user.setRole("updatedManager");
        userDAO.update(user);

        User updatedUser = userDAO.findById(user.getUserID());
        assertNotNull(updatedUser);
        assertEquals("126", updatedUser.getUserID());
        assertEquals("updatedDuyen", updatedUser.getUserName());
        assertEquals("updatedDuyen126", updatedUser.getPassword());
        assertEquals("updatedManager", updatedUser.getRole());
    }

    @Test
    public void testDelete() {
        userDAO.delete(user.getUserID());
        User deletedUser = userDAO.findById(user.getUserID());
        assertNull(deletedUser);
    }

    @Test
    public void testGetUsers() {    
        List<User> users = userDAO.getUsers();
        assertNotNull(users);
        assertTrue(users.size() >= 2);

    }
}
