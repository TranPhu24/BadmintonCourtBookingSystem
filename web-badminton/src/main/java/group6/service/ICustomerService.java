package group6.service;

import java.util.List;

import group6.dto.CustomerDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Customer;


public interface ICustomerService {
	Customer createCustomer(CustomerDTO customerDTO) throws DataNotFoundException;
    List<Customer> getAllCustomers();
    Customer getCustomer(String id) throws DataNotFoundException;
	Customer updateCustomer(String id, CustomerDTO customerDTO) throws DataNotFoundException;
}
