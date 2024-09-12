package group6.service;

import group6.dto.CourtDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.pojo.Slot;
import group6.repository.CourtRepository;
import group6.repository.ManagerRepository;
import group6.repository.SlotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    private final CourtRepository courtRepository;
    private final SlotRepository slotRepository;

    private final ManagerRepository managerRepository;
    @Autowired
    public CourtService(CourtRepository courtRepository,ManagerRepository managerRepository,SlotRepository slotRepository) {
        this.courtRepository = courtRepository;
        this.managerRepository = managerRepository;
        this.slotRepository = slotRepository;
    }

    public Court createCourt(CourtDTO courtDTO) {
    	Manager existingManager = managerRepository.findById(courtDTO.getManagerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find manager with id " + courtDTO.getManagerId()));
    	
        Court court = new Court();
        court.setLocation(courtDTO.getLocation());
        court.setStartTime(courtDTO.getStartTime());
        court.setEndTime(courtDTO.getEndTime());
        court.setPrice(courtDTO.getPrice());
        court.setManager(existingManager);
        
        Court savedCourt = courtRepository.save(court);
        
        List<Slot> slots = slotRepository.findAll();
        for (Slot slot : slots) {
            if (slot.getStartTime().before(court.getEndTime()) && slot.getEndTime().after(court.getStartTime())) {
                slot.getCourts().add(savedCourt);
                slotRepository.update(slot);
            }
        }
        
        return savedCourt;
    }

    public List<Court> getCourts() {
        return courtRepository.findAll();
    }

    public Court findById(Long courtId) throws DataNotFoundException {
        return courtRepository.findById(courtId)
                .orElseThrow(() -> new DataNotFoundException("Court not found with id " + courtId));
    }

    public Court updateCourt(Long courtId, CourtDTO courtDTO) throws DataNotFoundException {
        Court existingCourt = courtRepository.findById(courtId)
                .orElseThrow(() -> new DataNotFoundException("Court not found with id " + courtId));

        Manager existingManager = managerRepository.findById(courtDTO.getManagerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find manager with id " + courtDTO.getManagerId()));

        existingCourt.setLocation(courtDTO.getLocation());
        existingCourt.setStartTime(courtDTO.getStartTime());
        existingCourt.setEndTime(courtDTO.getEndTime());
        existingCourt.setPrice(courtDTO.getPrice());
        existingCourt.setManager(existingManager);

        List<Slot> allSlots = slotRepository.findAll();
        for (Slot slot : allSlots) {
            if (slot.getCourts().contains(existingCourt)) {
                if (slot.getEndTime().before(existingCourt.getStartTime()) || slot.getStartTime().after(existingCourt.getEndTime())) {
                    slot.getCourts().remove(existingCourt);
                    slotRepository.update(slot);
                }
            }
        }

        for (Slot slot : allSlots) {
            if (slot.getStartTime().before(existingCourt.getEndTime()) && slot.getEndTime().after(existingCourt.getStartTime())) {
                if (!slot.getCourts().contains(existingCourt)) {
                    slot.getCourts().add(existingCourt);
                    slotRepository.update(slot);
                }
            }
        }

        return courtRepository.update(existingCourt);
    }


    public void deleteCourt(Long courtId) throws DataNotFoundException {
        Court court = courtRepository.findById(courtId)
                .orElseThrow(() -> new DataNotFoundException("Court not found with id " + courtId));
        
        List<Slot> slots = slotRepository.findAll();
        for (Slot slot : slots) {
            if (slot.getCourts().contains(court)) {
                if (slot.getStartTime().before(court.getEndTime()) && slot.getEndTime().after(court.getStartTime())) {
                    slot.getCourts().remove(court);
                    slotRepository.update(slot);
                }
            }
        }
        
        courtRepository.delete(courtId);
    }
}
