package group6.service;

import java.util.List;

import group6.pojo.Manager;

public interface IManagerService {
	List<Manager> findAll(Manager manager);
	void save(Manager manager);
	void delete(String managerId);
	Manager findById(String managerId);
	void update(Manager manager);

}
