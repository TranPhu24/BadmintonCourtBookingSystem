package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.AdminDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Admin;
import group6.repository.AdminRepository;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin createAdmin(AdminDTO adminDTO) throws DataNotFoundException {
        Admin newAdmin = new Admin(
            adminDTO.getAdminID(),
            adminDTO.getAdminName()
        );
        
        return adminRepository.save(newAdmin);
    }
    
    @Override
    public Admin updateAdmin(String id, AdminDTO adminDTO) throws DataNotFoundException {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Admin not found with id " + id));
        
        existingAdmin.setAdminName(adminDTO.getAdminName());
        
        return adminRepository.update(existingAdmin);
    }
    
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    
    @Override
    public Admin getAdmin(String id) throws DataNotFoundException {
        return adminRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Admin not found with id " + id));
    }
}
