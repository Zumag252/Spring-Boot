package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void deleteUser(long id);
    void updateUser(long id, User updatedUser);
    User userById(long id);
}
