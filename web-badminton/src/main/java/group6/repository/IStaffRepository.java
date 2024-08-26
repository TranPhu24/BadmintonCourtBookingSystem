package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.Staff;

public interface IStaffRepository {
	List<Staff> findAll();
    
	Staff save(Staff staff);
    
    void delete(String staffID);
    
    Optional<Staff> findById(String staffID);
    
    Staff update(Staff staff);
}
