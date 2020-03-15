package controller;

import entity.authorities.Authorities;
import entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import service.userService.UserService;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/registerNewUser")
    public String registerNewUser(HttpServletRequest request,
                                  @Valid @ModelAttribute("user") User user,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/register";
        } else {
            user.setAuthority(new Authorities(user.getUsername(), request.getParameter("role")));
            userService.saveUser(user);
        }
        return "register";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


}
