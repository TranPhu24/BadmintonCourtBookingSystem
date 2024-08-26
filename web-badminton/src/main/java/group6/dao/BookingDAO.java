package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Booking;

public class BookingDAO {
	

    private static EntityManagerFactory emf;

    public BookingDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

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
            System.out.println("Error: " + e.getMessage());
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
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return booking;
    }
    
    public List<Booking> getBookings() {
    	EntityManager em = emf.createEntityManager();
        List<Booking> bookings = null;
        try {
            bookings = em.createQuery("from Booking", Booking.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
                existingBooking.setBookingDate(booking.getBookingDate());
                existingBooking.setBookingTime(booking.getBookingTime());
                existingBooking.setCustomer(booking.getCustomer());
                existingBooking.setCourts(booking.getCourts());
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

    public void deleteBooking(Long bookingId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Booking booking = em.find(Booking.class, bookingId);
            booking.setCustomer(null);
            booking.setManager(null);
            if (booking != null) {
                em.remove(booking);
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
