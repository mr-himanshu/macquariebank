package com.macquarie.bank.validation;



import org.springframework.stereotype.Component;

import com.macquarie.bank.exception.ApplicationException;

@Component
public class AccountNumberValidation {

    private static final int ACCOUNT_NUMBER_LENGTH = 10;

    public void validateAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.length() != ACCOUNT_NUMBER_LENGTH) {
            throw new ApplicationException("Account number must be exactly " + ACCOUNT_NUMBER_LENGTH + " characters long.");
        }
    }
}


