package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.Manager;

public interface IManagerRepository {
	List<Manager> findAll();
	Manager save(Manager manager);
	void delete(String managerId);
	Optional<Manager> findById(String managerId);
	Manager update(Manager manager);

}
