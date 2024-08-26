package group6.service;

import java.util.List;
import group6.pojo.Admin;
import group6.repository.IAdminRepository;

public class AdminService implements IAdminService {

    private IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void delete(String adminId) {
        adminRepository.delete(adminId);
    }

    @Override
    public Admin findById(String adminId) {
        return adminRepository.findById(adminId);
    }

    @Override
    public void update(Admin admin) {
        adminRepository.update(admin);
    }
}
