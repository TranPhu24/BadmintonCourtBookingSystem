package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Customer;
import group6.pojo.User;

public class CustomerDAO {

    private EntityManagerFactory emf;

    public CustomerDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void save(Customer customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Customer> getCustomers() {
        EntityManager em = emf.createEntityManager();
        List<Customer> customers = null;
        try {
            customers = em.createQuery("from Customer", Customer.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return customers;
    }

    public void delete(String customerId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Customer customer = em.find(Customer.class, customerId);
            if (customer != null) {
                User user = customer.getUser();
                UserDAO userDAO = new UserDAO("test-unit");
                userDAO.delete(user.getUserID());
                em.remove(customer);
                transaction.commit();
            }
        } catch (Exception e) { 
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Customer findById(String customerId) {
        EntityManager em = emf.createEntityManager();
        Customer customer = null;
        try {
            customer = em.find(Customer.class, customerId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return customer;
    }

    public void update(Customer customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Customer existingCustomer = em.find(Customer.class, customer.getCustomerId());
            if (existingCustomer != null) {
                existingCustomer.setCustomerName(customer.getCustomerName());
                existingCustomer.setEmail(customer.getEmail());
                existingCustomer.setPhone(customer.getPhone());
                existingCustomer.setUser(customer.getUser());
                transaction.commit();
            }
        } catch (Exception e) { 
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
