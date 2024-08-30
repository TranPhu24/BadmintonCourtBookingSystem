package group6.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import group6.dto.CourtDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.pojo.Payment;
import group6.pojo.Admin;
import group6.pojo.Booking;
import group6.repository.CourtRepository;
import group6.repository.ManagerRepository;
import group6.repository.PaymentRepository;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CourtServiceTest {

    private CourtService courtService;
    private CourtRepository courtRepository;
    private PaymentRepository paymentRepository;
    private ManagerRepository managerRepository;
    private Court court;
    private CourtDTO courtDTO;
    private Payment payment;
    private Manager manager;
    private Admin admin;
    private Booking booking;

    @BeforeEach
    void setUp() {
        courtRepository = Mockito.mock(CourtRepository.class);
        paymentRepository = Mockito.mock(PaymentRepository.class);
        managerRepository = Mockito.mock(ManagerRepository.class);
        courtService = new CourtService(courtRepository, paymentRepository, managerRepository);

        payment = new Payment();
        payment.setPaymentId(1L); // Update to Long

        manager = new Manager();
        manager.setManagerId("1");

        admin = new Admin(); // Mock Admin if needed
        booking = new Booking(); // Mock Booking if needed

        court = new Court();
        court.setCourtId(1L);
        court.setLocation("Location 1");
        court.setStartTime(Time.valueOf("08:00:00"));
        court.setEndTime(Time.valueOf("10:00:00"));
        court.setPrice(100.0);
        court.setManager(manager);
        court.setPayment(payment);
        court.setAdmin(admin); // Mock if needed
        court.setBooking(booking); // Mock if needed

        courtDTO = new CourtDTO();
        courtDTO.setLocation("Location 1");
        courtDTO.setStartTime("08:00:00");
        courtDTO.setEndTime("10:00:00");
        courtDTO.setPrice(100.0);
        courtDTO.setPaymentId(1L); // Update to Long
        courtDTO.setManagerId("1");
    }

    @Test
    void createCourt() throws DataNotFoundException {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment)); // Update to Long
        when(managerRepository.findById("1")).thenReturn(manager);
        when(courtRepository.save(any(Court.class))).thenReturn(court);

        Court createdCourt = courtService.createCourt(courtDTO);

        assertNotNull(createdCourt);
        assertEquals(court, createdCourt);

        verify(paymentRepository, times(1)).findById(1L); // Update to Long
        verify(managerRepository, times(1)).findById("1");
        verify(courtRepository, times(1)).save(any(Court.class));
    }

    @Test
    void createCourt_paymentNotFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty()); // Update to Long

        assertThrows(DataNotFoundException.class, () -> courtService.createCourt(courtDTO));

        verify(paymentRepository, times(1)).findById(1L); // Update to Long
        verify(managerRepository, never()).findById(anyString());
        verify(courtRepository, never()).save(any(Court.class));
    }

    @Test
    void createCourt_managerNotFound() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment)); // Update to Long
        when(managerRepository.findById("1")).thenReturn(null);

        assertThrows(DataNotFoundException.class, () -> courtService.createCourt(courtDTO));

        verify(paymentRepository, times(1)).findById(1L); // Update to Long
        verify(managerRepository, times(1)).findById("1");
        verify(courtRepository, never()).save(any(Court.class));
    }

    @Test
    void updateCourt() throws DataNotFoundException {
        when(courtRepository.findById(1L)).thenReturn(court);
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment)); // Update to Long
        when(managerRepository.findById("1")).thenReturn(manager);
        when(courtRepository.save(any(Court.class))).thenReturn(court);

        Court updatedCourt = courtService.updateCourt(1L, courtDTO);

        assertNotNull(updatedCourt);
        assertEquals(court, updatedCourt);

        verify(courtRepository, times(1)).findById(1L);
        verify(paymentRepository, times(1)).findById(1L); // Update to Long
        verify(managerRepository, times(1)).findById("1");
        verify(courtRepository, times(1)).save(any(Court.class));
    }

    @Test
    void updateCourt_notFound() {
        when(courtRepository.findById(1L)).thenReturn(null);

        assertThrows(DataNotFoundException.class, () -> courtService.updateCourt(1L, courtDTO));

        verify(courtRepository, times(1)).findById(1L);
        verify(paymentRepository, never()).findById(anyLong()); // Update to Long
        verify(managerRepository, never()).findById(anyString());
        verify(courtRepository, never()).save(any(Court.class));
    }

    @Test
    void updateCourt_paymentNotFound() {
        when(courtRepository.findById(1L)).thenReturn(court);
        when(paymentRepository.findById(1L)).thenReturn(Optional.empty()); // Update to Long

        assertThrows(DataNotFoundException.class, () -> courtService.updateCourt(1L, courtDTO));

        verify(courtRepository, times(1)).findById(1L);
        verify(paymentRepository, times(1)).findById(1L); // Update to Long
        verify(managerRepository, never()).findById(anyString());
        verify(courtRepository, never()).save(any(Court.class));
    }

    @Test
    void updateCourt_managerNotFound() {
        when(courtRepository.findById(1L)).thenReturn(court);
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment)); // Update to Long
        when(managerRepository.findById("1")).thenReturn(null);

        assertThrows(DataNotFoundException.class, () -> courtService.updateCourt(1L, courtDTO));

        verify(courtRepository, times(1)).findById(1L);
        verify(paymentRepository, times(1)).findById(1L); // Update to Long
        verify(managerRepository, times(1)).findById("1");
        verify(courtRepository, never()).save(any(Court.class));
    }

    @Test
    void getAllCourts() {
        when(courtRepository.findAll()).thenReturn(Arrays.asList(court));

        List<Court> courts = courtService.getAllCourts();

        assertNotNull(courts);
        assertEquals(1, courts.size());
        assertEquals(court, courts.get(0));

        verify(courtRepository, times(1)).findAll();
    }

    @Test
    void getCourt() throws DataNotFoundException {
        when(courtRepository.findById(1L)).thenReturn(court);

        Court retrievedCourt = courtService.getCourt(1L);

        assertNotNull(retrievedCourt);
        assertEquals(court, retrievedCourt);

        verify(courtRepository, times(1)).findById(1L);
    }

    @Test
    void getCourt_notFound() {
        when(courtRepository.findById(1L)).thenReturn(null);

        assertThrows(DataNotFoundException.class, () -> courtService.getCourt(1L));

        verify(courtRepository, times(1)).findById(1L);
    }

    @Test
    void checkCourtStatus() throws DataNotFoundException {
        when(courtRepository.findById(1L)).thenReturn(court);

        assertDoesNotThrow(() -> courtService.checkCourtStatus(1L));

        verify(courtRepository, times(1)).findById(1L);
    }

    @Test
    void checkCourtStatus_notFound() {
        when(courtRepository.findById(1L)).thenReturn(null);

        assertThrows(DataNotFoundException.class, () -> courtService.checkCourtStatus(1L));

        verify(courtRepository, times(1)).findById(1L);
    }
}
