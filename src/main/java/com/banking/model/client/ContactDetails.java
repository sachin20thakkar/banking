package com.banking.model.client;

public class ContactDetails {

    String[] mailAddress;
    long[] phoneNumber;


    public String[] getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String[] mailAddress) {
        this.mailAddress = mailAddress;
    }

    public long[] getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
