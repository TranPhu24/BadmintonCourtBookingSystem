package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.Customer;

public interface ICustomerRepository {
	List<Customer> findAll();
    
    Customer save(Customer customer);
    
    void delete(String customerID);
    
    Optional<Customer> findById(String customerID);
    
    Customer update(Customer customer);
}
