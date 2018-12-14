package com.banking.account;

import com.banking.model.client.Client;

public interface IAccountType {
    long createAccount(Client client);

    boolean deleteAccount(long accountNumber);
}
