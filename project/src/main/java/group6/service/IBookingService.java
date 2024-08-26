package group6.service;

import java.util.List;
import group6.pojo.Booking;

public interface IBookingService {
List<Booking> findAll();
    
    void save(Booking booking);
    
    void delete(Long bookingID);
    
    Booking findById(Long booking);
    
    void update(Booking customer);
}
