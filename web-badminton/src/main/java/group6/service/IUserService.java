package group6.service;

import java.util.List;

import group6.dto.UserDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.User;

public interface IUserService {
    User createUser(UserDTO userDTO) throws DataNotFoundException;
    List<User> getAllUsers();
    User getUser(String id) throws DataNotFoundException;
    User updateUser(String id, UserDTO userDTO) throws DataNotFoundException;
}
