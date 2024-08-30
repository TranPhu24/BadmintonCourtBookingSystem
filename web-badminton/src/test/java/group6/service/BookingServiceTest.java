package group6.service;

import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Booking;
import group6.pojo.Customer;
import group6.repository.BookingRepository;
import group6.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private BookingService bookingService;
    private BookingRepository bookingRepository;
    private CustomerRepository customerRepository;
    private Booking booking;
    private BookingDTO bookingDTO;
    private Customer customer;

    @BeforeEach
    void setUp() {
        bookingRepository = Mockito.mock(BookingRepository.class);
        customerRepository = Mockito.mock(CustomerRepository.class);
        bookingService = new BookingService(bookingRepository, customerRepository);

        customer = new Customer();
        customer.setCustomerId("1");

        booking = new Booking();
        booking.setBookingId(1L);
        booking.setBookingType("Type 1");
        booking.setBookingDate(new Date()); // Use java.util.Date
        booking.setBookingTime(new Time(System.currentTimeMillis())); // Use java.sql.Time
        booking.setCustomer(customer);
        booking.setManagerId("1L");

        bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(1L);
        bookingDTO.setBookingType("Type 1");
        bookingDTO.setBookingDate(new Date()); // Use java.util.Date
        bookingDTO.setBookingTime(new Time(System.currentTimeMillis())); // Use java.sql.Time
        bookingDTO.setCustomerId("1L");
        bookingDTO.setManagerId("1");
    }

    @Test
    void createBooking() throws DataNotFoundException {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        bookingService.createBooking(bookingDTO);

        verify(customerRepository, times(1)).findById(1L);
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

    @Test
    void createBooking_customerNotFound() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> bookingService.createBooking(bookingDTO));

        verify(customerRepository, times(1)).findById(1L);
        verify(bookingRepository, never()).save(any(Booking.class));
    }

    @Test
    void updateBooking() throws DataNotFoundException {
        when(bookingRepository.findById("1L")).thenReturn(Optional.of(booking));
        when(customerRepository.findById("1L")).thenReturn(Optional.of(customer));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking updatedBooking = bookingService.updateBooking(1L, bookingDTO);

        assertNotNull(updatedBooking);
        assertEquals(bookingDTO.getBookingType(), updatedBooking.getBookingType());
        assertEquals(bookingDTO.getBookingDate(), updatedBooking.getBookingDate());
        assertEquals(bookingDTO.getBookingTime(), updatedBooking.getBookingTime());
        assertEquals(customer, updatedBooking.getCustomer());

        verify(bookingRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).findById("1L");
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

    @Test
    void updateBooking_notFound() {
        when(bookingRepository.findById("1L")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> bookingService.updateBooking(1L, bookingDTO));

        verify(bookingRepository, times(1)).findById(1L);
        verify(customerRepository, never()).findById(anyLong());
        verify(bookingRepository, never()).save(any(Booking.class));
    }

    @Test
    void updateBooking_customerNotFound() {
        when(bookingRepository.findById("1L")).thenReturn(Optional.of(booking));
        when(customerRepository.findById("1L")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> bookingService.updateBooking(1L, bookingDTO));

        verify(bookingRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).findById(1L);
        verify(bookingRepository, never()).save(any(Booking.class));
    }

    @Test
    void getAllBookings() {
        when(bookingRepository.findAll()).thenReturn(Arrays.asList(booking));

        List<Booking> bookings = bookingService.getAllBookings();

        assertNotNull(bookings);
        assertEquals(1, bookings.size());
        assertEquals(booking, bookings.get(0));

        verify(bookingRepository, times(1)).findAll();
    }

    @Test
    void getBooking() throws DataNotFoundException {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Booking retrievedBooking = bookingService.getBooking(1L);

        assertNotNull(retrievedBooking);
        assertEquals(booking, retrievedBooking);

        verify(bookingRepository, times(1)).findById(1L);
    }

    @Test
    void getBooking_notFound() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> bookingService.getBooking(1L));

        verify(bookingRepository, times(1)).findById(1L);
    }
}
