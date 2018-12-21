package com.banking.model.beneficiary;

import java.util.List;

public class BeneficiaryReponse {

    private long confirmationNumber;
    private String status;
    private String message;
    private List<BeneficiaryInfo> beneficiaryInfoList;

    public long getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(long confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BeneficiaryInfo> getBeneficiaryInfoList() {
        return beneficiaryInfoList;
    }

    public void setBeneficiaryInfoList(List<BeneficiaryInfo> beneficiaryInfoList) {
        this.beneficiaryInfoList = beneficiaryInfoList;
    }
}
