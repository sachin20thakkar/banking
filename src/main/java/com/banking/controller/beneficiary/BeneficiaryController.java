package com.banking.controller.beneficiary;



import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.model.beneficiary.BeneficiaryReponse;
import com.banking.processor.beneficiary.BeneficiaryProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("beneficiaryController")
@RequestMapping(value = "/banking")
public class BeneficiaryController {

    private Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);

    @Autowired
    private BeneficiaryProcessor beneficiaryProcessor;

    @RequestMapping(value = "/addBeneficiary", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<BeneficiaryReponse> addBeneficiary(@RequestBody BeneficiaryInfo beneficiaryInfo) {
        logger.info("Getting Request for beneficiary addition: {} ", beneficiaryInfo);
        BeneficiaryReponse beneficiaryReponse  = beneficiaryProcessor.processRequest(beneficiaryInfo);
        return new ResponseEntity<>(beneficiaryReponse, HttpStatus.OK);
    }

}
