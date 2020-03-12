package dao.cargoDAO;

import entity.cargo.Cargo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDAOImpl implements CargoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cargo> getAllCargos() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Cargo> theQuery = currentSession.createQuery("from Cargo order by status, id_cargo", Cargo.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Cargo> getCargosPaginated(int page, int recordsOnPage) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "select * from Cargo order by status , id_cargo limit " + (page - 1) + "," + recordsOnPage;
        Query<Cargo> query = currentSession.createSQLQuery(sql).addEntity(Cargo.class);
        return query.getResultList();
    }

    @Override
    public Cargo getCargoById(int cargoId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Cargo.class, cargoId);
    }

    @Override
    public void saveCargo(Cargo theCargo) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCargo);
    }
}
