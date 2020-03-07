package service.customerService;

import dao.customerDAO.CustomerDAO;
import entity.customer.Customer;
import entity.customer.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Transactional
    public List<Customer> getCustomersPagination(Optional<Integer> pageId, int recordsOnPage) {
        int page = 1;
        if ((pageId.isPresent()) && (pageId.get() > 0)) {
            page = pageId.get();
        }
        if (page == 1) {
        } else {
            page = (page - 1) * recordsOnPage + 1;
        }
        return customerDAO.getCustomersPagination(page, recordsOnPage);
    }

    @Transactional
    @Override
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public void generateCustomers() {
        customerDAO.generateCustomers();
    }
}
