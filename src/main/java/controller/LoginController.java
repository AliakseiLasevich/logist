package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage") // mapping to http.authorizeRequests() .... .loginPage("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login_page";
    }

//    //add request mapping for access denied
//    @GetMapping("/access-denied")
//    public String showAccessDeniedPage() {
//        return "access-denied";
//    }
//

}
