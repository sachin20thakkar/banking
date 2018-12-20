package com.banking.processor.beneficiary;


import com.banking.dao.beneficiary.BeneficiaryDAO;
import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.model.beneficiary.BeneficiaryReponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("beneficiaryProcessor")
public class BeneficiaryProcessor {

    private Logger logger = LoggerFactory.getLogger(BeneficiaryProcessor.class);


    @Autowired
    private BeneficiaryDAO beneficiaryImplDAO;

    public BeneficiaryReponse processRequest(BeneficiaryInfo beneficiaryInfo) {
        BeneficiaryReponse beneficiaryReponse = new BeneficiaryReponse();
        try {
            logger.info("Request processing for addition of beneficiary info " + beneficiaryInfo);
            int confirmationNumber = beneficiaryImplDAO.addBeneficiary(beneficiaryInfo);
            beneficiaryReponse.setStatus("SUCCESS");
            beneficiaryReponse.setConfirmationNumber(confirmationNumber);


        }catch (BankingException e) {
            logger.error(e.getMessage(), e);
            beneficiaryReponse = new BeneficiaryReponse();
            beneficiaryReponse.setStatus("FAILURE");
            beneficiaryReponse.setMessage("Beneficiary addition failed. Please contact service desk");
        }

        return beneficiaryReponse;

    }
}
