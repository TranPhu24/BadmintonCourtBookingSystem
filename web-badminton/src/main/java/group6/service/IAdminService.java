package group6.service;

import java.util.List;

import group6.dto.AdminDTO;
import group6.pojo.Admin;
import group6.exceptions.DataNotFoundException;

public interface IAdminService {
    Admin createAdmin(AdminDTO adminDTO) throws DataNotFoundException;
    Admin updateAdmin(String id, AdminDTO adminDTO) throws DataNotFoundException;
    List<Admin> getAllAdmins();
    Admin getAdmin(String id) throws DataNotFoundException;
}
