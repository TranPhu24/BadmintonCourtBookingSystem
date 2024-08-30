<<<<<<< HEAD
package group6.service;

import java.util.List;

import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Booking;

public interface IBookingService {
    Booking createBooking(BookingDTO bookingDTO) throws DataNotFoundException;
    List<Booking> getAllBookings();
    Booking getBooking(Long id) throws DataNotFoundException;
    Booking updateBooking(Long id, BookingDTO bookingDTO) throws DataNotFoundException;
    void deleteBooking(Long id) throws DataNotFoundException;
}
=======
package group6.service;

import java.util.List;
import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Booking;

public interface IBookingService {
    void createBooking(BookingDTO bookingDTO) throws DataNotFoundException;
    Booking updateBooking(Long id, BookingDTO bookingDTO) throws DataNotFoundException;
    List<Booking> getAllBookings();
    Booking getBooking(Long id) throws DataNotFoundException;
}
>>>>>>> a579bf0e3d3bd389fdfb2a2642ccfd9546540a24
