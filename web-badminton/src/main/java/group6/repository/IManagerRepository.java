package group6.repository;

import java.util.List;

import group6.pojo.Manager;

public interface IManagerRepository {
	List<Manager> findAll();
	void save(Manager manager);
	void delete(String managerId);
	Manager findById(String managerId);
	void update(Manager manager);

}
