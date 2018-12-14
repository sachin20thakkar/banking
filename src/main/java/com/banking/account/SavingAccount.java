package com.banking.account;


import com.banking.model.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("savingAccount")
public class SavingAccount implements IAccountType {

    private Logger logger = LoggerFactory.getLogger(SavingAccount.class);

    @Override
    public long createAccount(Client client) {
        logger.info("Saving Account is created");
        return (long)(Math.random() * 100);
    }

    @Override
    public boolean deleteAccount(long accountNumber) {
        logger.info("Saving Account is deleted");
        return true;
    }
}
