package dao.transferDAO;

import entity.cargo.Cargo;
import entity.transfer.Transfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransferDAOImpl implements TransferDAO {

    private Logger logger = LoggerFactory.getLogger("PartnerDAOImpl");

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveTransfer(Transfer transfer) {
        logger.info("Save transfer to database");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(transfer);
    }

    @Override
    public Transfer getTransferById(int transferId) {
        logger.info("Get transfer by id");
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Transfer.class, transferId);
    }

    @Override
    public List<Transfer> getAllTransfers() {
        logger.info("Get all transfers from db");
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Transfer> theQuery = currentSession.createQuery("from Transfer", Transfer.class);
        return theQuery.getResultList();
    }
}
