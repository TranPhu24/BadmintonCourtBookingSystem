package group6.repository;

import java.util.List;
import java.util.Optional;

import group6.pojo.User;

public interface IUserRepository {
    List<User> findAll();
    User save(User user);
    void delete(String userId);
    Optional<User> findById(String userId);
    User update(User user);
}
