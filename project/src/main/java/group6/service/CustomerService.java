package group6.service;

import java.util.List;
import group6.pojo.Customer;
import group6.repository.CustomerRepository;
import group6.repository.ICustomerRepository;

public class CustomerService implements ICustomerService{
	private ICustomerRepository iRepository;
	
	public CustomerService(String  fileName) {
		iRepository= new CustomerRepository(fileName);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return iRepository.findAll() ;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		iRepository.save(customer);
	}

	@Override
	public void delete(String customerID) {
		// TODO Auto-generated method stub
		iRepository.delete(customerID);
	}

	@Override
	public Customer findById(String costomerID) {
		// TODO Auto-generated method stub
		return iRepository.findById(costomerID);
	}

	@Override
	public void update(Customer costomer) {
		// TODO Auto-generated method stub
		iRepository.update(costomer);
		
	}
}
