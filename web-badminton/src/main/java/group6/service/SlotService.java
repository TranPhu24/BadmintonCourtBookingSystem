package group6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.SlotDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Slot;
import group6.pojo.Staff;
import group6.pojo.Manager;
import group6.repository.SlotRepository;
import group6.repository.StaffRepository;
import group6.repository.ManagerRepository;

@Service
public class SlotService implements ISlotService {

    private final SlotRepository slotRepository;
    private final StaffRepository staffRepository;
    private final ManagerRepository managerRepository;

    @Autowired
    public SlotService(SlotRepository slotRepository, StaffRepository staffRepository, ManagerRepository managerRepository) {
        this.slotRepository = slotRepository;
        this.staffRepository = staffRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public Slot createSlot(SlotDTO slotDTO) throws DataNotFoundException {
        // Validate Manager
        Manager existingManager = managerRepository.findById(slotDTO.getManagerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find manager with id " + slotDTO.getManagerId()));
        
        // Validate Staff
       Staff existingStaff = staffRepository.findById(slotDTO.getStaffId())
               .orElseThrow(() -> new DataNotFoundException("Cannot find staff with id " + slotDTO.getStaffId()));

        // Create and Save Slot
        Slot newSlot = new Slot(
                slotDTO.getStartTime(),
                slotDTO.getEndTime(),
                existingManager,
                null
        );
        return slotRepository.save(newSlot);
    }

    @Override
    public Slot updateSlot(Long id, SlotDTO slotDTO) throws DataNotFoundException {
        // Find existing Slot
        Slot existingSlot = slotRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Slot not found with id " + id));
        
        // Validate Manager
        Manager existingManager = managerRepository.findById(slotDTO.getManagerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find manager with id " + slotDTO.getManagerId()));

        // Validate Staff
        Staff existingStaff = staffRepository.findById(slotDTO.getStaffId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find staff with id " + slotDTO.getStaffId()));

        // Update Slot
        existingSlot.setStartTime(slotDTO.getStartTime());
        existingSlot.setEndTime(slotDTO.getEndTime());
        existingSlot.setStaff(existingStaff);
        existingSlot.setManager(existingManager);

        return slotRepository.update(existingSlot);
    }

    @Override
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @Override
    public Slot getSlot(Long id) throws DataNotFoundException {
        return slotRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Slot not found with id " + id));
    }

    @Override
    public void deleteSlot(Long id) throws DataNotFoundException {
        // Check if Slot exists before deleting
        if (!slotRepository.existsById(id)) {
            throw new DataNotFoundException("Slot not found with id " + id);
        }
        slotRepository.delete(id); 
    }
}
