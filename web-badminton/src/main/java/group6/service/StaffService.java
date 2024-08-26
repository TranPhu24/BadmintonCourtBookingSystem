package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.StaffDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Staff;
import group6.pojo.User;
import group6.repository.StaffRepository;
import group6.repository.UserRepository;

@Service
public class StaffService implements IStaffService {
    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    public StaffService(StaffRepository staffRepository, UserRepository userRepository) {
        this.staffRepository = staffRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Staff createStaff(StaffDTO staffDTO) throws DataNotFoundException {
        User existingUser = userRepository.findById(staffDTO.getStaffId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + staffDTO.getUserId()));
        
        Staff newStaff = new Staff(
            staffDTO.getStaffId(),
            staffDTO.getStaffName(),
            existingUser
        );
        
        return staffRepository.save(newStaff);
    }

    @Override
    public Staff updateStaff(String id, StaffDTO staffDTO) throws DataNotFoundException {
        Staff existingStaff = staffRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Staff not found with id " + id));
        
        User existingUser = userRepository.findById(staffDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + staffDTO.getUserId()));
        
        existingStaff.setStaffName(staffDTO.getStaffName());
        existingStaff.setUser(existingUser);
        
        return staffRepository.save(existingStaff);
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }
    
    @Override
    public Staff getStaff(String id) throws DataNotFoundException {
        return staffRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Staff not found with id " + id));
    }
}
