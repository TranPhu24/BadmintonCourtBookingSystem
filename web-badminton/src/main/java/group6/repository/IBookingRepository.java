package group6.repository;

import java.util.List;
import group6.pojo.Booking;

public interface IBookingRepository {
    List<Booking> findAll();
    
    void save(Booking booking);
    
    void delete(Long bookingId);
    
    Booking findById(Long bookingId);
    
    void update(Booking booking);
}
