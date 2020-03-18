package dao;

import dao.interfaces.CargoDAO;
import entity.cargo.Cargo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDAOImpl implements CargoDAO {
    private Logger logger = LoggerFactory.getLogger("CargoDAOImpl");

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cargo> getAllCargos() {
        logger.info("Try to get all cargos from database");
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Cargo> theQuery = currentSession.createQuery("from Cargo order by status, id_cargo", Cargo.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Cargo> getCargosPaginated(int page, int recordsOnPage) {
        logger.info("Try to get cargo pagination from database");
        Session currentSession = sessionFactory.getCurrentSession();


        String sql = "select * from Cargo order by status , id_cargo limit " + (page - 1) + "," + recordsOnPage;
        Query<Cargo> query = currentSession.createSQLQuery(sql).addEntity(Cargo.class);
        return query.getResultList();
    }

    @Override
    public Cargo getCargoById(int cargoId) {
        logger.info("Try to get cargo by id from database");
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Cargo.class, cargoId);
    }

    @Override
    public void saveCargo(Cargo theCargo) {
        logger.info("Try to save cargo in database");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCargo);
    }
}
