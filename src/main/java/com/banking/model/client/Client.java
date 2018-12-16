package com.banking.model.client;

public class Client {


    private long clientId;
    private Address permanentAddress;
    private Address residentialAddress;
    private ContactDetails contactDetails;
    private AccountInfo accountInfos;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Address getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(Address residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public AccountInfo getAccountInfos() {
        return accountInfos;
    }

    public void setAccountInfos(AccountInfo accountInfos) {
        this.accountInfos = accountInfos;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", permanentAddress=" + permanentAddress +
                ", residentialAddress=" + residentialAddress +
                ", contactDetails=" + contactDetails +
                ", accountInfos=" + accountInfos +
                '}';
    }
}
