package dao.interfaces;

import entity.user.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
