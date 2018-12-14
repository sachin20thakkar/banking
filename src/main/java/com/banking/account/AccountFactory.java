package com.banking.account;

import com.banking.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("accountCreationFactory")
public class AccountFactory {

      private static final Logger logger = LoggerFactory.getLogger(AccountFactory.class);

      @Autowired
      private CurrentAccount currentAccount;

      @Autowired
      private SavingAccount savingAccount;

      @Autowired
      private JointAccount jointAccount;

      public IAccountType getAccount(int accountType) throws BankingException {
          logger.info("Getting {} as account type", accountType);
          switch (accountType) {
              case 1:
                  return savingAccount;
              case 2:
                  return currentAccount;
              case 3:
                  return jointAccount;
              default:
                  logger.error("No available account found for {} account type", accountType);
                  throw new BankingException("No available account type found, please select correct account type");


          }
      }
}
