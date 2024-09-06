package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Payment;

public class PaymentDAO {

    private static EntityManagerFactory emf;

    public PaymentDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void save(Payment payment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(payment);
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

    public List<Payment> getPayments() {
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
            Payment existingPayment = em.find(Payment.class, payment.getPaymentId());
            if (existingPayment != null) {
                existingPayment.setAmount(payment.getAmount());
                existingPayment.setStatus(payment.getStatus());
                existingPayment.setPaymentDate(payment.getPaymentDate());
                existingPayment.setPaymentTime(payment.getPaymentTime());
                existingPayment.setCustomer(payment.getCustomer());
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

    public void delete(Long paymentId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Payment payment = em.find(Payment.class, paymentId);
            if (payment != null) {
                if (payment.getBooking() != null) {
                    payment.getBooking().setPayment(null);
                }
                payment.setCustomer(null);
                em.remove(payment);
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
