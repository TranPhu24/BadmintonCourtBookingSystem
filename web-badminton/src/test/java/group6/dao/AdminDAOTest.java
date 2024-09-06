package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Admin;
import group6.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
public class AdminDAOTest {
	private EntityManager em;
    private EntityManagerFactory emf;
    private AdminDAO adminDAO;
    private Admin admin;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        adminDAO = new AdminDAO("test-unit");
        admin = new Admin("129", "Tuan");
        adminDAO.save(admin);
    }

    @AfterEach
    void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    void testSaveAndFind() {
        Admin savedAdmin = adminDAO.findById("129");
        assertNotNull(savedAdmin);
        assertEquals("Tuan", savedAdmin.getAdminName());
    }

    @Test
    void testUpdate() {
        admin.setAdminName("updatedTuan");
        adminDAO.update(admin);

        Admin updatedAdmin = adminDAO.findById("129");
        assertNotNull(updatedAdmin);
        assertEquals("updatedTuan", updatedAdmin.getAdminName());
    }

    @Test
    void testGetAllAdmins() {
        Admin admin1 = new Admin("132", "Yen");
        adminDAO.save(admin1);
        List<Admin> admins = adminDAO.getAdmins();
        assertNotNull(admins);
        assertTrue(admins.size() >= 2);
    }
    @Test
    void testDelete() {
        Admin admin = new Admin("129", "Tuan");
        adminDAO.save(admin);
        adminDAO.delete("129");
        Admin deletedAdmin = adminDAO.findById("129");
        assertNull(deletedAdmin);
        adminDAO.delete("132");
    }


	    
	
}
