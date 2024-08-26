package group6.dao;

import group6.pojo.Payment;
import group6.pojo.Customer;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static PaymentDAO paymentDAO;
    private static CustomerDAO customerDAO;
    private static List<Payment> payments;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("test-unit");
        em = emf.createEntityManager();
        paymentDAO = new PaymentDAO("test-unit");
        customerDAO = new CustomerDAO("test-unit");

        Customer customer1 = new Customer("123", "Customer A", "@customerA", "0903");
        Customer customer2 = new Customer("124", "Customer B", "@customerB", "0904");

        customerDAO.save(customer1);
        customerDAO.save(customer2);

        Payment payment = new Payment(100.0f, "cus1", customer1);
        Payment payment2 = new Payment(200.0f, "cus2", customer2);
        paymentDAO.save(payment);
        paymentDAO.save(payment2);
        
        payments = paymentDAO.getCPayments();
    }

    @AfterEach
    void tearDown() {

        if (payments != null && !payments.isEmpty()) {
            for (Payment p : payments) {
                paymentDAO.delete(p.getPaymentId());
            }
        }
        em.close();
        emf.close();
    }

    @Test
    void testSaveAndFindAndGetPayments() {
        assertNotNull(payments);
        assertEquals(2, payments.size());
        assertNotNull(payments.get(0));
        assertNotNull(payments.get(1));
    }

    @Test
    void testUpdate() {
        payments.get(0).setAmount(2050.0f);
        payments.get(0).setStatus("paymentUpdate");
        paymentDAO.update(payments.get(0));

        Payment updatedPayment = em.find(Payment.class, payments.get(0).getPaymentId());
        assertNotNull(updatedPayment);
        assertEquals(2050.0f, updatedPayment.getAmount());
        assertEquals("paymentUpdate", updatedPayment.getStatus());
    }
    /*
    @Test
    void testDelete() {
        paymentDAO.delete(payments.get(1).getPaymentId());
        Payment deletedPayment2 = em.find(Payment.class, payments.get(1).getPaymentId());
        assertNull(deletedPayment2);
    }
    */
}
