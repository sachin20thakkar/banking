package com.banking.transfer;

import com.banking.exception.BankingException;
import com.banking.model.transfer.TransferRequest;
import com.banking.model.transfer.TransferResponse;

public interface ITransfer {

    TransferResponse transfer(TransferRequest transferRequest) throws BankingException;
}
