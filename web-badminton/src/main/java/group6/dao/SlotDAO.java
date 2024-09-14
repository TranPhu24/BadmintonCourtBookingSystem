package group6.dao;

import group6.pojo.Booking;
import group6.pojo.Slot;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.sql.Time;
import java.util.List;

public class SlotDAO {
	private static EntityManager em ;

    private static EntityManagerFactory emf;

    public SlotDAO(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }
    
    public boolean checkSlot(Time startTime, Time endTime) {
        EntityManager em = emf.createEntityManager();
        boolean check = false;
        try {
            Long count = em.createQuery("SELECT COUNT(s) FROM Slot s WHERE s.startTime = :startTime AND s.endTime = :endTime", Long.class)
                    .setParameter("startTime", startTime)
                    .setParameter("endTime", endTime)
                    .getSingleResult();
            check = count > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return check;
    }

    public void save(Slot slot) {
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(slot);
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

    public List<Slot> getSlots() {
        em = emf.createEntityManager();
        List<Slot> slots = null;
        try {
            slots = em.createQuery("from Slot", Slot.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return slots;
    }

    public Slot findById(Long slotId) {
        em = emf.createEntityManager();
        Slot slot = null;
        try {
            slot = em.find(Slot.class, slotId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return slot;
    }

    public void delete(Long slotId) {
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Slot slot = em.find(Slot.class, slotId);
            slot.setManager(null);
            slot.setStaff(null);
            if (slot != null) {
            	List<Booking> bookings = em.createQuery("SELECT b FROM Booking b WHERE b.slot.slotId = :slotId", Booking.class)
                        .setParameter("slotId", slotId)
                        .getResultList();
				for (Booking booking : bookings) {
				 booking.setSlot(null);
				 em.merge(booking);
				}
            	
            	
                em.remove(slot);
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

    public void update(Slot slot) {
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Slot s = em.find(Slot.class, slot.getSlotId());
            if (s != null) {
                s.setStartTime(slot.getStartTime());
                s.setEndTime(slot.getEndTime());
                s.setStaff(slot.getStaff());
                s.setManager(slot.getManager());
                s.setCourts(slot.getCourts());
                em.merge(s);
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