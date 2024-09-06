package group6.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import group6.dto.UserDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Admin;
import group6.pojo.User;
import group6.repository.AdminRepository;
import group6.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;
    private AdminRepository adminRepository;
    private User user;
    private UserDTO userDTO;
    private Admin admin;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        adminRepository = Mockito.mock(AdminRepository.class);
        userService = new UserService(userRepository, adminRepository);

        admin = new Admin();
        admin.setAdminId("1");
        admin.setAdminName("Admin 1");

        user = new User();
        user.setUserID("1");
        user.setUserName("User 1");
        user.setPassword("password");
        user.setRole("role");
        user.setAdmin(admin);

        userDTO = new UserDTO();
        userDTO.setUserId("1");
        userDTO.setUserName("User 1");
        userDTO.setPassword("password");
        userDTO.setRole("role");
        userDTO.setAdminId("1");
    }

    @Test
    void createUser() throws DataNotFoundException {
        when(adminRepository.findById("1")).thenReturn(Optional.of(admin));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(userDTO);

        assertNotNull(createdUser);
        assertEquals(user, createdUser);

        verify(adminRepository, times(1)).findById("1");
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void createUser_adminNotFound() {
        when(adminRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> userService.createUser(userDTO));

        verify(adminRepository, times(1)).findById("1");
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void updateUser() throws DataNotFoundException {
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(adminRepository.findById("1")).thenReturn(Optional.of(admin));
        when(userRepository.update(any(User.class))).thenReturn(user);

        User updatedUser = userService.updateUser("1", userDTO);

        assertNotNull(updatedUser);
        assertEquals(user, updatedUser);

        verify(userRepository, times(1)).findById("1");
        verify(adminRepository, times(1)).findById("1");
        verify(userRepository, times(1)).update(any(User.class));
    }

    @Test
    void updateUser_userNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> userService.updateUser("1", userDTO));

        verify(userRepository, times(1)).findById("1");
        verify(adminRepository, never()).findById(anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void updateUser_adminNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(adminRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> userService.updateUser("1", userDTO));

        verify(userRepository, times(1)).findById("1");
        verify(adminRepository, times(1)).findById("1");
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void getUser() throws DataNotFoundException {
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        User retrievedUser = userService.getUser("1");

        assertNotNull(retrievedUser);
        assertEquals(user, retrievedUser);

        verify(userRepository, times(1)).findById("1");
    }

    @Test
    void getUser_notFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> userService.getUser("1"));

        verify(userRepository, times(1)).findById("1");
    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<User> users = userService.getAllUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));

        verify(userRepository, times(1)).findAll();
    }
}
