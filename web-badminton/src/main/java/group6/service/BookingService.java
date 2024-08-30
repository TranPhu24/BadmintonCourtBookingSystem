package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Booking;
import group6.pojo.Customer;
import group6.pojo.Manager;
import group6.repository.BookingRepository;
import group6.repository.CustomerRepository;
import group6.repository.ManagerRepository;

@Service
public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final ManagerRepository managerRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository, ManagerRepository managerRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public Booking createBooking(BookingDTO bookingDTO) throws DataNotFoundException {
        Customer existingCustomer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + bookingDTO.getCustomerId()));
        
        Manager existingManager = managerRepository.findById(bookingDTO.getManagerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find manager with id " + bookingDTO.getManagerId()));
        
        Booking newBooking = new Booking(
                bookingDTO.getBookingType(),
                bookingDTO.getBookingDate(),
                bookingDTO.getBookingTime(),
                existingCustomer,
                existingManager
        );

        return bookingRepository.save(newBooking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long id) throws DataNotFoundException {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Booking not found with id " + id));
    }

    @Override
    public Booking updateBooking(Long id, BookingDTO bookingDTO) throws DataNotFoundException {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Booking not found with id " + id));
        
        Customer existingCustomer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + bookingDTO.getCustomerId()));
        
        Manager existingManager = managerRepository.findById(bookingDTO.getManagerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find manager with id " + bookingDTO.getManagerId()));
        
        existingBooking.setBookingType(bookingDTO.getBookingType());
        existingBooking.setBookingDate(bookingDTO.getBookingDate());
        existingBooking.setBookingTime(bookingDTO.getBookingTime());
        existingBooking.setCustomer(existingCustomer);
        existingBooking.setManager(existingManager);
        
        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) throws DataNotFoundException {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Booking not found with id " + id));
        
        bookingRepository.delete(id);
    }
}
