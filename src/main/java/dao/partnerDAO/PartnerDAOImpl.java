package dao.partnerDAO;

import entity.partner.Partner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PartnerDAOImpl implements PartnerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Partner> getAllPartners() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Partner> theQuery = currentSession.createQuery("from Partner order by status, id_partner", Partner.class);
        List<Partner> partners = theQuery.getResultList();
        return partners;
    }

    @Override
    public List<Partner> getPartnersPaginated(int page, int recordsOnPage) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "select * from Partner order by status , id_partner limit " + (page - 1) + "," + recordsOnPage;
        Query<Partner> query = currentSession.createSQLQuery(sql).addEntity(Partner.class);
        return query.getResultList();
    }

    @Override
    public void savePartner(Partner thePartner) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(thePartner);
    }

    @Override
    public List<Partner> getFilteredPartners(String filter) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Partner> query = currentSession.createQuery("from Partner where lower(name)  like lower ('%" + filter + "%')", Partner.class);
        List<Partner> partners = query.getResultList();
        return partners;
    }

    @Override
    public Partner getPartnerById(int partnerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Partner.class, partnerId);
    }
}
