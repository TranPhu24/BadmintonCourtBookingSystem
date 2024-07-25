package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {
	private Account a;
	
	@BeforeEach
	public void setup() {
        a = new Account("AD001", "ad1", "1", "Ad");
	}
    @Test
    public void testGetAccountId() {
        assertEquals("AD001", a.getAccountId());
    }
    @Test 
    public void testSetAccountId() {
        a.setAccountId("AD123");
        assertEquals("AD123", a.getAccountId());
    }
    
    @Test
    public void testGetUserName() {
    	assertEquals("ad1", a.getUserName());
    }
    
    @Test
    public void testSetUserName() {
    	a.setUserName("Phu");
    	assertEquals("Phu", a.getUserName());
    }
    
    @Test
    public void testgetPassword() {
    	assertEquals("1", a.getPassword());
    }
    @Test 
    public void testSetPassword() {
    	a.setPassword("p123");
    	assertEquals("p123", a.getPassword());
    }
    @Test 
    public void testGetRole() {
    	assertEquals("Ad", a.getRole());
    }
    @Test
    public void testSetRole() {
    	a.setRole("Customer");
    	assertEquals("Customer", a.getRole() );
    }
    @Test
    public void testToString() {
        String expected = "\nAccountID=AD001, UserName=ad1, password=1, role=Ad";
        assertEquals(expected, a.toString());
    }
}

