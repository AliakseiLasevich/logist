package controller;

import entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.customerService.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String index(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customers";
    }

    @GetMapping("/all_customers")
    public String getAllCustomers(Model theModel) {
        theModel.addAttribute("customer", customerService.getAllCustomers());
        return "customers";
    }

}
