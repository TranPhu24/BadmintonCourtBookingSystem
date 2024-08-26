package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.Admin;

public interface IAdminRepository {
    List<Admin> findAll();
    Admin save(Admin admin);
    void delete(String adminId);
    Optional<Admin> findById(String adminId);
    Admin update(Admin admin);
}
