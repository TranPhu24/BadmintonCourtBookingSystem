package group6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.SlotDAO;
import group6.pojo.Slot;
@Repository
public class SlotRepository implements ISlotRepository {

    private SlotDAO slotDAO;

    public SlotRepository() {
        slotDAO = new SlotDAO("test-unit");
    }

    @Override
    public List<Slot> findAll() {
        return slotDAO.getSlots();
    }

    @Override
    public Slot save(Slot slot) {
        slotDAO.save(slot);
        return slot;
    }

    @Override
    public void delete(Long id) {
        slotDAO.delete(id);
    }

    @Override
    public Optional<Slot> findById(Long slotId) {
        return Optional.ofNullable(slotDAO.findById(slotId));
        
    }

    @Override
    public Slot update(Slot slot) {
        slotDAO.update(slot);
        return slot;
    }
    
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
