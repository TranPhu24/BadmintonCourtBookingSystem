package group6.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Customer;
import group6.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;



class CustomerDAOTest {

    private CustomerDAO customerDAO;
    private UserDAO userDAO;
    private EntityManagerFactory emf;
    private EntityManager em;
    private Customer customer;
    private Customer customer2;
    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        customerDAO = new CustomerDAO("test-unit");
        userDAO = new UserDAO("test-unit");
        
        User user = new User("c1","1","1","1");    
    	User user2 = new User("c2","2","2","2");
        userDAO.save(user);
        userDAO.save(user2);
        
        
        customer = new Customer("123", "Tan", "@letan", "0903",user);
        customer2 = new Customer("124", "Sang", "@sang", "0904",user2);
        customerDAO.save(customer);
    	customerDAO.save(customer2);
        
    }

    @AfterEach
    void tearDown() {
        if (em.isOpen()) {
            customerDAO.delete(customer.getCustomerId());
            customerDAO.delete(customer2.getCustomerId());
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }

    
    @Test
    public void testSaveAndFind() {
        Customer foundCustomer = customerDAO.findById(customer.getCustomerId());
        assertNotNull(foundCustomer);
        Customer foundCustomer2 = customerDAO.findById(customer2.getCustomerId());
        assertNotNull(foundCustomer2);
    }

    @Test
    void testGetCustomers() {
        List<Customer> customers = customerDAO.getCustomers();
        assertNotNull(customers);
        assertEquals(2, customers.size());
        assertNotNull(customers.get(0));
        assertNotNull(customers.get(1));
    }

    

    @Test
    void testUpdate() {
        customer.setCustomerName("TanUpdated");
        customer.setEmail("@letanupdate");
        customer.setPhone("0904");
//        User userUpdate=em.find(User.class, "1");
//        userUpdate.setUserName("3");
//        customer.setUser(userUpdate);
        customerDAO.update(customer);
        

        Customer updatedCustomer = em.find(Customer.class, "123");
        assertNotNull(updatedCustomer);
        assertEquals("TanUpdated", updatedCustomer.getCustomerName());
        assertEquals("@letanupdate", updatedCustomer.getEmail());
        assertEquals("0904", updatedCustomer.getPhone());
//        assertEquals(userUpdate, updatedCustomer.getUser());
          
    }
    
    @Test
    void testDelete() {
        customerDAO.delete(customer.getCustomerId());
        Customer deletedCustomer = em.find(Customer.class, "123");
        assertNull(deletedCustomer);
        customerDAO.delete("124");
        deletedCustomer = em.find(Customer.class, "124");
        assertNull(deletedCustomer);

    }
}
