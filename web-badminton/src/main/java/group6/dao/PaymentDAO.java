package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import group6.pojo.Customer;
import group6.pojo.Payment;

public class PaymentDAO {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public PaymentDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void save(Payment Payment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(Payment);
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

    public List<Payment> getCPayments() {
        EntityManager em = emf.createEntityManager();
        List<Payment> payments = null;
        try {
        	payments = em.createQuery("from Payment", Payment.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return payments;
    }

    public void delete(Long paymentId) {
    	EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Payment payment = em.find(Payment.class, paymentId);
            payment.setCustomer(null);
            if (payment != null) {
                em.remove(payment);
            }
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

    public Payment findById(Long paymentId) {
        EntityManager em = emf.createEntityManager();
        Payment payment = null;
        try {
        	payment = em.find(Payment.class, paymentId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return payment;
    }

    public void update(Payment payment) {
    	EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Payment Pay = em.find(Payment.class, payment.getPaymentId());
        	if(Pay!=null) {
        		Pay.setPaymentId(payment.getPaymentId());
        		Pay.setCustomer(payment.getCustomer());
        		Pay.setCourts(payment.getCourts());
        		Pay.setAmount(payment.getAmount());
        		Pay.setStatus(payment.getStatus());
        		em.getTransaction().commit();
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
