package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    //    //add request mapping for access denied
//    @GetMapping("/access-denied")
//    public String showAccessDeniedPage() {
//        return "access-denied";
//    }
//
}
