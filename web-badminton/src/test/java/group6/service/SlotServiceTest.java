package group6.service;

import group6.dto.SlotDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Slot;
import group6.pojo.Staff;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.repository.SlotRepository;
import group6.repository.StaffRepository;
import group6.repository.CourtRepository;
import group6.repository.ManagerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SlotServiceTest {

    @Mock
    private SlotRepository slotRepository;

    @Mock
    private StaffRepository staffRepository;

    @Mock
    private ManagerRepository managerRepository;
    
    @Mock
    private CourtRepository courtRepository;

    @InjectMocks
    private SlotService slotService;

    private SlotDTO slotDTO;
    private Slot slot;
    private Staff staff;
    private Manager manager;
    private List<Court> courts;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        staff = new Staff();
        staff.setStaffId("S001");

        manager = new Manager();
        manager.setManagerId("M001");

        slot = new Slot();
        slot.setSlotId(1L);
        slot.setStartTime(Time.valueOf("09:00:00"));
        slot.setEndTime(Time.valueOf("11:00:00"));
        slot.setStaff(staff);
        slot.setManager(manager);

        slotDTO = new SlotDTO();
        slotDTO.setStartTime(Time.valueOf("09:00:00"));
        slotDTO.setEndTime(Time.valueOf("11:00:00"));
        slotDTO.setStaffId("S001");
        slotDTO.setManagerId("M001");
        courts = List.of(new Court("Court 1", Time.valueOf("08:00:00"), Time.valueOf("10:00:00"), 100.0f, null, manager));

    }

    @Test
    void createSlot_success() throws DataNotFoundException {
        when(managerRepository.findById("M001")).thenReturn(Optional.of(manager));
//        when(staffRepository.findById("S001")).thenReturn(Optional.of(staff));
        when(slotRepository.save(any(Slot.class))).thenReturn(slot);

        Slot createdSlot = slotService.createSlot(slotDTO);

        assertNotNull(createdSlot);
        assertEquals(slot.getSlotId(), createdSlot.getSlotId());
        assertEquals(slot.getStartTime(), createdSlot.getStartTime());
        assertEquals(slot.getEndTime(), createdSlot.getEndTime());
        verify(managerRepository, times(1)).findById("M001");
  //      verify(staffRepository, times(1)).findById(anyString());
        verify(slotRepository, times(1)).save(any(Slot.class));
    }

    @Test
    void createSlot_managerNotFound() {
        when(managerRepository.findById("M001")).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> slotService.createSlot(slotDTO));

        assertEquals("Cannot find manager with id M001", exception.getMessage());
        verify(managerRepository, times(1)).findById("M001");
        verify(staffRepository, never()).findById(anyString());
        verify(slotRepository, never()).save(any(Slot.class));
    }



    @Test
    void updateSlot_success() throws DataNotFoundException {
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));
        when(managerRepository.findById("M001")).thenReturn(Optional.of(manager));
        when(staffRepository.findById("S001")).thenReturn(Optional.of(staff));
        when(slotRepository.update(any(Slot.class))).thenReturn(slot);

        Slot updatedSlot = slotService.updateSlot(1L, slotDTO);

        assertNotNull(updatedSlot);
        assertEquals(slot.getSlotId(), updatedSlot.getSlotId());
        assertEquals(slot.getStartTime(), updatedSlot.getStartTime());
        assertEquals(slot.getEndTime(), updatedSlot.getEndTime());
        verify(slotRepository, times(1)).findById(1L);
        verify(managerRepository, times(1)).findById("M001");
//        verify(staffRepository, times(1)).findById("S001");
        verify(slotRepository, times(1)).update(any(Slot.class));
    }

    @Test
    void updateSlot_NotFound() {
        when(slotRepository.findById(1L)).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> slotService.updateSlot(1L, slotDTO));

        assertEquals("Slot not found with id 1", exception.getMessage());
        verify(slotRepository, times(1)).findById(1L);
        verify(managerRepository, never()).findById(anyString());
        verify(staffRepository, never()).findById(anyString());
        verify(slotRepository, never()).update(any(Slot.class));
    }

    @Test
    void updateSlot_managerNotFound() {
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));
        when(managerRepository.findById("M001")).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> slotService.updateSlot(1L, slotDTO));

        assertEquals("Cannot find manager with id M001", exception.getMessage());
        verify(slotRepository, times(1)).findById(1L);
        verify(managerRepository, times(1)).findById("M001");
        verify(staffRepository, never()).findById(anyString());
        verify(slotRepository, never()).update(any(Slot.class));
    }


    @Test
    void getAllSlots() {
        when(slotRepository.findAll()).thenReturn(Arrays.asList(slot));

        List<Slot> slots = slotService.getAllSlots();

        assertNotNull(slots);
        assertEquals(1, slots.size());
        assertEquals(slot.getSlotId(), slots.get(0).getSlotId());
        verify(slotRepository, times(1)).findAll();
    }

    @Test
    void getSlot_success() throws DataNotFoundException {
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));

        Slot foundSlot = slotService.getSlot(1L);

        assertNotNull(foundSlot);
        assertEquals(slot.getSlotId(), foundSlot.getSlotId());
        assertEquals(slot.getStartTime(), foundSlot.getStartTime());
        assertEquals(slot.getEndTime(), foundSlot.getEndTime());
        verify(slotRepository, times(1)).findById(1L);
    }

    @Test
    void getSlot_notFound() {
        when(slotRepository.findById(1L)).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> slotService.getSlot(1L));

        assertEquals("Slot not found with id 1", exception.getMessage());
        verify(slotRepository, times(1)).findById(1L);
    }

    @Test
    void deleteSlot_success() throws DataNotFoundException {
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));

        slotService.deleteSlot(1L);

        verify(slotRepository, times(1)).delete(1L);
    }

    @Test
    void deleteSlot_notFound() {
        when(slotRepository.existsById(1L)).thenReturn(false);

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> slotService.deleteSlot(1L));

        assertEquals("Slot not found with id 1", exception.getMessage());
        verify(slotRepository, never()).delete(anyLong());
    }
}

    @Test
    void checkSlot_available() {
        Time startTime = Time.valueOf("09:00:00");
        Time endTime = Time.valueOf("11:00:00");
        
        when(slotRepository.checkSlot(startTime, endTime)).thenReturn(true); 

        boolean isAvailable = slotService.checkSlot(startTime, endTime);

        assertTrue(isAvailable);
        verify(slotRepository, times(1)).checkSlot(startTime, endTime);
    }

    @Test
    void checkSlot_notAvailable() {
        Time startTime = Time.valueOf("09:00:00");
        Time endTime = Time.valueOf("11:00:00");
        
        when(slotRepository.checkSlot(startTime, endTime)).thenReturn(false); 

        boolean isAvailable = slotService.checkSlot(startTime, endTime);

        assertFalse(isAvailable);
        verify(slotRepository, times(1)).checkSlot(startTime, endTime);
    }

