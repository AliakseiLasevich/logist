package dao.customerDAO;

import entity.customer.Customer;
import entity.customer.CustomerInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

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

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public void generateCustomers() {
        for (int i = 0; i < 50; i++) {
            Session currentSession = sessionFactory.getCurrentSession();
            Customer c = new Customer();
            CustomerInfo ci = new CustomerInfo();
            c.setCustomerInfo(ci);
            c.setName(generateName(5) + i);
            c.getCustomerInfo().setAddress(generateName(8)  + " - " + randomNumericGenerator(2));
            c.getCustomerInfo().setContactPerson(generateName(5) + " " + generateName(5));
            c.getCustomerInfo().setCountry("Belarus");
            c.getCustomerInfo().setCity(generateName(6));
            c.getCustomerInfo().setWebsite("www." + generateName(5) + generateName(4) + ".com");
            c.getCustomerInfo().setPhone1("+" + randomNumericGenerator(9));
            c.getCustomerInfo().setPhone2("+" + randomNumericGenerator(9));
            c.getCustomerInfo().setEmail(generateName(5) + "@" + generateName(4) + ".com");
            currentSession.saveOrUpdate(c);
        }
    }

    public String generateName(int count) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(count)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String randomNumericGenerator(int count) {
        String ALPHA_NUMERIC_STRING = "0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
