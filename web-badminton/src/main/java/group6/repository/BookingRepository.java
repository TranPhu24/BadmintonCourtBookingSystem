package group6.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.BookingDAO;
import group6.pojo.Booking;
import group6.pojo.Customer;
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
    public List<Booking> findFight() {
    	return bookingDAO.findFight();
    }
    
    

    @Override
    public Booking save(Booking booking) {
        bookingDAO.createBooking(booking);
   
        return booking;
    }

    @Override
    public void delete(Long bookingId) {
        bookingDAO.deleteBooking(bookingId);
    }

    @Override
    public Optional<Booking> findById(Long bookingId) {
        return Optional.ofNullable(bookingDAO.findById(bookingId));
    }

    @Override
    public Booking update(Booking booking) {
        bookingDAO.updateBooking(booking);
        return booking;
    }

	@Override
	public List<Booking> findNoPayment(String customerId) {
		return bookingDAO.findNoPayment(customerId);
	}

	@Override
	public List<Booking> listCourtOfCustomer(String customerId) {
		return bookingDAO.listCourtOfCustomer(customerId);
	}

	@Override
	public List<Booking> findNoDate() {
		return bookingDAO.findNoDate();
	}

	@Override
	public List<Booking> guestFind(String courtLocation, Time courtStartTime, Time courtEndTime, Time slotStartTime,
			Time slotEndTime) {
		return bookingDAO.guestFind(courtLocation, courtStartTime, courtEndTime, slotStartTime, slotEndTime);
	}
	
	@Override
	 public boolean checkBooking(Date bookingDate, Long courtId, Long slotId) {
		 return bookingDAO.checkBooking(bookingDate,courtId,slotId);
	 }
}
