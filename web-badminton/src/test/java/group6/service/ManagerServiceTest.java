package group6.service;

import group6.dto.ManagerDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Manager;
import group6.pojo.User;
import group6.repository.ManagerRepository;
import group6.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ManagerServiceTest {

    @Mock
    private ManagerRepository managerRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ManagerService managerService;

    private ManagerDTO managerDTO;
    private Manager manager;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setUserID("U01");

        manager = new Manager();
        manager.setManagerId("M01");
        manager.setManagerName("Phu");
        manager.setUser(user);

        managerDTO = new ManagerDTO();
        managerDTO.setManagerId("M01");
        managerDTO.setManagerName("Phu");
        managerDTO.setUserId("U01");
    }

    @Test
    void createManager_success() throws DataNotFoundException {
        when(userRepository.findById("U01")).thenReturn(Optional.of(user));
        when(managerRepository.save(any(Manager.class))).thenReturn(manager);

        Manager createdManager = managerService.createManager(managerDTO);

        assertNotNull(createdManager);
        assertEquals(manager.getManagerId(), createdManager.getManagerId());
        verify(userRepository, times(1)).findById("U01");
        verify(managerRepository, times(1)).save(any(Manager.class));
    }

    @Test
    void createManager_userNotFound() {
        when(userRepository.findById("U01")).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> managerService.createManager(managerDTO));

        assertEquals("Cannot find user with id U01", exception.getMessage());
        verify(userRepository, times(1)).findById("U01");
        verify(managerRepository, never()).save(any(Manager.class));
    }

    @Test
    void getAllManagers() {
        when(managerRepository.findAll()).thenReturn(Arrays.asList(manager));

        List<Manager> managers = managerService.getAllManagers();

        assertNotNull(managers);
        assertEquals(1, managers.size());
        assertEquals(manager.getManagerId(), managers.get(0).getManagerId());
        verify(managerRepository, times(1)).findAll();
    }

    @Test
    void getManager_success() throws DataNotFoundException {
        when(managerRepository.findById("M01")).thenReturn(Optional.of(manager));

        Manager foundManager = managerService.getManager("M01");

        assertNotNull(foundManager);
        assertEquals(manager.getManagerId(), foundManager.getManagerId());
        verify(managerRepository, times(1)).findById("M01");
    }

    @Test
    void getManager_notFound() {
        when(managerRepository.findById("M01")).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> managerService.getManager("M01"));

        assertEquals("Manager not found with id M01", exception.getMessage());
        verify(managerRepository, times(1)).findById("M01");
    }

    @Test
    void updateManager_success() throws DataNotFoundException {
        when(managerRepository.findById("M01")).thenReturn(Optional.of(manager));
        when(userRepository.findById("U01")).thenReturn(Optional.of(user));
        when(managerRepository.update(any(Manager.class))).thenReturn(manager);

        Manager updatedManager = managerService.updateManager("M01", managerDTO);

        assertNotNull(updatedManager);
        assertEquals(manager.getManagerName(), updatedManager.getManagerName());
        verify(managerRepository, times(1)).findById("M01");
        verify(userRepository, times(1)).findById("U01");
        verify(managerRepository, times(1)).update(any(Manager.class));
    }

    @Test
    void updateManager_managerNotFound() {
        when(managerRepository.findById("M01")).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> managerService.updateManager("M01", managerDTO));

        assertEquals("Manager not found with id M01", exception.getMessage());
        verify(managerRepository, times(1)).findById("M01");
        verify(userRepository, never()).findById(anyString());
        verify(managerRepository, never()).save(any(Manager.class));
    }

    @Test
    void updateManager_userNotFound() {
        when(managerRepository.findById("M01")).thenReturn(Optional.of(manager));
        when(userRepository.findById("U01")).thenReturn(Optional.empty());

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> managerService.updateManager("M01", managerDTO));

        assertEquals("Cannot find user with id U01", exception.getMessage());
        verify(managerRepository, times(1)).findById("M01");
        verify(userRepository, times(1)).findById("U01");
        verify(managerRepository, never()).save(any(Manager.class));
    }

    @Test
    void deleteManager_success() throws DataNotFoundException {
        when(managerRepository.existsById("M01")).thenReturn(true);

        managerService.deleteManager("M01");

        verify(managerRepository, times(1)).existsById("M01");
        verify(managerRepository, times(1)).delete("M01");
    }

    @Test
    void deleteManager_notFound() {
        when(managerRepository.existsById("M01")).thenReturn(false);

        DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> managerService.deleteManager("M01"));

        assertEquals("Manager not found with id M01", exception.getMessage());
        verify(managerRepository, times(1)).existsById("M01");
        verify(managerRepository, never()).delete(anyString());
    }
}
