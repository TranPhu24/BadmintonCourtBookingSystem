package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.CustomerDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Customer;
import group6.pojo.User;
import group6.repository.CustomerRepository;
import group6.repository.UserRepository;

@Service
public class CustomerService implements ICustomerService {
	 @Autowired
    private CustomerRepository customerRepository;
	 @Autowired
    private UserRepository userRepository;
    
	 @Autowired
	 public CustomerService(CustomerRepository customerRepository, UserRepository userRepository) {
	        this.customerRepository = customerRepository;
	        this.userRepository = userRepository;
	    }   

	@Override
    public Customer createCustomer(CustomerDTO customerDTO) throws DataNotFoundException {
        User existingUser = userRepository.findById(customerDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + customerDTO.getUserId()));
        
        Customer newCustomer = new Customer(
        	    customerDTO.getCustomerId(),      
        	    customerDTO.getCustomerName(),    
        	    customerDTO.getEmail(),           
        	    customerDTO.getPhone(),           
        	    existingUser                      
        	);
        
        return customerRepository.save(newCustomer);
    }
    
    @Override
    public Customer updateCustomer(String id, CustomerDTO customerDTO) throws DataNotFoundException {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Customer not found with id " + id));
        
        User existingUser = userRepository.findById(customerDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + customerDTO.getUserId()));
        
        existingCustomer.setCustomerName(customerDTO.getCustomerName());
        existingCustomer.setEmail(customerDTO.getEmail());
        existingCustomer.setPhone(customerDTO.getPhone());
        existingCustomer.setUser(existingUser);
        
        return customerRepository.save(existingCustomer);
    }
    
  
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer getCustomer(String id) throws DataNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Customer not found with id " + id));
    }



	

	
}
