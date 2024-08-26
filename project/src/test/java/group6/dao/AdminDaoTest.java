package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import group6.pojo.Admin;
import group6.pojo.Court;
import group6.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminDAOTest {

    private EntityManager em;
    private EntityManagerFactory emf;
    private AdminDAO adminDAO;
    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        adminDAO = new AdminDAO("test-unit");
        userDAO = new UserDAO("test-unit");
    }

    @AfterEach
    void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    void testSave() {
        User user = new User();
        user.setUserID("129");
        user.setUserName("Tuan");
        user.setPassword("Tuan129");
        userDAO.save(user);

        Admin admin = new Admin("129", "Tuan");
        adminDAO.save(admin);

        Admin savedAdmin = adminDAO.findById("129");
        assertNotNull(savedAdmin);
        assertEquals("Tuan", savedAdmin.getAdminName());
    }

    @Test
    void testDelete() {
        Admin admin = new Admin("129", "Tuan");
        adminDAO.save(admin);

        adminDAO.delete("129");
        Admin deletedAdmin = adminDAO.findById("129");
        assertNull(deletedAdmin);
    }

    @Test
    void testFindById() {
        Admin admin = new Admin("129", "Tuan");
        adminDAO.save(admin);

        Admin foundAdmin = adminDAO.findById("129");
        assertNotNull(foundAdmin);
        assertEquals("Tuan", foundAdmin.getAdminName());
    }

    @Test
    void testUpdate() {
        Admin admin = new Admin("129", "Tuan");
        adminDAO.save(admin);

        admin.setAdminId("129");
        admin.setAdminName("updatedTuan");
        adminDAO.update(admin);

        Admin updatedAdmin = adminDAO.findById("129");
        assertNotNull(updatedAdmin);
        assertEquals("updatedTuan", updatedAdmin.getAdminName());
    }

    @Test
    void testGetAllAdmins() {
        Admin admin1 = new Admin("132", "Yen");
        Admin admin2 = new Admin("134", "Son");
        adminDAO.save(admin1);
        adminDAO.save(admin2);

        List<Admin> admins = adminDAO.getAdmins();
        assertNotNull(admins);
        assertTrue(admins.size() >= 2);
    }

    @Test
    void testAdminWithCourts() {
        // Tạo Admin
        Admin admin = new Admin("135", "Hong");

        Court court1 = new Court("Quan 1", "08:00-18:00", 100.0);
        Court court2 = new Court("Quan 2", "09:00-17:00", 150.0);

        court1.setAdmin(admin);
        court2.setAdmin(admin);

        admin.getCourts().add(court1);
        admin.getCourts().add(court2);

        adminDAO.save(admin);

        Admin savedAdmin = adminDAO.findById("135");
        assertNotNull(savedAdmin);
        assertEquals(2, savedAdmin.getCourts().size());

        assertTrue(savedAdmin.getCourts().stream().anyMatch(c -> c.getLocation().equals("Quan 1")));
        assertTrue(savedAdmin.getCourts().stream().anyMatch(c -> c.getLocation().equals("Quan 2")));
    }
}
