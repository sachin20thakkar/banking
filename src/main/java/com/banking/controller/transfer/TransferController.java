package com.banking.controller.transfer;

import com.banking.model.transfer.TransferRequest;
import com.banking.model.transfer.TransferResponse;
import com.banking.processor.transfer.TransferProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("transferController")
@RequestMapping(value = "/banking")
public class TransferController {

    private Logger logger = LoggerFactory.getLogger(TransferController.class);

    @Autowired
    private TransferProcessor transferProcessor;

    @RequestMapping(value = "/transfer", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<TransferResponse> transfer(@RequestBody TransferRequest transferRequest) {
            logger.info("Getting Request for transfer: {}", transferRequest);
            TransferResponse transferResponse  = transferProcessor.processRequest(transferRequest);
            return new ResponseEntity<>(transferResponse, HttpStatus.OK);
        }
}


