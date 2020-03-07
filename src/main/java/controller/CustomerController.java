package controller;

import entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.customerService.CustomerService;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/customers", "/customers/{page}"})
    public String index(@PathVariable Optional<Integer> page,
                        Model theModel) {
        int recordsOnPage = 30;
        theModel.addAttribute("customer", customerService.getCustomersPagination(page, recordsOnPage));
        theModel.addAttribute("totalPages", Math.ceil(customerService.getAllCustomers().size() / (double) recordsOnPage));

        return "customers";
    }

    @GetMapping("/all_customers")
    public String getAllCustomers(Model theModel) {
        theModel.addAttribute("customer", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/add_customer")
    public String addNewCustomer(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer_edit";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer_edit";
        } else {
            customerService.saveCustomer(theCustomer);
        }
        return "redirect:/customers";
    }

    @GetMapping("/customers/filter/")
    public String filterCustomersByName(Model theModel,
                                        @RequestParam("filter") String filter) {
        theModel.addAttribute("customer", customerService.getFilteredCustomers(filter));
        return "customers";
    }

    @GetMapping("/customer_edit")
    public String editCustomer(Model theModel,
                               @RequestParam("customerId") int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        theModel.addAttribute("customer", customer);
        return "customer_edit";
    }

    @GetMapping("/generate_customers")
    public String generateCustomers() {
        customerService.generateCustomers();
        return "customers";
    }

}
