package group6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import group6.pojo.Admin;

public class AdminDAO {

    private static EntityManagerFactory emf;

    public AdminDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void save(Admin admin) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(admin);
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

    public List<Admin> getAdmins() {
        EntityManager em = emf.createEntityManager();
        List<Admin> admins = null;
        try {
            admins = em.createQuery("from Admin", Admin.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return admins;
    }

    public void delete(String adminId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Admin admin = em.find(Admin.class, adminId);
            if (admin != null) {
                em.remove(admin);
                transaction.commit();
            } else {
                System.out.println("Admin not found with ID: " + adminId);
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

    public Admin findById(String adminId) {
        EntityManager em = emf.createEntityManager();
        Admin admin = null;
        try {
            admin = em.find(Admin.class, adminId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return admin;
    }

    public void update(Admin admin) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Admin existingAdmin = em.find(Admin.class, admin.getAdminID());
            if (existingAdmin != null) {
                existingAdmin.setAdminName(admin.getAdminName());
                existingAdmin.setUsers(admin.getUsers());
                existingAdmin.setCourt(admin.getCourt());
                em.getTransaction().commit();
            } else {
                System.out.println("Admin not found with ID: " + admin.getAdminID());
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
