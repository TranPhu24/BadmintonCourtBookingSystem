package group6.repository;

import java.util.List;

import group6.dao.CustomerDAO;
import group6.pojo.Customer;

public class CustomerRepository implements ICustomerRepository {

	private CustomerDAO customerDAO;
	
	public CustomerRepository(String  fileConfig) {
		customerDAO= new CustomerDAO(fileConfig);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers() ;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.save(customer);
	}

	@Override
	public void delete(String customerID) {
		// TODO Auto-generated method stub
		customerDAO.delete(customerID);
	}

	@Override
	public Customer findById(String customerID) {
		// TODO Auto-generated method stub
		return customerDAO.findById(customerID);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.update(customer);
		
	}

}
