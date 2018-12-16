package com.banking.model.client;

public class AccountCreationResponse {

    private long confirmationNumber;
    private String status;
    private String message;

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
}
