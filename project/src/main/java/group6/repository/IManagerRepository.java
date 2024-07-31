package group6.repository;

import java.util.List;

import group6.pojo.Manager;

public interface IManagerRepository {
	List<Manager> findAll();
	void save(Manager manager);
	void delete(Long managerId);
	Manager findById(Long managerId);
	void update(Manager manager);

}
