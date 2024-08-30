package group6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.ManagerDAO;
import group6.pojo.Manager;
@Repository
public class ManagerRepository implements IManagerRepository {
	private ManagerDAO managerDAO;

	public ManagerRepository() {
		managerDAO= new ManagerDAO("test-unit");
	}
	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return managerDAO.getManagers();
	}

	@Override
	public Manager save(Manager manager) {
		// TODO Auto-generated method stub
		managerDAO.save(manager);
		return manager;
		
	}

	@Override
	public void delete(String managerId) {
		// TODO Auto-generated method stub
		managerDAO.delete(managerId);
		
	}

	@Override
	public Optional<Manager> findById(String managerId) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(managerDAO.findById(managerId));
	}

	@Override
	public Manager update(Manager manager) {
		// TODO Auto-generated method stub
		managerDAO.update(manager);
		return manager;
		
	}
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
