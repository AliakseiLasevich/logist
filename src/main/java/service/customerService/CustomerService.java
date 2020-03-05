package service.customerService;

import entity.customer.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    List<Customer> getAllCustomers();

    List<Customer> getCustomersPagination(Optional<Integer> pageId, int total);
}
