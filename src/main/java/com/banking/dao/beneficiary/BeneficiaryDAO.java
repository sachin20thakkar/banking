package com.banking.dao.beneficiary;

import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;

public interface BeneficiaryDAO {

    int addBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException;
}
