package dao;

import dao.interfaces.PartnerDAO;
import entity.partner.Partner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartnerDAOImpl implements PartnerDAO {

    private Logger logger = LoggerFactory.getLogger("PartnerDAOImpl");

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Partner> getAllPartners() {
        logger.info("Try to get all partners from database");
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Partner> theQuery = currentSession.createQuery("from Partner order by status, id_partner", Partner.class);
        List<Partner> partners = theQuery.getResultList();
        return partners;
    }

    @Override
    public List<Partner> getPartnersPaginated(int page, int recordsOnPage) {
        logger.info("Try to get partners pagination from database");
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "select * from Partner order by status , id_partner limit " + (page - 1) + "," + recordsOnPage;
        Query<Partner> query = currentSession.createSQLQuery(sql).addEntity(Partner.class);
        return query.getResultList();
    }

    @Override
    public void savePartner(Partner thePartner) {
        logger.info("Try to save partner to database");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(thePartner);
    }

    @Override
    public List<Partner> getFilteredPartners(String filter) {
        logger.info("Try to get filtered partners");
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Partner> query = currentSession.createQuery("from Partner where lower(name)  like lower ('%" + filter + "%')", Partner.class);
        List<Partner> partners = query.getResultList();
        return partners;
    }

    @Override
    public Partner getPartnerById(int partnerId) {
        logger.info("Try to get partner by id");
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Partner.class, partnerId);
    }
}
