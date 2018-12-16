package com.banking.controller.account;



import com.banking.model.client.AccountInfo;
import com.banking.processor.account.GetAccountInfoProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("getAccountInfoController")
@RequestMapping(value = "/banking")
public class GetAccountInfoController {

    private Logger logger = LoggerFactory.getLogger(GetAccountInfoController.class);

    @Autowired
    private GetAccountInfoProcessor getAccountInfoProcessor;

    @RequestMapping(value = "/getAccountInfo/{accountNumber}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<AccountInfo> getAccountInfo(@PathVariable(value = "accountNumber") long accountNumber) {
        logger.info("Getting Request to get account info: "+ accountNumber);
        AccountInfo accountInfo  = getAccountInfoProcessor.getAccountInfo(accountNumber);
        return new ResponseEntity<>(accountInfo, HttpStatus.OK);
    }


}
