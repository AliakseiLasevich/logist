package service.userService;

import dao.userDAO.UserDAO;
import entity.user.User;
import exceptions.UserExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger("UserServiceImpl");

    @Autowired
    private UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User registerNewUserAccount(User user) throws UserExistsException {
        if (userExist(user.getUsername())) {
            logger.info("There is an account with that username: " + user.getUsername());
            throw new UserExistsException(
                    "There is an account with that username: "
                            + user.getUsername());
        } else {
            saveUser(user);
        }
        return user;
    }

    private boolean userExist(String username) {
        User user = userDAO.getUserByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }
}
