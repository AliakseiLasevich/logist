package service.transferService;

import dao.transferDAO.TransferDAO;
import entity.transfer.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferDAO transferDAO;

    @Override
    @Transactional
    public void saveTransfer(Transfer transfer) {
        transferDAO.saveTransfer(transfer);
    }

    @Transactional
    @Override
    public Transfer getTransferById(int transferId) {
        return transferDAO.getTransferById(transferId);
    }

    @Transactional
    @Override
    public List<Transfer> getAllTransfers() {
        return transferDAO.getAllTransfers();
    }
}
