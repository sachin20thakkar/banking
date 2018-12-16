package com.banking.processor.account;

import com.banking.account.AccountFactory;
import com.banking.account.IAccountType;
import com.banking.exception.BankingException;
import com.banking.model.client.AccountCreationResponse;
import com.banking.model.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("createAccountProcessor")
public class CreateAccountProcessor {

    private Logger logger = LoggerFactory.getLogger(CreateAccountProcessor.class);
    private AccountFactory accountFactory;

    @Autowired
    public CreateAccountProcessor(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public AccountCreationResponse processRequest(Client client) {
       AccountCreationResponse accountCreationResponse;
       try {
           logger.info("Request processing for account creation " + client);
           IAccountType accountFactory = this.accountFactory.getAccount(client.getAccountInfos().getAccountType());
           accountCreationResponse = new AccountCreationResponse();
           long accountNumber = accountFactory.createAccount(client);
           accountCreationResponse.setConfirmationNumber(accountNumber);
           accountCreationResponse.setStatus("SUCCESS");

       }catch (BankingException e) {
           logger.error(e.getMessage(), e);
           accountCreationResponse = new AccountCreationResponse();
           accountCreationResponse.setStatus("FAILURE");
           accountCreationResponse.setMessage("Account Creation Failed. Please contact service desk");
       }

       return accountCreationResponse;

    }


}
