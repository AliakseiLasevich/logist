package dao.customerDAO;

import entity.customer.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getAllCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by status, id_customer", Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    public List<Customer> getCustomersPagination(int pageId, int total) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "select * from customer order by status , id_customer limit " + (pageId - 1) + "," + total;
        Query<Customer> query = currentSession.createSQLQuery(sql).addEntity(Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }
}