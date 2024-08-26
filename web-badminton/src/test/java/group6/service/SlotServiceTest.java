package group6.service;

import group6.pojo.Slot;
import group6.repository.ISlotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SlotServiceTest {

    private SlotService slotService;
    private ISlotRepository slotRepository;
    private Slot slot;

    @BeforeEach
    void setUp() {
        slotRepository = Mockito.mock(ISlotRepository.class);
        slotService = new SlotService(slotRepository);

        // Initialize a sample Slot to use in tests
        slot = new Slot();
        slot.setSlotId(1L);
        slot.setStartTime(LocalDateTime.of(2024, 8, 24, 8, 0));  
        slot.setEndTime(LocalDateTime.of(2024, 8, 24, 10, 0));    
    }

    @Test
    void findAll() {
        List<Slot> slots = Arrays.asList(slot);
        when(slotRepository.findAll()).thenReturn(slots);

        List<Slot> result = slotService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(slot, result.get(0));

        verify(slotRepository, times(1)).findAll();
    }

    @Test
    void save() {
        doNothing().when(slotRepository).save(slot);

        slotService.save(slot);

        verify(slotRepository, times(1)).save(slot);
    }

    @Test
    void delete() {
        doNothing().when(slotRepository).delete(1L);

        slotService.delete(1L);

        verify(slotRepository, times(1)).delete(1L);
    }

    @Test
    void findbyId() {
        when(slotRepository.findById(1L)).thenReturn(slot);

        Slot foundSlot = slotService.findbyId(1L);

        // Check the result
        assertNotNull(foundSlot);
        assertEquals(slot, foundSlot);

        verify(slotRepository, times(1)).findById(1L);
    }

    @Test
    void findbyId_notFound() {
        when(slotRepository.findById(2L)).thenReturn(null);

        Slot foundSlot = slotService.findbyId(2L);

        assertNull(foundSlot);

        verify(slotRepository, times(1)).findById(2L);
    }

    @Test
    void update() {
        doNothing().when(slotRepository).update(slot);

        slotService.update(slot);

        verify(slotRepository, times(1)).update(slot);
    }
}
