package group6.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.SlotDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Slot;
import group6.pojo.Staff;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.repository.SlotRepository;
import group6.repository.StaffRepository;
import group6.repository.CourtRepository;
import group6.repository.ManagerRepository;

@Service
public class SlotService implements ISlotService {

    private final SlotRepository slotRepository;
    private final StaffRepository staffRepository;
    private final ManagerRepository managerRepository;
    private final CourtRepository  courtRepository;

    @Autowired
    public SlotService(SlotRepository slotRepository, StaffRepository staffRepository, ManagerRepository managerRepository,CourtRepository  courtRepository) {
        this.slotRepository = slotRepository;
        this.staffRepository = staffRepository;
        this.managerRepository = managerRepository;
        this.courtRepository = courtRepository;
    }

    @Override
    public Slot createSlot(SlotDTO slotDTO) throws DataNotFoundException {
        // Validate Manager
        Manager existingManager = managerRepository.findById(slotDTO.getManagerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find manager with id " + slotDTO.getManagerId()));
        
//        // Validate Staff
//       Staff existingStaff = staffRepository.findById(slotDTO.getStaffId())
//               .orElseThrow(() -> new DataNotFoundException("Cannot find staff with id " + slotDTO.getStaffId()));

        // Create and Save Slot
        List<Court> courts = courtRepository.findCourtsByTime(slotDTO.getStartTime(), slotDTO.getEndTime());
        Slot newSlot = new Slot(
                slotDTO.getStartTime(),
                slotDTO.getEndTime(),
                existingManager,
                null
        );
        newSlot.setCourts(new HashSet<>(courts));
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
//        Staff existingStaff = staffRepository.findById(slotDTO.getStaffId())
//                .orElseThrow(() -> new DataNotFoundException("Cannot find staff with id " + slotDTO.getStaffId()));

        // Update Slot
        existingSlot.setStartTime(slotDTO.getStartTime());
        existingSlot.setEndTime(slotDTO.getEndTime());
        existingSlot.setStaff(null);
        existingSlot.setManager(existingManager);
        
        List<Court> courts = courtRepository.findCourtsByTime(slotDTO.getStartTime(), slotDTO.getEndTime());
        existingSlot.setCourts(new HashSet<>(courts));

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

    @Transactional
    public void deleteSlot(Long id) throws DataNotFoundException {
    	Slot slot = slotRepository.findById(id)
    	        .orElseThrow(() -> new DataNotFoundException("Slot not found with id " + id));

    	Hibernate.initialize(slot.getCourts());
        for (Court court : slot.getCourts()) {
            court.getSlots().remove(slot);
            courtRepository.update(court);
        }
        slotRepository.delete(id); 
    }
}
