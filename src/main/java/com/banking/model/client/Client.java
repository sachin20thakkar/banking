package com.banking.model.client;

public class Client {

    private String firstName;
    private String lastName;
    private long clientId;
    private Address permanentAddress;
    private Address residentialAddress;
    private ContactDetails contactDetails;
    private AccountInfo accountInfos;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", clientId=" + clientId +
                ", permanentAddress=" + permanentAddress +
                ", residentialAddress=" + residentialAddress +
                ", contactDetails=" + contactDetails +
                ", accountInfos=" + accountInfos +
                '}';
    }
}
