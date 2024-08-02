package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import group6.pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {

    private CustomerDAO customerDAO;
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("JPAS");
        em = emf.createEntityManager();
        customerDAO = new CustomerDAO("JPAS");
    }

    @AfterEach
    void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    void testGetCustomers() {
        UserDAO userDAO = new UserDAO("test-unit");
        CustomerDAO customerDAO = new CustomerDAO("test-unit");
        
        User user1 = new User();
        user1.setUserName("user1");
        user1.setPassword("pass1");
        userDAO.save(user1);

        User user2 = new User();
        user2.setUserName("user2");
        user2.setPassword("pass2");
        userDAO.save(user2);
        
        Customer customer1 = new Customer("123", "Tan", "@letan", "0903");
        customer1.setUser(user1);
        Customer customer2 = new Customer("124", "Sang", "@sang", "0904");
        customer2.setUser(user2);
        
        User user3 = new User();
        user3.setUserName("user2");
        user3.setPassword("pass2");
        userDAO.save(user3);
        
        
        User user4 = new User();
        user4.setUserName("user2");
        user4.setPassword("pass2");
        userDAO.save(user4);
        
        
        Customer customer3 = new Customer("127", "Sangkj", "@sangyt", "0904");
        customer3.setUser(user3);
        
        Customer customer4 = new Customer("128", "Sangsd", "@sangdljndjbj", "0904");
        customer4.setUser(user4);


        customerDAO.save(customer1);
        customerDAO.save(customer2);
        customerDAO.save(customer3);
        customerDAO.save(customer4);
        
        

        List<Customer> customers = customerDAO.getCustomers();
        
        assertNotNull(customers);
        assertEquals(2, customers.size());

    }

    /*
    @Test
    void testGetCustomers() {
    	Customer customer1 = new Customer("123", "Tan", "@letan", "0903");
        Customer customer2 = new Customer("124", "Sang", "@sang", "0904");

        customerDAO.save(customer1);
        customerDAO.save(customer2);

        List<Customer> customers = customerDAO.getCustomers();
        
        assertTrue(customers.size() > 0);
        assertTrue(customers.contains(customer1));
        assertTrue(customers.contains(customer2));
    }
    
    @Test
    void testDelete() {
    	Customer customer = new Customer("123", "Tan", "@letan", "0903");
        customerDAO.save(customer);

        customerDAO.delete("123");
        Customer deletedCustomer = em.find(Customer.class, "123");
        assertNull(deletedCustomer);
    }

    @Test
    void testFindById() {
    	Customer customer = new Customer("123", "Tan", "@letan", "0903");
        customerDAO.save(customer);

        Customer foundCustomer = customerDAO.findById("123");
        assertNotNull(foundCustomer);
        assertEquals("Tan", foundCustomer.getCustomerName());
        assertEquals("@letan", foundCustomer.getEmail());
        assertEquals("0903", foundCustomer.getPhone());
    }

    @Test
    void testUpdate() {
        Customer customer = new Customer("123", "Tan", "@letan", "0903");
        customerDAO.save(customer);

        customer.setCustomerName("Tan Updated");
        customer.setEmail("@letanupdate");
        customer.setPhone("0904");
        customerDAO.update(customer);

        Customer updatedCustomer = em.find(Customer.class, "123");
        assertNotNull(updatedCustomer);
        assertEquals("Tan Updated", updatedCustomer.getCustomerName());
        assertEquals("@letanupdate", updatedCustomer.getEmail());
        assertEquals("0904", updatedCustomer.getPhone());
    }*/
}
