package com.banking.processor.account;

import com.banking.account.AccountFactory;
import com.banking.account.IAccountType;
import com.banking.exception.BankingException;
import com.banking.model.client.AccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deleteAccountProcessr")
public class DeleteAccountProcessor {

    private Logger logger = LoggerFactory.getLogger(CreateAccountProcessor.class);
    private AccountFactory accountFactory;

    @Autowired
    public DeleteAccountProcessor(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public AccountResponse processRequest(Long accountNumber) {
        AccountResponse accountResponse;
        try {
            logger.info("Request processing for deletion of account {} " ,accountNumber);
            IAccountType accountFactory = this.accountFactory.getAccount(1);
            accountResponse = new AccountResponse();
            boolean response = accountFactory.deleteAccount(accountNumber);
            if(response) {
                accountResponse.setStatus("SUCCESS");

            }else {
                accountResponse.setStatus("FAILURE");
            }
        }catch (BankingException e) {
            logger.error(e.getMessage(), e);
            accountResponse = new AccountResponse();
            accountResponse.setStatus("FAILURE");
            accountResponse.setMessage("Account Deletion Failed. Please contact service desk");
        }

        return accountResponse;

    }

}
