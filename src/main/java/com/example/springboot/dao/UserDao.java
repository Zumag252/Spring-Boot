package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void createUser(User user);
    User userById(long id);
    void deleteUser(long id);
    void updateUser(long id, User updatedUser);
}
