package group6.repository;

import java.util.List;
import group6.dao.AdminDAO;
import group6.pojo.Admin;

public class AdminRepository implements IAdminRepository {

    private AdminDAO adminDAO;

    public AdminRepository(String fileConfig) {
        adminDAO = new AdminDAO(fileConfig);
    }

    @Override
    public List<Admin> findAll() {
        return adminDAO.getAdmins();
    }

    @Override
    public void save(Admin admin) {
        adminDAO.save(admin);
    }

    @Override
    public void delete(String adminId) {
        adminDAO.delete(adminId);
    }

    @Override
    public Admin findById(String adminId) {
        return adminDAO.findById(adminId);
    }

    @Override
    public void update(Admin admin) {
        adminDAO.update(admin);
    }
}
