package group6.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import group6.dao.BookingDAO;
import group6.pojo.Booking;
@Repository
public class BookingRepository implements IBookingRepository {

    private BookingDAO bookingDAO;

    public BookingRepository() {
        bookingDAO = new BookingDAO("test-unit");
    }

    @Override
    public List<Booking> findAll() {
        return bookingDAO.getBookings();
    }

    @Override
    public void save(Booking booking) {
        bookingDAO.createBooking(booking);
    }

    @Override
    public void delete(Long bookingId) {
        bookingDAO.deleteBooking(bookingId);
    }

    @Override
    public Booking findById(Long bookingId) {
        return bookingDAO.findById(bookingId);
    }

    @Override
    public void update(Booking booking) {
        bookingDAO.updateBooking(booking);
    }

}
