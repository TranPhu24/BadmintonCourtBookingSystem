package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Court;

public class CourtDAO {
    private static EntityManagerFactory emf;

    public CourtDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void registerCourt(Court Court) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(court);
            transaction.commit
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Court> getCourt() {
        EntityManager em = emf.createEntityManager();
        List<Court> courts = null;
        try {
            courts = em.createQuery("from Court", Court.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " e.getMessage());
        } finally {
            em.close();
        }
        return courts;
    }

     public Court findById(String courtId) {
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
                existingCourt.setOperatingHours(court.getOperatingHours());
                existingCourt.setAvailableTimes(court.getAvailableTimes());
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