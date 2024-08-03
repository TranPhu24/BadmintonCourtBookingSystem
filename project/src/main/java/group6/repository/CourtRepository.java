package group6.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Court;

public class CourtRepository implements ICourtRepository {

    private EntityManagerFactory emf;

    public CourtRepository(String persistenceUnitName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    @Override
    public List<Court> findAll() {
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

    @Override
    public void save(Court court) {
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

    @Override
    public void delete(Long courtId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Court court = em.find(Court.class, courtId);
            if (court != null) {
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

    @Override
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

    @Override
    public void update(Court court) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Court existingCourt = em.find(Court.class, court.getCourtId());
            if (existingCourt != null) {
                existingCourt.setLocation(court.getLocation());
                existingCourt.setOperatingHours(court.getOperatingHours());
                existingCourt.setPrice(court.getPrice());
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
