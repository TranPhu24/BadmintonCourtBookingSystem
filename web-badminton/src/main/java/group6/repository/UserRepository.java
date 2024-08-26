package group6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.UserDAO;
import group6.pojo.User;
@Repository
public class UserRepository implements IUserRepository {

    private UserDAO userDAO;

    public UserRepository() {
        userDAO = new UserDAO("test-unit");
    }
    
    @Override
    public List<User> findAll() {
        return userDAO.getUsers();
    }

    @Override
    public User save(User user) {
        userDAO.save(user);
        return user;
    }

    @Override
    public void delete(String userId) {
        userDAO.delete(userId);
    }

    @Override
    public Optional<User> findById(String userId) {
        return Optional.ofNullable(userDAO.findById(userId));
    }

    @Override
    public User update(User user) {
        userDAO.update(user);
        return user;
    }
}
