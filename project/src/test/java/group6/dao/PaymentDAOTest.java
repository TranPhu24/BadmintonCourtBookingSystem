package group6.dao;

import group6.pojo.Payment;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaymentDAOTest {

    private static EntityManagerFactory emf;
    private static PaymentDAO paymentDAO;

    @BeforeAll
    public static void setUp() {
        emf = Persistence.createEntityManagerFactory("yourPersistenceUnitName");
        paymentDAO = new PaymentDAO("yourPersistenceUnitName");
    }

    @AfterAll
    public static void tearDown() {
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    public void testSave() {
        Payment payment = new Payment();
        payment.setPaymentId("123");
        payment.setAmount(100.0);
        payment.setStatus("Paid");

        paymentDAO.save(payment);

        Payment foundPayment = paymentDAO.findById("123");
        assertNotNull(foundPayment);
        assertEquals("Customer A", foundPayment.getCustomer());
    }

    @Test
    public void testGetCPayments() {
    	Payment payment1 = new Payment();
        payment1.setPaymentId("123");
        payment1.setAmount(100.0);
        payment1.setStatus("Paid");
        
        Payment payment2 = new Payment();
        payment2.setPaymentId("124");
        payment2.setAmount(100.0);
        payment2.setStatus("UnPaid");

        paymentDAO.save(payment1);
        paymentDAO.save(payment2);
        
        List<Payment> payments = paymentDAO.getCPayments();
        assertNotNull(payments);
        assertEquals(2, payments.size());
    }

    @Test
    public void testDelete() {
    	 Payment payment = new Payment();
         payment.setPaymentId("123");
         payment.setAmount(100.0);
         payment.setStatus("Paid");

         paymentDAO.save(payment);

         paymentDAO.delete(payment.getPaymentId);
         Payment deletepayment = paymentDAO.findById("123");
         assertNull(deletepayment);
    }

    @Test
    public void testFindById() {
    	 Payment payment = new Payment();
         payment.setPaymentId("123");
         payment.setAmount(100.0);
         payment.setStatus("Paid");

         paymentDAO.save(payment);

         Payment foundPayment = paymentDAO.findById("123");
         assertNotNull(foundPayment);
         assertEquals("Customer A", foundPayment.getCustomer());
     }
    }

    @Test
    public void testUpdate() {
        Payment payment = new Payment();
        payment.setPaymentId("123");
        payment.setAmount(250.0);
        payment.setStatus("Paid");

        paymentDAO.update(payment);

        Payment updatedPayment = paymentDAO.findById("2");
        assertNotNull(updatedPayment);
        assertEquals("Customer B Updated", updatedPayment.getCustomer());
        assertEquals(250.0, updatedPayment.getAmount());
        assertEquals("Paid", updatedPayment.getStatus());
    }
}
