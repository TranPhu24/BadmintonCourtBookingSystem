package group6.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testGettersAndSetters() {
        Customer customer = new Customer("123", "Tan", "@letan", "0903");
        assertEquals("123", customer.getCustomerId());
        assertEquals("Tan", customer.getCustomerName());
        assertEquals("@letan", customer.getEmail());
        assertEquals("0903", customer.getPhone());

        customer.setCustomerId("456");
        customer.setCustomerName("Lan");
        customer.setEmail("@lan");
        customer.setPhone("0123");

        assertEquals("456", customer.getCustomerId());
        assertEquals("Lan", customer.getCustomerName());
        assertEquals("@lan", customer.getEmail());
        assertEquals("0123", customer.getPhone());
    }

    @Test
    void testConstructor() {
        Customer customer = new Customer("123", "Tan", "@letan", "0903");
        assertEquals("123", customer.getCustomerId());
        assertEquals("Tan", customer.getCustomerName());
        assertEquals("@letan", customer.getEmail());
        assertEquals("0903", customer.getPhone());
    }

    @Test
    void testDefaultConstructor() {
        Customer customer = new Customer();
        assertEquals(null, customer.getCustomerId());
        assertEquals(null, customer.getCustomerName());
        assertEquals(null, customer.getEmail());
        assertEquals(null, customer.getPhone());
    }
}


