package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(User user);
}
