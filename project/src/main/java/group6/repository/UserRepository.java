package group6.repository;

import java.util.List;
import group6.dao.UserDAO;
import group6.pojo.User;

public class UserRepository implements IUserRepository {

    private UserDAO userDAO;

    public UserRepository(String fileConfig) {
        userDAO = new UserDAO(fileConfig);
    }

    @Override
    public List<User> findAll() {
        return userDAO.getUsers();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(String userId) {
        userDAO.delete(userId);
    }

    @Override
    public User findById(String userId) {
        return userDAO.findById(userId);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
