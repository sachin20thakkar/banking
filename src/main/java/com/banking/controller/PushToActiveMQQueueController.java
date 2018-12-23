package com.banking.controller;

import com.banking.model.transfer.TransferRequest;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@RestController
@RequestMapping(value = "/banking")
public class PushToActiveMQQueueController {

    @Autowired
    JmsTemplate queueJmsTemplate;

    private Logger logger = LoggerFactory.getLogger(PushToActiveMQQueueController.class);

    @RequestMapping(value = "/pushToQueue", method = RequestMethod.POST)
    public void pushToQueue() {
        /*jmsTemplate.send(new ActiveMQQueue("jms.queue1"),new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("Test message v1");
                return textMessage;
            }
        });*/

        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setAmount(111);
        transferRequest.setClientId(2222);
        transferRequest.setFromAccountNumber(455);
        transferRequest.setToAccountNumber(8779);
        transferRequest.setTransferType("Internal");
        queueJmsTemplate.convertAndSend(transferRequest);

    }

}
