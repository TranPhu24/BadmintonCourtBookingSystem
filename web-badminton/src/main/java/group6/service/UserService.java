package group6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group6.dto.UserDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Admin;
import group6.pojo.User;
import group6.repository.AdminRepository;
import group6.repository.UserRepository;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    public UserService(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    public User createUser(UserDTO userDTO) throws DataNotFoundException {
        Admin existingAdmin = adminRepository.findById(userDTO.getAdminId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find admin with id " + userDTO.getAdminId()));

        User newUser = new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getPassword(),
                userDTO.getRole()
        );
        newUser.setAdmin(existingAdmin);

        return userRepository.save(newUser);
    }

    public User updateUser(String id, UserDTO userDTO) throws DataNotFoundException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User not found with id " + id));

        Admin existingAdmin = adminRepository.findById(userDTO.getAdminId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find admin with id " + userDTO.getAdminId()));

        existingUser.setUserName(userDTO.getUserName());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setRole(userDTO.getRole());
        existingUser.setAdmin(existingAdmin);

        return userRepository.update(existingUser);
    }

    public User getUser(String id) throws DataNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User not found with id " + id));
    }

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

   
}
