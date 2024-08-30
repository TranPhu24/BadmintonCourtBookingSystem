package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.CourtDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.pojo.Payment;
import group6.repository.CourtRepository;
import group6.repository.PaymentRepository;
import group6.repository.ManagerRepository;

@Service
public class CourtService implements ICourtService {
    @Autowired
    private CourtRepository courtRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    public CourtService(CourtRepository courtRepository, PaymentRepository paymentRepository, ManagerRepository managerRepository) {
        this.courtRepository = courtRepository;
        this.paymentRepository = paymentRepository;
        this.managerRepository = managerRepository;
    }

    // Guest: Search courts by location and operating hours
    public List<Court> searchCourts(String location, String operatingHours) {
        // This method requires the implementation of search functionality in CourtRepository or CourtDAO
        return courtRepository.findAll().stream()
                .filter(court -> court.getLocation().equalsIgnoreCase(location) &&
                        court.getStartTime().toString().equals(operatingHours.split("-")[0]) &&
                        court.getEndTime().toString().equals(operatingHours.split("-")[1]))
                .toList(); // Simple filtering based on location and operating hours
    }

    // Court Manager: Register new court
    @Override
    public Court createCourt(CourtDTO courtDTO) throws DataNotFoundException {
        // Fetch related entities
        Payment existingPayment = paymentRepository.findById(courtDTO.getPaymentId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find payment with id " + courtDTO.getPaymentId()));

        Manager existingManager = managerRepository.findById(courtDTO.getManagerId());
        if (existingManager == null) {
            throw new DataNotFoundException("Cannot find manager with id " + courtDTO.getManagerId());
        }


        // Create new court object
        Court newCourt = new Court(
                courtDTO.getLocation(),
                courtDTO.getStartTime(),
                courtDTO.getEndTime(),
                courtDTO.getPrice(),
                null, null, 
                existingManager,
                existingPayment
        );

        // Save the new court
        courtRepository.save(newCourt);
        return newCourt;
    }

    // Court Manager: Update court information
    @Override
    public Court updateCourt(Long id, CourtDTO courtDTO) throws DataNotFoundException {
        Court existingCourt = courtRepository.findById(id);
        if (existingCourt == null) {
            throw new DataNotFoundException("Court not found with id " + id);
        }

        // Fetch related entities
        Payment existingPayment = paymentRepository.findById(courtDTO.getPaymentId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find payment with id " + courtDTO.getPaymentId()));

        Manager existingManager = managerRepository.findById(courtDTO.getManagerId());
        if (existingManager == null) {
            throw new DataNotFoundException("Cannot find manager with id " + courtDTO.getManagerId());
        }


        // Update court details
        existingCourt.setLocation(courtDTO.getLocation());
        existingCourt.setStartTime(courtDTO.getStartTime());
        existingCourt.setEndTime(courtDTO.getEndTime());
        existingCourt.setPrice(courtDTO.getPrice());
        existingCourt.setPayment(existingPayment);
        existingCourt.setManager(existingManager);

        // Save updated court
        courtRepository.update(existingCourt);
        return existingCourt;
    }

    // Court Manager: Manage court information
    @Override
    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    @Override
    public Court getCourt(Long id) throws DataNotFoundException {
        Court court = courtRepository.findById(id);
        if (court == null) {
            throw new DataNotFoundException("Court not found with id " + id);
        }
        return court;
    }

    // Court Staff: Check court status
    public void checkCourtStatus(Long courtId) throws DataNotFoundException {
        Court court = courtRepository.findById(courtId);
        if (court == null) {
            throw new DataNotFoundException("Court not found with id " + courtId);
        }
        // Logic to check court status can be implemented here
    }
}
