package service.userService;

import entity.user.User;

public interface UserService {
    void saveUser(User user);

    User registerNewUserAccount(User user);
}
