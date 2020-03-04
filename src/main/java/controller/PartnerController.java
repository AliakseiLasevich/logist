package controller;

import entity.customer.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartnerController {

    @GetMapping("/partners")
    public String index(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "partners";
    }
}
