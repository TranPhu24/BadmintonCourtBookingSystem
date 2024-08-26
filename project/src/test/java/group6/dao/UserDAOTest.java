package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @BeforeEach
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        userDAO = new UserDAO("test-unit");
    }

    @AfterEach
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserID("123");
        user.setUserName("Tan");
        user.setPassword("Tan123");
        user.setRole("Customer");

        userDAO.save(user);
        User savedUser = userDAO.findById(user.getUserID());

        assertNotNull(savedUser);
        assertEquals(user.getUserName(), savedUser.getUserName());
        assertEquals(user.getPassword(), savedUser.getPassword());
        assertEquals(user.getRole(), savedUser.getRole());
    }

    @Test
    public void testFindById() {
        User user = new User();
        user.setUserID("124");
        user.setUserName("Dung");
        user.setPassword("Dung124");
        user.setRole("Staff");

        userDAO.save(user);
        User savedUser = userDAO.findById(user.getUserID());

        assertNotNull(savedUser);
        assertEquals(user.getUserID(), savedUser.getUserID());
        assertEquals(user.getUserName(), savedUser.getUserName());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserID("125");
        user.setUserName("Phu");
        user.setPassword("Phu125");
        user.setRole("Manager");

        userDAO.save(user);

        user.setUserID("125");
        user.setUserName("updatedPhu");
        user.setPassword("updatedPhu125");
        user.setRole("updatedManager");
        userDAO.update(user);

        User updatedUser = userDAO.findById(user.getUserID());
        assertNotNull(updatedUser);
        assertEquals("125", updatedUser.getUserID());
        assertEquals("updatedPhu", updatedUser.getUserName());
        assertEquals("updatedPhu125", updatedUser.getPassword());
        assertEquals("updatedManager", updatedUser.getRole());
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setUserID("126");
        user.setUserName("Duyen");
        user.setPassword("Duyen126");
        user.setRole("Customer");

        userDAO.save(user);

        userDAO.delete(user.getUserID());

        User deletedUser = userDAO.findById(user.getUserID());
        assertNull(deletedUser);
    }

    @Test
    public void testGetUsers() {
        User user1 = new User();
        user1.setUserID("127");
        user1.setUserName("Tran");
        user1.setPassword("Tran127");
        user1.setRole("Staff");

        userDAO.save(user1);

        User user2 = new User();
        user2.setUserID("128");
        user2.setUserName("Ngoc");
        user2.setPassword("Ngoc128");
        user2.setRole("Manager");

        userDAO.save(user2);

        List<User> users = userDAO.getUsers();

        assertNotNull(users);
        assertTrue(users.size() >= 2);
        assertTrue(users.stream().anyMatch(u -> u.getUserName().equals("user1")));
        assertTrue(users.stream().anyMatch(u -> u.getUserName().equals("user2")));
    }
}
