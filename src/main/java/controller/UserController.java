package controller;

import entity.authorities.Authorities;
import entity.user.User;
import exceptions.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.context.request.WebRequest;
import service.userService.UserService;

import javax.validation.Valid;

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

    @PostMapping("/registerUser")
    public String registerUser(WebRequest request,
                               @Valid @ModelAttribute("user") User user,
                               BindingResult bindingResult) {
        User registered = new User();

        if (!bindingResult.hasErrors()) {
            user.setAuthority(new Authorities(user.getUsername(), request.getParameter("role")));
            registered = createUserAccount(user, bindingResult);
        }
        if (registered == null) {
            bindingResult.rejectValue("username", "message.regError");
            return "register";
        }

        return "index";
    }

    private User createUserAccount(User user, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(user);
        } catch (UserExistsException e) {
            return null;
        }
        return registered;
    }

}

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }



