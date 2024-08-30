package group6.service;

import java.util.List;

import group6.dto.ManagerDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Manager;

public interface IManagerService {
    Manager createManager(ManagerDTO managerDTO) throws DataNotFoundException;
    List<Manager> getAllManagers();
    Manager getManager(String id) throws DataNotFoundException;
    Manager updateManager(String id, ManagerDTO managerDTO) throws DataNotFoundException;
    void deleteManager(String id) throws DataNotFoundException;
}
