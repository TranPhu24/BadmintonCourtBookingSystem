package group6.dao;

import java.sql.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Booking;

public class BookingDAO {

    private EntityManagerFactory emf;

    public BookingDAO(String persistenceUnitName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }
    //////////////////////////////////////////////
    public List<Booking> findNoPayment(String customerId) {
        EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            bookings = em.createQuery("SELECT b FROM Booking b WHERE b.payment IS NULL AND b.customer.customerId = :customerId", Booking.class)
                         .setParameter("customerId", customerId)
                         .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return bookings;
    }
    
    public List<Booking> listCourtOfCustomer(String customerId) {
        EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            bookings = em.createQuery(
                    "SELECT b FROM Booking b WHERE b.customer.customerId = :customerId AND b.payment IS NOT NULL", 
                    Booking.class)
                .setParameter("customerId", customerId)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return bookings;
    }

    
    public List<Booking> findNoDate() {
        EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            bookings = em.createQuery("SELECT b FROM Booking b WHERE b.bookingDate IS NULL", Booking.class)
                         .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return bookings;
    }

    public List<Booking> guestFind(String courtLocation, Time courtStartTime, Time courtEndTime, Time slotStartTime, Time slotEndTime) {
        EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            bookings = em.createQuery(
                    "SELECT b FROM Booking b WHERE b.court.location = :courtLocation " +
                    "AND b.court.startTime = :courtStartTime " +
                    "AND b.court.endTime = :courtEndTime " +
                    "AND b.slot.startTime = :slotStartTime " +
                    "AND b.slot.endTime = :slotEndTime " +
                    "ORDER BY b.bookingDate ASC", Booking.class)
                .setParameter("courtLocation", courtLocation)
                .setParameter("courtStartTime", courtStartTime)
                .setParameter("courtEndTime", courtEndTime)
                .setParameter("slotStartTime", slotStartTime)
                .setParameter("slotEndTime", slotEndTime)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

   

    
    
    
    ////////////////////////////////////////////////

    public void createBooking(Booking booking) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Booking findById(Long bookingId) {
        EntityManager em = emf.createEntityManager();
        Booking booking = null;
        try {
            booking = em.find(Booking.class, bookingId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return booking;
    }

    public List<Booking> getBookings() {
        EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            bookings = em.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return bookings;
    }

    public void updateBooking(Booking booking) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Booking existingBooking = em.find(Booking.class, booking.getBookingId());
            if (existingBooking != null) {
                existingBooking.setBookingType(booking.getBookingType());
                existingBooking.setBookingDay(booking.getBookingDay());
                existingBooking.setBookingDate(booking.getBookingDate());
                existingBooking.setCustomer(booking.getCustomer());
                existingBooking.setCourt(booking.getCourt());
                existingBooking.setSlot(booking.getSlot());
                existingBooking.setPayment(booking.getPayment());
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteBooking(Long bookingId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Booking booking = em.find(Booking.class, bookingId);
            booking.setCustomer(null);
            if (booking != null) {
                em.remove(booking);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
