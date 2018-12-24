package com.banking.listener.transfer;

import com.banking.model.transfer.TransferRequest;
import com.banking.processor.transfer.InternalTransferListenerProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service("internalTransferListener")
public class InternalTransferListener {

    Logger logger = LoggerFactory.getLogger(InternalTransferListener.class);

    @Autowired
    InternalTransferListenerProcessor internalTransferListenerProcessor;

    @JmsListener(destination = "INTERNAL_TRANSFER", concurrency = "3-10")
    public void onMessage(TransferRequest transferRequest) {
        logger.info("Getting transfer request from queue {}",transferRequest);
        internalTransferListenerProcessor.internalTransfer(transferRequest);
    }
}
