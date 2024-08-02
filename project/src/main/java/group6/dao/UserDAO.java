package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.User;

public class UserDAO {

    private static EntityManagerFactory emf;

    public UserDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void save(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
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

    public List<User> getUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = null;
        try {
            users = em.createQuery("from User", User.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return users;
    }

    public void delete(String userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            User user = em.find(User.class, userId);
            em.remove(user);
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

    public User findById(String userId) {
        EntityManager em = emf.createEntityManager();
        User user = null;
        try {
            user = em.find(User.class, userId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return user;
    }

    public void update(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            User existingUser = em.find(User.class, user.getUserID());
            if (existingUser != null) {
                existingUser.setUserName(user.getUserName());
                existingUser.setPassword(user.getPassword());
                existingUser.setRole(user.getRole());
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
