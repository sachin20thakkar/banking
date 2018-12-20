package com.banking.model.beneficiary;

public class BeneficiaryInfo {

    private int beneficiaryType;
    private String beneficiaryAccountNumber;
    private int beneficiaryAccountType;
    private String beneficiaryName;
    private String emailId;
    private long clientId;
    private String ifscCode;

    public int getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(int beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public int getBeneficiaryAccountType() {
        return beneficiaryAccountType;
    }

    public void setBeneficiaryAccountType(int beneficiaryAccountType) {
        this.beneficiaryAccountType = beneficiaryAccountType;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    @Override
    public String toString() {
        return "BeneficiaryInfo{" +
                "beneficiaryType=" + beneficiaryType +
                ", beneficiaryAccountNumber='" + beneficiaryAccountNumber + '\'' +
                ", beneficiaryAccountType=" + beneficiaryAccountType +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", clientId=" + clientId +
                ", ifscCode='" + ifscCode + '\'' +
                '}';
    }
}
