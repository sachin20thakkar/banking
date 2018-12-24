package com.banking.processor.transfer;

import com.banking.dao.transfer.InternalTransferDAO;
import com.banking.model.transfer.TransferRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternalTransferListenerProcessor {

    private Logger logger = LoggerFactory.getLogger(InternalTransferListenerProcessor.class);

    private InternalTransferDAO internalTransferDAO;

    @Autowired
    InternalTransferListenerProcessor(InternalTransferDAO internalTransferDAO) {
        this.internalTransferDAO = internalTransferDAO;
    }

    public void internalTransfer(TransferRequest transferRequest) {
        internalTransferDAO.transferCash(transferRequest);
    }



}
