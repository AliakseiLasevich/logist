package service.transferService;

import entity.transfer.Transfer;

import java.util.List;

public interface TransferService {
    void saveTransfer(Transfer transfer);

    Transfer getTransferById(int transferId);

    List<Transfer> getAllTransfers();
}
