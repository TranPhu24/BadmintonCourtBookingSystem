package group6.repository;

import java.util.List;

import group6.pojo.Customer;

public interface ICustomerRepository {
	List<Customer> findAll();
    
    void save(Customer customer);
    
    void delete(String customerID);
    
    Customer findById(String customerID);
    
    void update(Customer customer);
}
