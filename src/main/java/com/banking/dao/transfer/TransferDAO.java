package com.banking.dao.transfer;


import com.banking.dao.beneficiary.BeneficiaryImplDAO;
import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.model.transfer.TransferRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("transferDAO")
public class TransferDAO {

    private Logger logger = LoggerFactory.getLogger(TransferDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long transfer(TransferRequest transferRequest) {

            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement stmt = connection
                            .prepareStatement("INSERT into transfer_info(FROM_ACCOUNT_NUM, TO_ACCOUNT_NUM, AMOUNT, TRANSFER_TYPE, CLIENT_ID) VALUES (?, ?, ?, ?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                    stmt.setLong(1, transferRequest.getFromAccountNumber());
                    stmt.setLong(2, transferRequest.getToAccountNumber());
                    stmt.setLong(3, transferRequest.getAmount());
                    stmt.setString(4, transferRequest.getTransferType());
                    stmt.setLong(5, transferRequest.getClientId());
                    return stmt;
                }
            }, keyHolder);

            logger.info("Resultant beneficiary id is ",keyHolder.getKey());
            return keyHolder.getKey().intValue();



    }

}
