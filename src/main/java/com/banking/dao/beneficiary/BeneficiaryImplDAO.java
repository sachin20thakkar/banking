package com.banking.dao.beneficiary;


import com.banking.dao.account.util.GenerateSequenceDAO;
import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.model.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service("beneficiaryImplDAO")
public class BeneficiaryImplDAO implements BeneficiaryDAO {

    private Logger logger = LoggerFactory.getLogger(BeneficiaryImplDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GenerateSequenceDAO generateSequenceDAO;


    @Override
    public int addBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException {
        try {
            logger.info("Getting request to add beneficiary at DAO layer {}", beneficiaryInfo);
            String sql = "INSERT into beneficiary_sequence() VALUES ()";
            int sequenence = generateSequenceDAO.insertRecord(sql, "beneficiary");
            return insertBeneficiaryInfo(beneficiaryInfo, sequenence);
        }catch (Exception e) {
            logger.info("Exception to add beneficiary at DAO layer {}", e.getMessage());
            throw new BankingException(e);
        }
    }

    private int insertBeneficiaryInfo(BeneficiaryInfo beneficiaryInfo, int sequence) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement stmt = connection
                        .prepareStatement("INSERT into beneficiary_info(CLIENT_ID, BENEFICIARY_TYPE, BENEFICIARY_ACCOUNT_NUMBER, BENEFICIARY_ACCOUNT_TYPE, IFSC_CODE, BENEFICIARY_NAME, EMAIL_ID) VALUES (?, ?, ?, ?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, beneficiaryInfo.getClientId());
                stmt.setInt(2, beneficiaryInfo.getBeneficiaryType());
                stmt.setString(3, beneficiaryInfo.getBeneficiaryAccountNumber());
                stmt.setLong(4, beneficiaryInfo.getBeneficiaryAccountType());
                stmt.setString(5, beneficiaryInfo.getIfscCode());
                stmt.setString(6, beneficiaryInfo.getBeneficiaryName());
                stmt.setString(7, beneficiaryInfo.getEmailId());
                return stmt;
            }
        }, keyHolder);

        logger.info("Resultant beneficiary id is ",keyHolder.getKey());
        return keyHolder.getKey().intValue();
    }
}
