package service.customerService;

import entity.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> getAllCustomers();
}
