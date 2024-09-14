package group6.repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import group6.pojo.Slot;

public interface ISlotRepository {
    List<Slot> findAll();
    
    Slot save(Slot slot);
    
    void delete(Long slotId);
    
    Optional<Slot> findById(Long slotId);
    
    Slot update(Slot slot);
    boolean checkSlot(Time startTime, Time endTime);
}