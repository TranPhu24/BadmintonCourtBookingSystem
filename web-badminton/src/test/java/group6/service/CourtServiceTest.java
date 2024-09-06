package group6.service;

import group6.dto.CourtDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.pojo.Payment;
import group6.repository.CourtRepository;
import group6.repository.ManagerRepository;
import group6.repository.PaymentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    private ManagerRepository managerRepository;
    private PaymentRepository paymentRepository;
    private Court court;
    private CourtDTO courtDTO;
    private Manager manager;
    private Payment payment;

    @BeforeEach
    void setUp() {
        courtRepository = Mockito.mock(CourtRepository.class);
        managerRepository = Mockito.mock(ManagerRepository.class);
        paymentRepository = Mockito.mock(PaymentRepository.class);
        courtService = new CourtService(courtRepository, managerRepository);  

        manager = new Manager();
        manager.setManagerId("1");
        manager.setManagerName("Manager 1");

        payment = new Payment();
        payment.setPaymentId(1L);

        court = new Court("Location", Time.valueOf("09:00:00"), 
                          Time.valueOf("10:00:00"), 100.0f, null, manager);

        courtDTO = new CourtDTO();
        courtDTO.setManagerId("1");
        courtDTO.setLocation("Location");
        courtDTO.setStartTime(Time.valueOf("09:00:00"));
        courtDTO.setEndTime(Time.valueOf("10:00:00"));
        courtDTO.setPrice(100.0f);

        when(managerRepository.findById("1")).thenReturn(Optional.of(manager));
    }

    @Test
    void createCourt() {
        when(courtRepository.save(any(Court.class))).thenReturn(court);

        Court createdCourt = courtService.createCourt(courtDTO);

        assertNotNull(createdCourt);
        assertEquals(court.getLocation(), createdCourt.getLocation());
        assertEquals(court.getStartTime(), createdCourt.getStartTime());
        assertEquals(court.getEndTime(), createdCourt.getEndTime());
        assertEquals(court.getPrice(), createdCourt.getPrice());

        verify(courtRepository, times(1)).save(any(Court.class));
    }

    @Test
    void getCourts() {
        when(courtRepository.findAll()).thenReturn(Arrays.asList(court));

        List<Court> courts = courtService.getCourts();

        assertNotNull(courts);
        assertEquals(1, courts.size());
        assertEquals(court.getLocation(), courts.get(0).getLocation());

        verify(courtRepository, times(1)).findAll();
    }

    @Test
    void findById() throws DataNotFoundException {
        when(courtRepository.findById(1L)).thenReturn(Optional.of(court));

        Court foundCourt = courtService.findById(1L);

        assertNotNull(foundCourt);
        assertEquals(court.getLocation(), foundCourt.getLocation());

        verify(courtRepository, times(1)).findById(1L);
    }

    @Test
    void findById_notFound() {
        when(courtRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> courtService.findById(1L));

        verify(courtRepository, times(1)).findById(1L);
    }

    @Test
    void updateCourt() throws DataNotFoundException {
        when(courtRepository.findById(1L)).thenReturn(Optional.of(court));
        when(courtRepository.update(any(Court.class))).thenReturn(court);

        Court updatedCourt = courtService.updateCourt(1L, courtDTO);

        assertNotNull(updatedCourt);
        assertEquals(courtDTO.getLocation(), updatedCourt.getLocation());
        assertEquals(courtDTO.getStartTime(), updatedCourt.getStartTime());
        assertEquals(courtDTO.getEndTime(), updatedCourt.getEndTime());
        assertEquals(courtDTO.getPrice(), updatedCourt.getPrice());

        verify(courtRepository, times(1)).findById(1L);
        verify(courtRepository, times(1)).update(any(Court.class));
    }

    @Test
    void updateCourt_notFound() {
        when(courtRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> courtService.updateCourt(1L, courtDTO));

        verify(courtRepository, times(1)).findById(1L);
        verify(courtRepository, never()).save(any(Court.class));
    }

    @Test
    void deleteCourt() throws DataNotFoundException {
        when(courtRepository.findById(1L)).thenReturn(Optional.of(court));

        courtService.deleteCourt(1L);

        verify(courtRepository, times(1)).findById(1L);
    }

    @Test
    void deleteCourt_notFound() {
        when(courtRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> courtService.deleteCourt(1L));

        verify(courtRepository, times(1)).findById(1L);
    }
}
