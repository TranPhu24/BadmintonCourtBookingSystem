package group6.repository;

import java.util.List;

import group6.dao.ManagerDAO;
import group6.pojo.Manager;

public class ManagerRepository implements IManagerRepository {
	private ManagerDAO managerDAO;

	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return managerDAO.getManagers();
	}

	@Override
	public void save(Manager manager) {
		// TODO Auto-generated method stub
		managerDAO.save(manager);
		
	}

	@Override
	public void delete(Long managerId) {
		// TODO Auto-generated method stub
		managerDAO.delete(managerId);
		
	}

	@Override
	public Manager findById(Long managerId) {
		// TODO Auto-generated method stub
		return managerDAO.findById(managerId);
	}

	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		managerDAO.update(manager);
		
	}

}
