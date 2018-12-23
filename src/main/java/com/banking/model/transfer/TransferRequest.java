package com.banking.model.transfer;

public class TransferRequest {

    private long fromAccountNumber;
    private long toAccountNumber;
    private long amount;
    private String transferType;
    private long clientId;


    public long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }


    @Override
    public String toString() {
        return "TransferRequest{" +
                "fromAccountNumber=" + fromAccountNumber +
                ", toAccountNumber=" + toAccountNumber +
                ", amount=" + amount +
                ", transferType='" + transferType + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
