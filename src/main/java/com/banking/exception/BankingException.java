package com.banking.exception;

public class BankingException extends Exception {

    public BankingException(String message) {
        super(message);

    }

    public BankingException(Throwable cause) {
        super(cause);
    }

    public BankingException(String message, Throwable cause) {
        super(message, cause);

    }

}
