package group6.pojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setUserID("123");
        user.setUserName("Tan");
        user.setPassword("Tan123");
        user.setRole("Customer");

        assertEquals("123", user.getUserID());
        assertEquals("Tan", user.getUserName());
        assertEquals("Tan123", user.getPassword());
        assertEquals("Customer", user.getRole());

        user.setUserID("124");
        user.setUserName("Dung");
        user.setPassword("Dung124");
        user.setRole("Staff");

        assertEquals("124", user.getUserID());
        assertEquals("Dung", user.getUserName());
        assertEquals("Dung124", user.getPassword());
        assertEquals("Staff", user.getRole());
    }

    @Test
    void testConstructor() {
        User user = new User("123", "Tan", "Tan123", "Customer");
        assertEquals("123", user.getUserID());
        assertEquals("Tan", user.getUserName());
        assertEquals("Tan123", user.getPassword());
        assertEquals("Customer", user.getRole());
    }

    @Test
    void testDefaultConstructor() {
        User user = new User();
        assertNull(user.getUserID());
        assertNull(user.getUserName());
        assertNull(user.getPassword());
        assertNull(user.getRole());
    }
}
