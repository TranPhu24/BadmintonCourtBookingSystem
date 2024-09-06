package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.Booking;
import group6.pojo.Court;

public interface ICourtRepository {
    List<Court> findAll();
    
    Court save(Court booking);
    
    void delete(Long bookingId);
    
    Optional<Court> findById(Long bookingId);
    
    Court update(Court booking);
}