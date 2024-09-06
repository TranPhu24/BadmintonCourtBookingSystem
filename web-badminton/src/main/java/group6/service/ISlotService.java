package group6.service;

import java.util.List;
import group6.dto.SlotDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Slot;

public interface ISlotService {
    Slot createSlot(SlotDTO slotDTO) throws DataNotFoundException;
    List<Slot> getAllSlots();
    Slot getSlot(Long id) throws DataNotFoundException;
    Slot updateSlot(Long id, SlotDTO slotDTO) throws DataNotFoundException;
    void deleteSlot(Long id) throws DataNotFoundException;
}