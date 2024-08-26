package group6.service;

import group6.dto.StaffDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Staff;
import group6.pojo.User;
import group6.repository.StaffRepository;
import group6.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StaffServiceTest {

    private StaffService staffService;
    private StaffRepository staffRepository;
    private UserRepository userRepository;
    private Staff staff;
    private StaffDTO staffDTO;
    private User user;

    @BeforeEach
    void setUp() {
        staffRepository = Mockito.mock(StaffRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        staffService = new StaffService(staffRepository, userRepository);

        user = new User();
        user.setUserID("1");
        user.setUserName("user1");
        user.setPassword("pass1");
        user.setRole("staff");

        staff = new Staff();
        staff.setStaffId("1");
        staff.setStaffName("Staff 1");
        staff.setUser(user);

        staffDTO = new StaffDTO();
        staffDTO.setStaffId("1");
        staffDTO.setStaffName("Staff 1");
        staffDTO.setUserId("1");
    }

    @Test
    void createStaff() throws DataNotFoundException {
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff createdStaff = staffService.createStaff(staffDTO);

        assertNotNull(createdStaff);
        assertEquals(staff, createdStaff);

        verify(userRepository, times(1)).findById("1");
        verify(staffRepository, times(1)).save(any(Staff.class));
    }

    @Test
    void createStaff_userNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> staffService.createStaff(staffDTO));

        verify(userRepository, times(1)).findById("1");
        verify(staffRepository, never()).save(any(Staff.class));
    }

    @Test
    void updateStaff() throws DataNotFoundException {
        when(staffRepository.findById("1")).thenReturn(Optional.of(staff));
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(staffRepository.save(any(Staff.class))).thenReturn(staff);

        Staff updatedStaff = staffService.updateStaff("1", staffDTO);

        assertNotNull(updatedStaff);
        assertEquals(staff, updatedStaff);

        verify(staffRepository, times(1)).findById("1");
        verify(userRepository, times(1)).findById("1");
        verify(staffRepository, times(1)).save(any(Staff.class));
    }

    @Test
    void updateStaff_notFound() {
        when(staffRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> staffService.updateStaff("1", staffDTO));

        verify(staffRepository, times(1)).findById("1");
        verify(userRepository, never()).findById(anyString());
        verify(staffRepository, never()).save(any(Staff.class));
    }

    @Test
    void updateStaff_userNotFound() {
        when(staffRepository.findById("1")).thenReturn(Optional.of(staff));
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> staffService.updateStaff("1", staffDTO));

        verify(staffRepository, times(1)).findById("1");
        verify(userRepository, times(1)).findById("1");
        verify(staffRepository, never()).save(any(Staff.class));
    }

    @Test
    void getAllStaffs() {
        when(staffRepository.findAll()).thenReturn(Arrays.asList(staff));

        List<Staff> staffs = staffService.getAllStaffs();

        assertNotNull(staffs);
        assertEquals(1, staffs.size());
        assertEquals(staff, staffs.get(0));

        verify(staffRepository, times(1)).findAll();
    }

    @Test
    void getStaff() throws DataNotFoundException {
        when(staffRepository.findById("1")).thenReturn(Optional.of(staff));

        Staff retrievedStaff = staffService.getStaff("1");

        assertNotNull(retrievedStaff);
        assertEquals(staff, retrievedStaff);

        verify(staffRepository, times(1)).findById("1");
    }

    @Test
    void getStaff_notFound() {
        when(staffRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> staffService.getStaff("1"));

        verify(staffRepository, times(1)).findById("1");
    }
}
