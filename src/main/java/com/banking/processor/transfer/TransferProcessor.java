package com.banking.processor.transfer;

import com.banking.exception.BankingException;
import com.banking.model.transfer.TransferRequest;
import com.banking.model.transfer.TransferResponse;
import com.banking.transfer.ITransfer;
import com.banking.transfer.TransferFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transferProcessor")
public class TransferProcessor {

    private Logger logger = LoggerFactory.getLogger(TransferProcessor.class);
    private TransferFactory transferFactory;

    @Autowired
    public TransferProcessor(TransferFactory transferFactory) {
        this.transferFactory = transferFactory;
    }

    public TransferResponse processRequest(TransferRequest transferRequest) {
        TransferResponse transferResponse;
        try {
            logger.info("Request processing for transfer {}" , transferRequest);
            ITransfer iTransfer = this.transferFactory.getTransfer(transferRequest.getTransferType());
            return iTransfer.transfer(transferRequest);

        }catch (BankingException e) {
            logger.error(e.getMessage(), e);
            transferResponse = new TransferResponse();
            transferResponse.setStatus("FAILURE");
            transferResponse.setMessage("Transfer Request Failed. Please contact service desk");
        }

        return transferResponse;

    }
}
