package group6.service;

import java.util.List;

import group6.dto.StaffDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Staff;

public interface IStaffService {
    Staff createStaff(StaffDTO staffDTO) throws DataNotFoundException;
    Staff updateStaff(String id, StaffDTO staffDTO) throws DataNotFoundException;
    List<Staff> getAllStaffs();
    Staff getStaff(String id) throws DataNotFoundException;
}
