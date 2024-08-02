package group6.service;

import java.util.List;
import group6.pojo.Admin;

public interface IAdminService {
    List<Admin> findAll();
    void save(Admin admin);
    void delete(String adminId);
    Admin findById(String adminId);
    void update(Admin admin);
}
