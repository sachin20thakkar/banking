package com.banking.dao.beneficiary;

import com.banking.dao.account.util.GenerateSequenceDAO;
import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("beneficiaryImplDAO")
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


    @Override
    public List<BeneficiaryInfo> getBeneficiary(long clientId) throws BankingException {
        logger.info("Getting request to get beneficiary info for {} at DAO", clientId);
        List<BeneficiaryInfo> beneficiaryInfoList = new ArrayList<>();
        List<Map<String, Object>> resultSetList = jdbcTemplate.queryForList("select * from beneficiary_info where client_id = ?",  new Object [] {clientId});
        for(Map resultSet: resultSetList) {
            BeneficiaryInfo beneficiaryInfo = new BeneficiaryInfo();
            beneficiaryInfo.setBeneficiaryId(Integer.valueOf(resultSet.get("TRANSACTION_ID").toString()));
            beneficiaryInfo.setBeneficiaryAccountNumber((String)resultSet.get("BENEFICIARY_ACCOUNT_NUMBER"));
            beneficiaryInfo.setBeneficiaryAccountType((Integer) resultSet.get("BENEFICIARY_ACCOUNT_TYPE"));
            beneficiaryInfo.setBeneficiaryName((String)resultSet.get("BENEFICIARY_NAME"));
            beneficiaryInfo.setBeneficiaryType((Integer) resultSet.get("BENEFICIARY_TYPE"));
            beneficiaryInfo.setClientId(Integer.valueOf(resultSet.get("CLIENT_ID").toString()));
            beneficiaryInfo.setEmailId((String) resultSet.get("EMAIL_ID"));
            beneficiaryInfo.setIfscCode((String) resultSet.get("IFSC_CODE"));
            beneficiaryInfoList.add(beneficiaryInfo);
        }
        return beneficiaryInfoList;
    }


    @Override
    public void updateBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException {
        try{
            logger.info("Getting request to update beneficiary info for {} at DAO", beneficiaryInfo);
            String sql = "Update beneficiary_info set BENEFICIARY_TYPE = ? , BENEFICIARY_ACCOUNT_NUMBER = ?, BENEFICIARY_ACCOUNT_TYPE = ?, IFSC_CODE = ?, BENEFICIARY_NAME = ?, EMAIL_ID = ? where TRANSACTION_ID = ?";
            jdbcTemplate.update(sql, new Object[] {beneficiaryInfo.getBeneficiaryType(), beneficiaryInfo.getBeneficiaryAccountNumber(),
                    beneficiaryInfo.getBeneficiaryAccountType(), beneficiaryInfo.getIfscCode(), beneficiaryInfo.getBeneficiaryName(),
                    beneficiaryInfo.getEmailId(), beneficiaryInfo.getBeneficiaryId()});
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
