package com.banking.dao.transfer;

import com.banking.model.transfer.TransferRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("internalTransferDAO")
public class InternalTransferDAO {

    private Logger logger = LoggerFactory.getLogger(InternalTransferDAO.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void transferCash(TransferRequest transferRequest) {

        logger.info("Getting request to update transfer case info {}", transferRequest);
        long fromAccountBalance = getAccountBalance(transferRequest.getFromAccountNumber());
        long toAccountBalance = getAccountBalance(transferRequest.getToAccountNumber());
        updateFromAccountBalance(transferRequest.getFromAccountNumber(), fromAccountBalance , transferRequest.getAmount());
        updateToAccountBalance(transferRequest.getToAccountNumber(), toAccountBalance, transferRequest.getAmount());

    }

    private long getAccountBalance(long accountNumber) {
        String sql = "select account_balance from account_info where account_number = ?";
        String accountBalance = jdbcTemplate.queryForObject(sql, new Object[] {accountNumber}, String.class);
        return Long.valueOf(accountBalance);
    }

    private void updateFromAccountBalance(long accountNumber, long fromAccountBalance, long amount) {
        long currentAmount = fromAccountBalance - amount;
        String sql = "update account_info set account_balance = ? where account_number = ?";
        jdbcTemplate.update(sql, new Object[] {currentAmount, accountNumber});
    }

    private void updateToAccountBalance(long accountNumber, long toAccountBalance, long amount) {
        long currentAmount = toAccountBalance + amount;
        String sql = "update account_info set account_balance = ? where account_numberrr = ?";
        jdbcTemplate.update(sql, new Object[] {currentAmount, accountNumber});
    }



}
