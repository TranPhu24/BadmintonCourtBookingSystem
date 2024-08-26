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
//    	userDAO.delete("126");
//    	userDAO.delete("127");
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
        user.setUserName("updatedPhu");
        user.setPassword("updatedPhu125");
        user.setRole("updatedManager");
        userDAO.update(user);

        User updatedUser = userDAO.findById(user.getUserID());
        assertNotNull(updatedUser);
        assertEquals("126", updatedUser.getUserID());
        assertEquals("updatedPhu", updatedUser.getUserName());
        assertEquals("updatedPhu125", updatedUser.getPassword());
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
        User user1 = new User();
        user1.setUserID("126");
        user1.setUserName("Tran");
        user1.setPassword("Tran127");
        user1.setRole("Staff");
        userDAO.save(user1);
        
        List<User> users = userDAO.getUsers();

        assertNotNull(users);
        assertTrue(users.size() >= 2);
//        assertTrue(users.stream().anyMatch(u -> u.getUserName().equals("user1")));
//        assertTrue(users.stream().anyMatch(u -> u.getUserName().equals("user2")));
    }
}
