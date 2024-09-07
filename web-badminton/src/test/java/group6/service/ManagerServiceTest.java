package group6.service;


import group6.pojo.Manager;
import group6.repository.IManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ManagerServiceTest {

    private ManagerService managerService;
    private IManagerRepository managerRepository;

    private Manager manager;

    @BeforeEach
    void setUp() {
        managerRepository = Mockito.mock(IManagerRepository.class);
        managerService = new ManagerService(managerRepository);
        
        manager = new Manager();
        manager.setManagerId("M01");
        manager.setManagerName("Phu");
        
    }

    @Test
    void findAll() {
        List<Manager> managers = Arrays.asList(manager);
        when(managerRepository.findAll()).thenReturn(managers);

        List<Manager> result = managerService.findAll(manager);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(manager, result.get(0));

        verify(managerRepository, times(1)).findAll();
    }

    @Test
    void save() {
        doNothing().when(managerRepository).save(manager);

        managerService.save(manager);

        verify(managerRepository, times(1)).save(manager);
    }

    @Test
    void delete() {
        doNothing().when(managerRepository).delete("1");

        managerService.delete("1");

        verify(managerRepository, times(1)).delete("1");
    }

    @Test
    void delete_notFound() {
        doThrow(new IllegalArgumentException("Manager not found")).when(managerRepository).delete("2");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            managerService.delete("2");
        });

        assertEquals("Manager not found", exception.getMessage());
        verify(managerRepository, times(1)).delete("2");
    }

    @Test
    void findById() {
        when(managerRepository.findById("1")).thenReturn(manager);

        Manager foundManager = managerService.findById("1");

        assertNotNull(foundManager);
        assertEquals(manager, foundManager);

        verify(managerRepository, times(1)).findById("1");
    }

    @Test
    void findById_notFound() {
        when(managerRepository.findById("2")).thenReturn(null);

        Manager foundManager = managerService.findById("2");

        assertNull(foundManager);
        verify(managerRepository, times(1)).findById("2");
    }

    @Test
    void update() {
        doNothing().when(managerRepository).update(manager);

        managerService.update(manager);

        verify(managerRepository, times(1)).update(manager);
    }

    @Test
    void update_notFound() {
        doThrow(new IllegalArgumentException("Manager not found")).when(managerRepository).update(manager);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            managerService.update(manager);
        });

        assertEquals("Manager not found", exception.getMessage());
        verify(managerRepository, times(1)).update(manager);
    }
}
>>>>>>> ffee79c192319ae4e727b4b271f73965fd51ce95
