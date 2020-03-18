package dao.interfaces;

import entity.transfer.Transfer;

import java.util.List;

public interface TransferDAO {
    void saveTransfer(Transfer transfer);

    Transfer getTransferById(int transferId);

    List<Transfer> getAllTransfers();
}
