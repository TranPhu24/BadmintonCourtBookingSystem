package group6.dao;

import java.sql.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import group6.pojo.Booking;
import group6.pojo.Court;

public class CourtDAO {

    private static EntityManagerFactory emf;

    public CourtDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }


    public List<Court> findCourtsByTime(Time startTime, Time endTime) {
    	EntityManager em = emf.createEntityManager();
        List<Court> courts = null;
        try {
            courts = em.createQuery("SELECT c FROM Court c WHERE c.startTime <= :startTime AND c.endTime >= :endTime", Court.class)
                    .setParameter("startTime", startTime)
                    .setParameter("endTime", endTime)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return courts;
    }

    
    public void createCourt(Court court) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(court);
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

    public List<Court> getCourts() {
        EntityManager em = emf.createEntityManager();
        List<Court> courts = null;
        try {
            courts = em.createQuery("from Court", Court.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return courts;
    }

    public Court findById(Long courtId) {
        EntityManager em = emf.createEntityManager();
        Court court = null;
        try {
            court = em.find(Court.class, courtId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return court;
    }

    public void updateCourt(Court court) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Court existingCourt = em.find(Court.class, court.getCourtId());
            if (existingCourt != null) {
                existingCourt.setLocation(court.getLocation());
                existingCourt.setStartTime(court.getStartTime());
                existingCourt.setEndTime(court.getEndTime());
                existingCourt.setPrice(court.getPrice());
                existingCourt.setAdmin(court.getAdmin());
                existingCourt.setManager(court.getManager());
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

    public void deleteCourt(Long courtId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Court court = em.find(Court.class, courtId);
            
            if (court != null) {
            	
            	List<Booking> bookings = em.createQuery("SELECT b FROM Booking b WHERE b.court.courtId = :courtId", Booking.class)
                        .setParameter("courtId", courtId)
                        .getResultList();
				for (Booking booking : bookings) {
				 booking.setCourt(null);
				 em.merge(booking);
				}
            	
                court.setManager(null);
                court.setAdmin(null);
                em.remove(court);
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
