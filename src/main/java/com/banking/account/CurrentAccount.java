package com.banking.account;

import com.banking.model.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("currentAccount")
public class CurrentAccount implements IAccountType {

    private Logger logger = LoggerFactory.getLogger(CurrentAccount.class);

    @Override
    public long createAccount(Client client) {
        logger.info("Current account is created");
        return (long)(Math.random() * 100);
    }
}
