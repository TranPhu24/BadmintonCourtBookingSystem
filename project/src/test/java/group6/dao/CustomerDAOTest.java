package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import group6.pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
    void testSave() {
        Customer customer1 = new Customer("123", "Tan", "@letan", "0903");
        customerDAO.save(customer1);
        Customer savedCustomer1 = em.find(Customer.class, "123");
        assertNotNull(savedCustomer1);
        assertEquals("Tan", savedCustomer1.getCustomerName());
        assertEquals("@letan", savedCustomer1.getEmail());
        assertEquals("0903", savedCustomer1.getPhone());

        Customer customer2 = new Customer("124", "Sang", "@sang", "0904");
        customerDAO.save(customer2);
        Customer savedCustomer2 = em.find(Customer.class, "124");
        assertNotNull(savedCustomer2);
        assertEquals("Sang", savedCustomer2.getCustomerName());
        assertEquals("@sang", savedCustomer2.getEmail());
        assertEquals("0904", savedCustomer2.getPhone());
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
