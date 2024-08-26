package group6.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import group6.dto.AdminDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Admin;
import group6.repository.AdminRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdminServiceTest {

    private AdminService adminService;
    private AdminRepository adminRepository;
    private Admin admin;
    private AdminDTO adminDTO;

    @BeforeEach
    void setUp() {
        adminRepository = Mockito.mock(AdminRepository.class);
        adminService = new AdminService(adminRepository);

        admin = new Admin();
        admin.setAdminID("1");
        admin.setAdminName("Admin 1");

        adminDTO = new AdminDTO();
        adminDTO.setAdminID("1");
        adminDTO.setAdminName("Admin 1");
    }

    @Test
    void createAdmin() {
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin createdAdmin = adminService.createAdmin(adminDTO);

        assertNotNull(createdAdmin);
        assertEquals(admin, createdAdmin);

        verify(adminRepository, times(1)).save(any(Admin.class));
    }

    @Test
    void updateAdmin() throws DataNotFoundException {
        when(adminRepository.findById("1")).thenReturn(Optional.of(admin));
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin updatedAdmin = adminService.updateAdmin("1", adminDTO);

        assertNotNull(updatedAdmin);
        assertEquals(admin, updatedAdmin);

        verify(adminRepository, times(1)).findById("1");
        verify(adminRepository, times(1)).save(any(Admin.class));
    }

    @Test
    void updateAdmin_notFound() {
        when(adminRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> adminService.updateAdmin("1", adminDTO));

        verify(adminRepository, times(1)).findById("1");
        verify(adminRepository, never()).save(any(Admin.class));
    }

    @Test
    void getAllAdmins() {
        when(adminRepository.findAll()).thenReturn(Arrays.asList(admin));

        List<Admin> admins = adminService.getAllAdmins();

        assertNotNull(admins);
        assertEquals(1, admins.size());
        assertEquals(admin, admins.get(0));

        verify(adminRepository, times(1)).findAll();
    }

    @Test
    void getAdmin() throws DataNotFoundException {
        when(adminRepository.findById("1")).thenReturn(Optional.of(admin));

        Admin retrievedAdmin = adminService.getAdmin("1");

        assertNotNull(retrievedAdmin);
        assertEquals(admin, retrievedAdmin);

        verify(adminRepository, times(1)).findById("1");
    }

    @Test
    void getAdmin_notFound() {
        when(adminRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> adminService.getAdmin("1"));

        verify(adminRepository, times(1)).findById("1");
    }
}
