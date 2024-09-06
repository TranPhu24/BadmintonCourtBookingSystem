package group6.service;

import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Booking;

import java.sql.Time;
import java.util.List;

public interface IBookingService {
    Booking createBooking(BookingDTO bookingDTO) throws DataNotFoundException;
    Booking updateBooking(Long id, BookingDTO bookingDTO) throws DataNotFoundException;
    List<Booking> getAllBookings();
    List<Booking> findNoPayment(String customerId);
    List<Booking> listCourtOfCustomer(String customerId);
    List<Booking> findNoDate();
    List<Booking> guestFind(String courtLocation, Time courtStartTime, Time courtEndTime, Time slotStartTime, Time slotEndTime);
    Booking getBooking(Long id) throws DataNotFoundException;

}
