package com.banking.controller.account;

import com.banking.model.client.AccountCreationResponse;
import com.banking.model.client.Client;
import com.banking.processor.account.CreateAccountProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("createAccountController")
@RequestMapping(value = "/banking")
public class CreateAccountController {

    private Logger logger = LoggerFactory.getLogger(CreateAccountController.class);

    @Autowired
    private CreateAccountProcessor createAccountProcessor;

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<AccountCreationResponse> createAccount(@RequestBody Client client) {
        logger.info("Getting Request for account creation: "+ client);
        AccountCreationResponse accountCreationResponse  = createAccountProcessor.processRequest(client);
        return new ResponseEntity<>(accountCreationResponse, HttpStatus.OK);
    }


}
