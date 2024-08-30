package group6.pojo;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testGettersAndSetters() {
    	User user=new User("1","","","");
        Customer customer = new Customer("123", "Tan", "@letan", "0903",0,user);
        assertEquals("123", customer.getCustomerId());
        assertEquals("Tan", customer.getCustomerName());
        assertEquals("@letan", customer.getEmail());
        assertEquals("0903", customer.getPhone());
        assertEquals(user, customer.getUser());
        

        customer.setCustomerId("456");
        customer.setCustomerName("Lan");
        customer.setEmail("@lan");
        customer.setPhone("0123");
        User user2=new User("2","","","");
        customer.setUser(user2);
        
        

        assertEquals("456", customer.getCustomerId());
        assertEquals("Lan", customer.getCustomerName());
        assertEquals("@lan", customer.getEmail());
        assertEquals("0123", customer.getPhone());
        assertEquals(user2, customer.getUser());
    }

    @Test
    void testConstructor() {
    	User user=new User("1","","","");
    	Customer customer = new Customer("123", "Tan", "@letan", "0903",0,user);
        assertEquals("123", customer.getCustomerId());
        assertEquals("Tan", customer.getCustomerName());
        assertEquals("@letan", customer.getEmail());
        assertEquals("0903", customer.getPhone());
        assertEquals(user, customer.getUser());
    }

    @Test
    void testDefaultConstructor() {
        Customer customer = new Customer();
        assertNull(customer.getCustomerId());
        assertNull(customer.getCustomerName());
        assertNull(customer.getEmail());
        assertNull(customer.getPhone());
        assertNull(customer.getUser());
    }
}
