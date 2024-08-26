package group6.repository;

import java.util.List;
import group6.pojo.Admin;

public interface IAdminRepository {
    List<Admin> findAll();
    void save(Admin admin);
    void delete(String adminId);
    Admin findById(String adminId);
    void update(Admin admin);
}
