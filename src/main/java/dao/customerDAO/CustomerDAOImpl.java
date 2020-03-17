package dao.customerDAO;

import entity.customer.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private Logger logger = LoggerFactory.getLogger("CustomerDAOImpl");

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getAllCustomers() {
        logger.info("Try to get all customers from database");
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by status, id_customer", Customer.class);
        return theQuery.getResultList();
    }

    public List<Customer> getCustomersPagination(int pageId, int total) {
        logger.info("Try to get customers pagination from database");
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "select * from customer order by status , id_customer limit " + (pageId - 1) + "," + total;
        Query<Customer> query = currentSession.createSQLQuery(sql).addEntity(Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        logger.info("Try to get customer by id from database");
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, customerId);
    }


    @Override
    public void saveCustomer(Customer theCustomer) {
        logger.info("Try to save customer to database");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public List<Customer> getFilteredCustomers(String filter) {
        logger.info("Try to get filtered customers from database");
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> query = currentSession.createQuery("from Customer where lower(name)  like lower ('%" + filter + "%')", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
