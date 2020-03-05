package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.customerService.CustomerService;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(value = {"/customers", "/customers/{page}"})
    public String index(@PathVariable Optional<Integer> page, Model theModel) {
        int recordsOnPage = 20;
        theModel.addAttribute("customer", customerService.getCustomersPagination(page, recordsOnPage));
        theModel.addAttribute("totalPages", Math.ceil(customerService.getAllCustomers().size() / (double) recordsOnPage));
        return "customers";
    }

    @GetMapping("/all_customers")
    public String getAllCustomers(Model theModel) {
        theModel.addAttribute("customer", customerService.getAllCustomers());
        return "customers";
    }

}
