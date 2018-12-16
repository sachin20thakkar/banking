package com.banking.dao.account;

import com.banking.model.client.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("createAccountDAO")
public class CreateAccountDAO {

    private Logger logger = LoggerFactory.getLogger(CreateAccountDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int createAccount(Client client) {
        logger.info("Getting Request to create account");

        int accountNumber = createAccountNumber();
        int clientId = createClientId();

        createAccountInfo(client, accountNumber);
        return createClient(clientId, accountNumber);


    }


    private int createAccountNumber() {

        logger.info("Getting Request to create account number");
        return insertRecord("INSERT into account_number() VALUES ()", "account");

    }

    private int createClientId() {

        logger.info("Getting Request to create client id");
        return insertRecord("INSERT into client_sequence() VALUES ()", "client");

    }

    private int insertRecord(String sql, String type) {

        logger.info("Getting Request to insert {} id",type);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement stmt = connection
                        .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                return stmt;
            }
        }, keyHolder);

        logger.info("Resultant {} id is {}",type,keyHolder.getKey());
        return keyHolder.getKey().intValue();

    }

    private void createAccountInfo(Client client, int accountNumber) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement stmt = connection
                        .prepareStatement("INSERT into account_info(ACCOUNT_NUMBER, ACCOUNT_FIRST_NAME, ACCOUNT_LAST_NAME, ACCOUNT_BALANCE, ACCOUNT_START_DATE, ACCOUNT_TYPE, PAN_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, accountNumber);
                stmt.setString(2, client.getAccountInfos().getFirstName());
                stmt.setString(3, client.getAccountInfos().getLastName());
                stmt.setLong(4, client.getAccountInfos().getAccountBalance());
                stmt.setDate(5, new Date(System.currentTimeMillis()));
                stmt.setInt(6, client.getAccountInfos().getAccountType());
                stmt.setString(7, client.getAccountInfos().getPanNumber());
                return stmt;
            }
        });
    }


    private int createClient(int clientId, int accountNumber) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement stmt = connection
                        .prepareStatement("INSERT into client_info(CLIENT_ID, ACCOUNT_NUMBER) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, clientId);
                stmt.setInt(2, accountNumber);

                return stmt;
            }
        }, keyHolder);

        logger.info("Result is {}",keyHolder.getKey());

        return keyHolder.getKey().intValue();
    }

}
