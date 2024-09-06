package group6.service;

import group6.dto.CourtDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.repository.CourtRepository;
import group6.repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    private final CourtRepository courtRepository;

    private final ManagerRepository managerRepository;
    @Autowired
    public CourtService(CourtRepository courtRepository,ManagerRepository managerRepository) {
        this.courtRepository = courtRepository;
        this.managerRepository = managerRepository;
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
        
        return courtRepository.save(court);
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

        return courtRepository.update(existingCourt);
    }

    public void deleteCourt(Long courtId) throws DataNotFoundException {
        Court court = courtRepository.findById(courtId)
                .orElseThrow(() -> new DataNotFoundException("Court not found with id " + courtId));
        courtRepository.delete(courtId);
    }
}
