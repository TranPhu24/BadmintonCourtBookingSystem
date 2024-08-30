package group6.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Booking;
import group6.pojo.Customer;
import group6.repository.BookingRepository;
import group6.repository.CustomerRepository;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createBooking(BookingDTO bookingDTO) throws DataNotFoundException {
        Customer existingCustomer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + bookingDTO.getCustomerId()));

        Booking newBooking = new Booking(
        	    bookingDTO.getBookingId(),
        	    bookingDTO.getBookingType(),
        	    bookingDTO.getBookingDate(),
        	    bookingDTO.getBookingTime(),
        	    existingCustomer,
        	    bookingDTO.getManagerId()
        	);


        bookingRepository.save(newBooking);
    }

    @Override
    public Booking updateBooking(Long id, BookingDTO bookingDTO) throws DataNotFoundException {
        Booking existingBooking = bookingRepository.findById(id);
        if (existingBooking == null) {
            throw new DataNotFoundException("Booking not found with id " + id);
        }

        Customer existingCustomer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + bookingDTO.getCustomerId()));

        existingBooking.setBookingDate(bookingDTO.getBookingDate());
        existingBooking.setBookingTime(bookingDTO.getBookingTime());
        existingBooking.setBookingType(bookingDTO.getBookingType());
        existingBooking.setCustomer(existingCustomer);

        bookingRepository.update(existingBooking);
        return existingBooking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBooking(Long id) throws DataNotFoundException {
        Booking booking = bookingRepository.findById(id);
        if (booking == null) {
            throw new DataNotFoundException("Booking not found with id " + id);
        }
        return booking;
    }
}
