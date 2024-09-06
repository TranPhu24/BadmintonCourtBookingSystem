package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.ManagerDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Manager;
import group6.pojo.User;
import group6.repository.ManagerRepository;
import group6.repository.UserRepository;

@Service
public class ManagerService implements IManagerService {
    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository, UserRepository userRepository) {
        this.managerRepository = managerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Manager createManager(ManagerDTO managerDTO) throws DataNotFoundException {
        User existingUser = userRepository.findById(managerDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + managerDTO.getUserId()));
        
        Manager newManager = new Manager(
                managerDTO.getManagerId(),
                managerDTO.getManagerName(),
                existingUser
        );

        return managerRepository.save(newManager);
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManager(String id) throws DataNotFoundException {
        return managerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Manager not found with id " + id));
    }

    @Override
    public Manager updateManager(String id, ManagerDTO managerDTO) throws DataNotFoundException {
        Manager existingManager = managerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Manager not found with id " + id));
        
        User existingUser = userRepository.findById(managerDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + managerDTO.getUserId()));
        
        existingManager.setManagerName(managerDTO.getManagerName());
        existingManager.setUser(existingUser);
        
        return managerRepository.update(existingManager);
    }

    @Override
    public void deleteManager(String id) throws DataNotFoundException {
        if (!managerRepository.existsById(id)) {
            throw new DataNotFoundException("Manager not found with id " + id);
        }
        managerRepository.delete(id); 
    }

}