package com.banking.dao.account.util;

import com.banking.model.client.AccountInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountInfoRowMapper implements RowMapper<AccountInfo> {

    @Override
    public AccountInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setFirstName(resultSet.getString("ACCOUNT_FIRST_NAME"));
        accountInfo.setLastName(resultSet.getString("ACCOUNT_LAST_NAME"));
        accountInfo.setAccountBalance(resultSet.getInt("ACCOUNT_BALANCE"));
        accountInfo.setAccountType(resultSet.getInt("ACCOUNT_TYPE"));
        accountInfo.setAccountStartDate(resultSet.getDate("ACCOUNT_START_DATE"));
        return accountInfo;
    }
}
