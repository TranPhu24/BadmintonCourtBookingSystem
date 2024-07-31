package group6.dao;

import group6.pojo.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ManagerDAO {
    private EntityManagerFactory emf;

    public ManagerDAO(String persistenceUnitName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void save(Manager manager) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(manager);
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

    public List<Manager> getManagers() {
        EntityManager em = emf.createEntityManager();
        List<Manager> managers = null;
        try {
            managers = em.createQuery("from Manager", Manager.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return managers;
    }

    public Manager findById(Long managerId) {
        EntityManager em = emf.createEntityManager();
        Manager manager = null;
        try {
            manager = em.find(Manager.class, managerId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return manager;
    }

    public void delete(Long managerId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Manager manager = em.find(Manager.class, managerId);
            if (manager != null) {
                em.remove(manager);
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

    public void update(Manager manager) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Manager m = em.find(Manager.class, manager.getManagerId());
            if (m != null) {
                m.setManagerName(manager.getManagerName());
                m.setBooking(manager.getBooking());
                m.setCourts(manager.getCourts());
                m.setSlots(manager.getSlots());
                m.setUser(manager.getUser());
                em.merge(m);
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
