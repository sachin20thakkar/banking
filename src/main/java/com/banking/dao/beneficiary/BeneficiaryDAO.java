package com.banking.dao.beneficiary;

import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;

import java.util.List;

public interface BeneficiaryDAO {

    int addBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException;

    List<BeneficiaryInfo> getBeneficiary(long clientId) throws BankingException;


}
