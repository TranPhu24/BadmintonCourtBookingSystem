package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.Booking;

public interface IBookingRepository {
    List<Booking> findAll();
    
    Booking save(Booking booking);
    
    void delete(Long bookingId);
    
    Optional<Booking> findById(Long bookingId);
    
    void update(Booking booking);
}
