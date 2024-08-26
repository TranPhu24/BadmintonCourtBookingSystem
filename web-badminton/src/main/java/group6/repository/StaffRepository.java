package group6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.StaffDAO;
import group6.pojo.Customer;
import group6.pojo.Staff;
@Repository
public class StaffRepository implements IStaffRepository {

	private StaffDAO staffDAO;
	
	public StaffRepository() {
		staffDAO= new StaffDAO("test-unit");
	}

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		return staffDAO.getStaffs() ;
	}

	@Override
	public Staff save(Staff staff) {
		// TODO Auto-generated method stub
		staffDAO.save(staff);
		return staff;
	}

	@Override
	public void delete(String staffID) {
		// TODO Auto-generated method stub
		staffDAO.delete(staffID);
	}

	@Override
	public Optional<Staff> findById(String staffID) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(staffDAO.findById(staffID));
	}

	@Override
	public Staff update(Staff staff) {
		// TODO Auto-generated method stub
		staffDAO.update(staff);
		return staff;
		
	}

}
