package com.banking.transfer;

import com.banking.dao.transfer.TransferDAO;
import com.banking.exception.BankingException;
import com.banking.model.transfer.TransferRequest;
import com.banking.model.transfer.TransferResponse;
import com.banking.service.transfer.PushTransferRequestToQueue;

import com.banking.util.BankingConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("internalTransfer")
public class InternalTransfer implements ITransfer {

    private Logger logger = LoggerFactory.getLogger(InternalTransfer.class);
    private PushTransferRequestToQueue pushTransferRequestToQueue;
    private TransferDAO transferDAO;

    @Autowired
    public InternalTransfer(PushTransferRequestToQueue pushTransferRequestToQueue, TransferDAO transferDAO) {
        this.pushTransferRequestToQueue = pushTransferRequestToQueue;
        this.transferDAO = transferDAO;
    }

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) throws BankingException {
        logger.info("Getting Internal Transfer request for {}", transferRequest);
        long confirmationNumber = transferDAO.transfer(transferRequest);
        pushTransferRequestToQueue.pushTransferRequestToQueue(transferRequest, confirmationNumber, BankingConstant.INTERNAL_TRANSFER_QUEUE_NAME);
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setConfirmationNumber(confirmationNumber);
        transferResponse.setStatus("SUCCESS");
        return transferResponse;
    }
}
