package group6.pojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AdminTest {

    @Test
    void testGettersAndSetters() {
        Admin admin = new Admin();
        admin.setAdminId("129");
        admin.setAdminName("Tuan");

        assertEquals("129", admin.getAdminId());
        assertEquals("Tuan", admin.getAdminName());

        admin.setAdminId("132");
        admin.setAdminName("Yen");

        assertEquals("132", admin.getAdminId());
        assertEquals("Yen", admin.getAdminName());
    }

    @Test
    void testConstructor() {
        Admin admin = new Admin("129", "Tuan");
        assertEquals("129", admin.getAdminId());
        assertEquals("Tuan", admin.getAdminName());
    }

    @Test
    void testDefaultConstructor() {
        Admin admin = new Admin();
        assertNull(admin.getAdminId());
        assertNull(admin.getAdminName());
    }

    @Test
    void testAdminWithCourts() {
        Admin admin = new Admin("129", "Tuan");
        Court court1 = new Court("Quan 1", "08:00-18:00", 100.0);
        Court court2 = new Court("Quan 2", "09:00-17:00", 150.0);

        admin.getCourts().add(court1);
        admin.getCourts().add(court2);

        assertEquals(2, admin.getCourts().size());
        assertTrue(admin.getCourts().contains(court1));
        assertTrue(admin.getCourts().contains(court2));
    }
}
