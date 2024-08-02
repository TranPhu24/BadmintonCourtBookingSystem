package group6.repository;

import java.util.List;

import group6.pojo.Staff;

public interface IStaffRepository {
	List<Staff> findAll();
    
    void save(Staff staff);
    
    void delete(String staffID);
    
    Staff findById(String staffID);
    
    void update(Staff staff);
}
