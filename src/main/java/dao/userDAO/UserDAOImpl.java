package dao.userDAO;

import entity.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private Logger logger = LoggerFactory.getLogger("PartnerDAOImpl");

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        logger.info("Get all users from db");
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("from User order by id_user", User.class);
        return theQuery.getResultList();
    }

    @Override
    public void saveUser(User user) {
        logger.info("Try to save user to db");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Override
    public User getUserByUsername(String username) {
        logger.info("Try to get user by username");
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User WHERE username = :username", User.class)
                .setParameter("username", username);
        if (query.uniqueResult() != null) {
            return (User) query.uniqueResult();
        }
        logger.info("Can't find user" + username + "in db.");
        return null;
    }

}
