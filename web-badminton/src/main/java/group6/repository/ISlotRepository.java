package group6.repository;

import java.util.List;
import group6.pojo.Slot;

public interface ISlotRepository {
    List<Slot> findAll();
    
    void save(Slot slot);
    
    void delete(Long slotId);
    
    Slot findById(Long slotId);
    
    void update(Slot slot);
}
