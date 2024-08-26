package group6.pojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class StaffTest {

    private Staff staff;
    private User user;
    //private Set<Slot> slots;

    @BeforeEach
    public void setUp() {
        staff = new Staff();
        user = new User();
       // slots = new HashSet<>();

        staff.setStaffId("123");
        staff.setStaffName("Phan Quoc Dung");
        staff.setUser(user);
       // staff.setSlots(slots);
    }

    @Test
    public void testGetStaffId() {
        assertEquals("123", staff.getStaffId());
    }

    @Test
    public void testSetStaffId() {
        staff.setStaffId("123");
        assertEquals("123", staff.getStaffId());
    }

    @Test
    public void testGetStaffName() {
        assertEquals("Phan Quoc Dung", staff.getStaffName());
    }

    @Test
    public void testSetStaffName() {
        staff.setStaffName("Phan Quoc Dung");
        assertEquals("Phan Quoc Dung", staff.getStaffName());
    }

    @Test
    public void testGetUser() {
        assertEquals(user, staff.getUser());
    }

    @Test
    public void testSetUser() {
        User newUser = new User();
        staff.setUser(newUser);
        assertEquals(newUser, staff.getUser());
    }

//    @Test
//    public void testGetSlots() {
//        assertEquals(slots, staff.getSlots());
//    }
//
//    @Test
//    public void testSetSlots() {
//        Set<Slot> newSlots = new HashSet<>();
//        staff.setSlots(newSlots);
//        assertEquals(newSlots, staff.getSlots());
//    }
}
