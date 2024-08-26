package group6.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import group6.dto.CustomerDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Customer;
import group6.pojo.User;
import group6.repository.CustomerRepository;
import group6.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private UserRepository userRepository;
    private Customer customer;
    private CustomerDTO customerDTO;
    private User user;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        customerService = new CustomerService(customerRepository, userRepository);

        user = new User();
        user.setUserID("1");
        user.setUserName("user1");
        user.setPassword("pass1");
        user.setRole("cus");

        customer = new Customer();
        customer.setCustomerId("1");
        customer.setCustomerName("Customer 1");
        customer.setEmail("customer@example.com");
        customer.setPhone("1234567890");
        customer.setUser(user);

        customerDTO = new CustomerDTO();
        customerDTO.setCustomerId("1");
        customerDTO.setCustomerName("Customer 1");
        customerDTO.setEmail("customer@example.com");
        customerDTO.setPhone("1234567890");
        customerDTO.setUserId("1");
    }

    @Test
    void createCustomer() throws DataNotFoundException {
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customerDTO);

        assertNotNull(createdCustomer);
        assertEquals(customer, createdCustomer);

        verify(userRepository, times(1)).findById("1");
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void createCustomer_userNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> customerService.createCustomer(customerDTO));

        verify(userRepository, times(1)).findById("1");
        verify(customerRepository, never()).save(any(Customer.class));
    }

    @Test
    void updateCustomer() throws DataNotFoundException {
        when(customerRepository.findById("1")).thenReturn(Optional.of(customer));
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer updatedCustomer = customerService.updateCustomer("1", customerDTO);

        assertNotNull(updatedCustomer);
        assertEquals(customer, updatedCustomer);

        verify(customerRepository, times(1)).findById("1");
        verify(userRepository, times(1)).findById("1");
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void updateCustomer_notFound() {
        when(customerRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> customerService.updateCustomer("1", customerDTO));

        verify(customerRepository, times(1)).findById("1");
        verify(userRepository, never()).findById(anyString());
        verify(customerRepository, never()).save(any(Customer.class));
    }

    @Test
    void updateCustomer_userNotFound() {
        when(customerRepository.findById("1")).thenReturn(Optional.of(customer));
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> customerService.updateCustomer("1", customerDTO));

        verify(customerRepository, times(1)).findById("1");
        verify(userRepository, times(1)).findById("1");
        verify(customerRepository, never()).save(any(Customer.class));
    }

    @Test
    void getAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));

        List<Customer> customers = customerService.getAllCustomers();

        assertNotNull(customers);
        assertEquals(1, customers.size());
        assertEquals(customer, customers.get(0));

        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void getCustomer() throws DataNotFoundException {
        when(customerRepository.findById("1")).thenReturn(Optional.of(customer));

        Customer retrievedCustomer = customerService.getCustomer("1");

        assertNotNull(retrievedCustomer);
        assertEquals(customer, retrievedCustomer);

        verify(customerRepository, times(1)).findById("1");
    }

    @Test
    void getCustomer_notFound() {
        when(customerRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> customerService.getCustomer("1"));

        verify(customerRepository, times(1)).findById("1");
    }
}
