package com.banking.controller.account;


import com.banking.model.client.AccountResponse;
import com.banking.processor.account.DeleteAccountProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("deleteAccountController")
@RequestMapping(value = "/banking")
public class DeleteAccountController {


        private Logger logger = LoggerFactory.getLogger(com.banking.controller.account.CreateAccountController.class);

        @Autowired
        private DeleteAccountProcessor deleteAccountProcessor;

        @RequestMapping(value = "/deleteaccount/{accountNumber}", method = RequestMethod.POST, produces = "application/json")
        @ResponseBody
        public ResponseEntity<AccountResponse> deleteAccount(@PathVariable(value = "accountNumber") long accountNumber) {
            logger.info("Getting Request for account deletion: "+ accountNumber);
            AccountResponse accountResponse  = deleteAccountProcessor.processRequest(accountNumber);
            return new ResponseEntity<>(accountResponse, HttpStatus.OK);
        }

}
