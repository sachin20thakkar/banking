package com.banking.dao.account;


import com.banking.dao.account.util.AccountInfoRowMapper;
import com.banking.model.client.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("getAccountInfoDAO")
public class GetAccountInfoDAO {

    private Logger logger = LoggerFactory.getLogger(GetAccountInfoDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AccountInfo getAccountInfo(long accountNumber) {
        logger.info("Getting request to get account info for {} at DAO", accountNumber);
        AccountInfo accountInfo = jdbcTemplate.queryForObject("select * from account_info where account_number = ?",  new Object [] {accountNumber}, new AccountInfoRowMapper());
        return accountInfo;

    }

}
