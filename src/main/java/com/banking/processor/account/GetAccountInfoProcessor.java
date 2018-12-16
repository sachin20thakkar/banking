package com.banking.processor.account;

import com.banking.dao.account.GetAccountInfoDAO;
import com.banking.model.client.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("getAccountInfoProcessor")
public class GetAccountInfoProcessor {

    private Logger logger = LoggerFactory.getLogger(GetAccountInfoProcessor.class);

    @Autowired
    private GetAccountInfoDAO getAccountInfoDAO;


    public AccountInfo getAccountInfo(long accountNumber) {
        logger.info("Getting request to get account info for account {} at processor", accountNumber);
        AccountInfo accountInfo = getAccountInfoDAO.getAccountInfo(accountNumber);
        return accountInfo;
    }

}
