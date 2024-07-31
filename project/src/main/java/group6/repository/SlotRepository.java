package group6.repository;

import java.util.List;
import group6.dao.SlotDAO;
import group6.pojo.Slot;

public class SlotRepository implements ISlotRepository {

    private SlotDAO slotDAO;

    public SlotRepository(String fileConfig) {
        slotDAO = new SlotDAO(fileConfig);
    }

    @Override
    public List<Slot> findAll() {
        return slotDAO.getSlots();
    }

    @Override
    public void save(Slot slot) {
        slotDAO.save(slot);
    }

    @Override
    public void delete(Long slotId) {
        slotDAO.delete(slotId);
    }

    @Override
    public Slot findById(Long slotId) {
        return slotDAO.findById(slotId);
    }

    @Override
    public void update(Slot slot) {
        slotDAO.update(slot);
    }
}
