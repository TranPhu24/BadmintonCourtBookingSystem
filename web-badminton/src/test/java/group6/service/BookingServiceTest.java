package group6.service;

import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.*;
import group6.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository UserRepository;

    @Mock
    private CourtRepository courtRepository;

    @Mock
    private SlotRepository slotRepository;

    @Mock
    private PaymentRepository paymentRepository;

    private Booking booking;
    private BookingDTO bookingDTO;
    private User User;
    private Court court;
    private Slot slot;
    private Payment payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  
        
        User = new User();
        User.setUserID("C001");

        court = new Court();
        court.setCourtId(1L);

        slot = new Slot();
        slot.setSlotId(1L);

        payment = new Payment();
        payment.setPaymentId(1L);

        booking = new Booking();
        booking.setBookingId(1L);
        booking.setUser(User);
        booking.setCourt(court);
        booking.setSlot(slot);
        booking.setPayment(payment);

        bookingDTO = new BookingDTO();
        bookingDTO.setBookingType("Type1");
        bookingDTO.setBookingDay("Monday");
        bookingDTO.setBookingDate(Date.valueOf("2024-09-01"));
        bookingDTO.setUserId("C001");
        bookingDTO.setCourtId(1L);
        bookingDTO.setSlotId(1L);
        bookingDTO.setPaymentId(1L);
    }

    @Test
    void createBooking_success() throws DataNotFoundException {
        when(UserRepository.findById("C001")).thenReturn(Optional.of(User));
        when(courtRepository.findById(1L)).thenReturn(Optional.of(court));
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));
//        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking createdBooking = bookingService.createBooking(bookingDTO);

        assertNotNull(createdBooking);
        assertEquals(booking, createdBooking);

        verify(UserRepository, times(1)).findById("C001");
        verify(courtRepository, times(1)).findById(1L);
        verify(slotRepository, times(1)).findById(1L);
//        verify(paymentRepository, times(1)).findById(1L);
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

    @Test
    void createBooking_UserNotFound() {
        when(UserRepository.findById("C001")).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, 
            () -> bookingService.createBooking(bookingDTO));


        verify(UserRepository, times(1)).findById("C001");
        verify(courtRepository, never()).findById(anyLong());
        verify(slotRepository, never()).findById(anyLong());
        verify(paymentRepository, never()).findById(anyLong());
        verify(bookingRepository, never()).save(any(Booking.class));
    }
    
    @Test
    void createBooking_courtNotFound() {
        when(UserRepository.findById("C001")).thenReturn(Optional.of(User));
        when(courtRepository.findById(1L)).thenReturn(Optional.empty());  // Court not found

        DataNotFoundException exception = assertThrows(DataNotFoundException.class,
                () -> bookingService.createBooking(bookingDTO));
        
        verify(UserRepository, times(1)).findById("C001");
        verify(courtRepository, times(1)).findById(1L);
        verify(slotRepository, never()).findById(any());  
        verify(paymentRepository, never()).findById(any());  
        verify(bookingRepository, never()).save(any(Booking.class));  
    }


    @Test
    void createBooking_slotNotFound() {
        when(UserRepository.findById("C001")).thenReturn(Optional.of(User));
        when(courtRepository.findById(1L)).thenReturn(Optional.of(court));
        when(slotRepository.findById(1L)).thenReturn(Optional.empty());  // Slot not found

        DataNotFoundException exception = assertThrows(DataNotFoundException.class,
                () -> bookingService.createBooking(bookingDTO));
        
        verify(UserRepository, times(1)).findById("C001");
        verify(courtRepository, times(1)).findById(1L);
        verify(slotRepository, times(1)).findById(1L);
        verify(paymentRepository, never()).findById(any());  // Payment check should not be reached
        verify(bookingRepository, never()).save(any(Booking.class));  // No save should happen
    }




    @Test
    void updateBooking_success() throws DataNotFoundException {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(UserRepository.findById("C001")).thenReturn(Optional.of(User));
        when(courtRepository.findById(1L)).thenReturn(Optional.of(court));
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(bookingRepository.update(any(Booking.class))).thenReturn(booking);

        Booking updatedBooking = bookingService.updateBooking(1L, bookingDTO);

        assertNotNull(updatedBooking);
        assertEquals(booking, updatedBooking);

        verify(bookingRepository, times(1)).findById(1L);
        verify(UserRepository, times(1)).findById("C001");
        verify(courtRepository, times(1)).findById(1L);
        verify(slotRepository, times(1)).findById(1L);
        verify(paymentRepository, times(1)).findById(1L);
        verify(bookingRepository, times(1)).update(any(Booking.class));
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
    void getBooking_success() throws DataNotFoundException {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Booking retrievedBooking = bookingService.getBooking(1L);

        assertNotNull(retrievedBooking);
        assertEquals(booking, retrievedBooking);

        verify(bookingRepository, times(1)).findById(1L);
    }

    @Test
    void getBooking_notFound() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, 
            () -> bookingService.getBooking(1L));

//        assertEquals("Booking not found", exception.getMessage());

        verify(bookingRepository, times(1)).findById(1L);
    }

    @Test
    void updateBooking_notFound() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, 
            () -> bookingService.updateBooking(1L, bookingDTO));

//        assertEquals("Booking not found", exception.getMessage());

        verify(bookingRepository, times(1)).findById(1L);
        verify(UserRepository, never()).findById(anyString());
        verify(courtRepository, never()).findById(anyLong());
        verify(slotRepository, never()).findById(anyLong());
        verify(paymentRepository, never()).findById(anyLong());
        verify(bookingRepository, never()).save(any(Booking.class));
    }
    
    @Test
    public void CheckBooking_Available() {
        Date bookingDate=Date.valueOf("2023-09-14");
        Long courtId = 1L;
        Long slotId = 1L;

        when(bookingRepository.checkBooking(bookingDate, courtId, slotId)).thenReturn(true);

        boolean isBooked = bookingService.checkBooking(bookingDate, courtId, slotId);

        assertTrue(isBooked);  
        verify(bookingRepository, times(1)).checkBooking(bookingDate, courtId, slotId); }

    @Test
    public void CheckBooking_NotAvailable() {
        Date bookingDate=Date.valueOf("2023-09-14");
        Long courtId = 2L;
        Long slotId = 2L;

        when(bookingRepository.checkBooking(bookingDate, courtId, slotId)).thenReturn(false);

        boolean isBooked = bookingService.checkBooking(bookingDate, courtId, slotId);

        assertFalse(isBooked); 
        verify(bookingRepository, times(1)).checkBooking(bookingDate, courtId, slotId);  
    }


}
