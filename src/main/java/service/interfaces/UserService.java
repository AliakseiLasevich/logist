package service.interfaces;

import entity.user.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User registerNewUserAccount(User user);

    List<User> getAllUsers();
}
