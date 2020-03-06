package dao.customerDAO;

import entity.customer.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomers();

    List<Customer> getCustomersPagination(int pageId, int total);

    void saveCustomer(Customer theCustomer);
}
