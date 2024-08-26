package group6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.AdminDAO;
import group6.pojo.Admin;
@Repository
public class AdminRepository implements IAdminRepository {

    private AdminDAO adminDAO;

    public AdminRepository() {
        this.adminDAO = new AdminDAO("test-unit");
    }

    @Override
    public List<Admin> findAll() {
        return adminDAO.getAdmins();
    }

    @Override
    public Admin save(Admin admin) {
        adminDAO.save(admin);
        return admin;
    }

    @Override
    public void delete(String adminId) {
        adminDAO.delete(adminId);
    }

    @Override
    public Optional<Admin> findById(String adminId) {
        return Optional.ofNullable(adminDAO.findById(adminId));
    }


    @Override
    public Admin update(Admin admin) {
        adminDAO.update(admin);
        return admin;
    }
}
