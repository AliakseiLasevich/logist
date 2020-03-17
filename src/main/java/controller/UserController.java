package controller;

import entity.authorities.Authorities;
import entity.user.User;
import exceptions.UserExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import service.userService.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger("UserController");

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public String getAllUsers(Model theModel) {
        theModel.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/register")
    public String registerForm(Model theModel) {
        User user = new User();
        theModel.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/user_panel")
    public String userPanel(Model theModel) {
        return "user_panel";
    }

    @PostMapping("/registerUser")
    public String registerUser(WebRequest request,
                               @Valid @ModelAttribute("user") User user,
                               BindingResult bindingResult) {
        User registered = new User();

        if (!bindingResult.hasErrors()) {
            logger.info("No errors in form. Try to save user");
            List<Authorities> authoritiesList = new ArrayList<>();
            authoritiesList.add(new Authorities(user, user.getUsername(), request.getParameter("role")));
            user.setAuthorities(authoritiesList);
            registered = createUserAccount(user, bindingResult);

        }
        if (registered == null) {
            bindingResult.rejectValue("username", "message.regError");
            return "register";
        }
        logger.info("registerUser(). Errors in form");
        return "register";
    }

    private User createUserAccount(User user, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(user);
        } catch (UserExistsException e) {
            logger.info(user.getUsername() + " - User exists. Return null");
            return null;
        }
        return registered;
    }
}



