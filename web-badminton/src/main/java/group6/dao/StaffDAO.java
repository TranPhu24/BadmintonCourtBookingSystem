package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Staff;
import group6.pojo.User;

public class StaffDAO {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public StaffDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void save(Staff Staff) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(Staff);
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

    public List<Staff> getStaffs() {
        EntityManager em = emf.createEntityManager();
        List<Staff> staffs = null;
        try {
        	staffs = em.createQuery("from Staff", Staff.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return staffs;
    }

    public void delete(String staffId) {
    	EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Staff staff = em.find(Staff.class, staffId);
            User user = staff.getUser();
       	    UserDAO userDAO = new UserDAO("test-unit") ;
       	    userDAO.delete(user.getUserID());
	       	 if (staff != null) {
	            em.remove(staff);
	       	 }
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

    public Staff findById(String staffId) {
        EntityManager em = emf.createEntityManager();
        Staff staff = null;
        try {
        	staff = em.find(Staff.class, staffId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return staff;
    }

    public void update(Staff staff) {
    	EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Staff nember = em.find(Staff.class, staff.getStaffId());
        	if(nember!=null) {
        		nember.setStaffName(staff.getStaffName());
        		nember.setUser(staff.getUser());
        		nember.setSlots(staff.getSlots());
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
