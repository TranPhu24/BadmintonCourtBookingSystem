package group6.service;

import java.util.List;

import group6.pojo.Manager;
import group6.repository.IManagerRepository;

public class ManagerService  implements IManagerService{
	private IManagerRepository iManagerRepository;
	
	  public ManagerService(IManagerRepository iManagerRepository) {
	        this.iManagerRepository = iManagerRepository;
	    }

	@Override
	public List<Manager> findAll(Manager manager) {
		// TODO Auto-generated method stub
		return iManagerRepository.findAll();
	}

	@Override
	public void save(Manager manager) {
		// TODO Auto-generated method stub
		iManagerRepository.save(manager);
		
	}

	@Override
	public void delete(String managerId) {
		// TODO Auto-generated method stub
		iManagerRepository.delete(managerId);
		
	}

	@Override
	public Manager findById(String managerId) {
		// TODO Auto-generated method stub
		return iManagerRepository.findById(managerId);
	}

	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		iManagerRepository.update(manager);
		
	}



}
