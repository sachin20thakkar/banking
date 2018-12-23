package com.banking.transfer;

import com.banking.exception.BankingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transferFactory")
public class TransferFactory {

    private static final Logger logger = LoggerFactory.getLogger(TransferFactory.class);

    @Autowired
    private ITransfer internalTransfer;



    public ITransfer getTransfer(String transferType) throws BankingException {
        logger.info("Getting {} as transfer type", transferType);
        switch (transferType) {
            case "Internal":
                return internalTransfer;
            default:
                logger.error("No available transfer bean found for {} transfer type", transferType);
                throw new BankingException("No available transfer type found, please select correct transfer type");


        }
    }
}
