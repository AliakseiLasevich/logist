package dao.userDAO;

import entity.partner.Partner;
import entity.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User WHERE username = :username", User.class)
                .setParameter("username", username);
        if   (query.uniqueResult() != null){
            return (User) query.uniqueResult();
        }
        return null;
    }


//    @Override
//    public User getUserByUsername(String username) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        TypedQuery<User> query = currentSession.createQuery("from User WHERE username = :username", User.class)
//                .setParameter("username", username);
//        return query.getResultList().get(0);
//    }
}
