package group6.service;

import java.util.List;
import group6.pojo.User;

public interface IUserService {
    List<User> findAll();
    void save(User user);
    void delete(String userId);
    User findById(String userId);
    void update(User user);
}
