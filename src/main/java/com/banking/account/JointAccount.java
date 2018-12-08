package com.banking.account;

import com.banking.model.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("jointAccount")
public class JointAccount implements IAccountType {
    private Logger logger = LoggerFactory.getLogger(JointAccount.class);

    @Override
    public long createAccount(Client client) {
        logger.info("Joint account is created");
        return (long)(Math.random() * 100);
    }
}
