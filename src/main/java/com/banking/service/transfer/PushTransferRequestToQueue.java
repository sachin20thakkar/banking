package com.banking.service.transfer;

import com.banking.dao.transfer.TransferDAO;
import com.banking.exception.BankingException;
import com.banking.model.transfer.TransferRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;



@Service("pushTransferRequestToQueue")
public class PushTransferRequestToQueue {

    private Logger logger = LoggerFactory.getLogger(TransferDAO.class);

    @Autowired
    JmsTemplate queueJmsTemplate;

    public void pushTransferRequestToQueue(TransferRequest transferRequest, long confirmationNumber, String queueName) throws BankingException{
        try{
            queueJmsTemplate.convertAndSend(queueName,transferRequest);
        }catch(Exception e) {
            logger.error("Error occurred while sending transfer message to queue for {} ", transferRequest);
            throw new BankingException(e);
        }

    }

}
