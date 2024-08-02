package group6.service;

import java.util.List;
import group6.pojo.User;
import group6.repository.IUserRepository;

public class UserService implements IUserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(String userId) {
        userRepository.delete(userId);
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }
}
