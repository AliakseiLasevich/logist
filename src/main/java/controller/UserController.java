package controller;

import entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.userService.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model theModel) {
        User user = new User();
        theModel.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerNewUser")
    public String registerNewUser(@ModelAttribute("user") User user,
                                  @RequestParam("role") String role,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/register";
        } else {
//            userService.saveUser(user);
//            authoritiesService.saveRoleOfUser(new Authorities(user));
        }
        return "register";
    }


}
