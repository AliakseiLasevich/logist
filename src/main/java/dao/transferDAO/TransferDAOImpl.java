package dao.transferDAO;

import entity.cargo.Cargo;
import entity.transfer.Transfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransferDAOImpl implements TransferDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveTransfer(Transfer transfer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(transfer);
    }

    @Override
    public Transfer getTransferById(int transferId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Transfer.class, transferId);
    }

    @Override
    public List<Transfer> getAllTransfers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Transfer> theQuery = currentSession.createQuery("from Transfer", Transfer.class);
        return theQuery.getResultList();
    }
}
