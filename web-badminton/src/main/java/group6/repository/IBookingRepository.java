package group6.repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import group6.pojo.Booking;

public interface IBookingRepository {
    List<Booking> findAll();
    List<Booking> findNoPayment(String customerId);
    List<Booking> listCourtOfCustomer(String customerId);
    List<Booking> findNoDate();
    List<Booking> guestFind(String courtLocation, Time courtStartTime, Time courtEndTime, Time slotStartTime, Time slotEndTime);
    
    Booking save(Booking booking);
    
    void delete(Long bookingId);
    
    Optional<Booking> findById(Long bookingId);
    
    Booking update(Booking booking);
}
