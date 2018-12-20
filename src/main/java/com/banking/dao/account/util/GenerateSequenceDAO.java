package com.banking.dao.account.util;

import com.banking.dao.account.CreateAccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service("generateSequenceDAO")
public class GenerateSequenceDAO {

    private Logger logger = LoggerFactory.getLogger(CreateAccountDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  int insertRecord(String sql, String type) {

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
}
