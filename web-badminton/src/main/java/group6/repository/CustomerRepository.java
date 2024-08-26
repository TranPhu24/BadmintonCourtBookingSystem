package group6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.CustomerDAO;
import group6.pojo.Customer;
@Repository
public class CustomerRepository implements ICustomerRepository {

	private CustomerDAO customerDAO;
	
	public CustomerRepository() {
		customerDAO= new CustomerDAO("test-unit");
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers() ;
	}

	@Override
    public Customer save(Customer customer) {
        // Save the customer and return the saved instance
        customerDAO.save(customer);
        return customer;
    }

	@Override
	public void delete(String customerID) {
		// TODO Auto-generated method stub
		customerDAO.delete(customerID);
	}

	@Override
    public Optional<Customer> findById(String customerID) {
        return Optional.ofNullable(customerDAO.findById(customerID));
    }

	@Override
    public Customer update(Customer customer) {
        // Update the customer and return the updated instance
        customerDAO.update(customer);
        return customer;
    }

}
