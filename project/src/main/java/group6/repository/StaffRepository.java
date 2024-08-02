package group6.repository;

import java.util.List;

import group6.dao.StaffDAO;
import group6.pojo.Staff;

public class StaffRepository implements IStaffRepository {

	private StaffDAO staffDAO;
	
	public StaffRepository(String  fileConfig) {
		staffDAO= new StaffDAO(fileConfig);
	}

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		return staffDAO.getStaffs() ;
	}

	@Override
	public void save(Staff staff) {
		// TODO Auto-generated method stub
		staffDAO.save(staff);
	}

	@Override
	public void delete(String staffID) {
		// TODO Auto-generated method stub
		staffDAO.delete(staffID);
	}

	@Override
	public Staff findById(String staffID) {
		// TODO Auto-generated method stub
		return staffDAO.findById(staffID);
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffDAO.update(staff);
		
	}

}
