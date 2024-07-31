package group6.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import group6.pojo.User;

public class UserDAO {
	   private EntityManagerFactory emf;

	    public UserDAO(String persistenceUnitName) {
	        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
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
	            System.out.println("Error saving user: " + e.getMessage());
	            e.printStackTrace(); 
	        } finally {
	            em.close();
	        }
	    }


}
