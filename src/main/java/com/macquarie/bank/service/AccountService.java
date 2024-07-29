package com.macquarie.bank.service;

import java.util.List;

import com.macquarie.bank.model.Account;

/**
 * Service interface for managing Account entities.
 */
public interface AccountService {
    
    List<Account> getAllAccounts();
    
    Account getAccountById(Long id);
    
    

	Account createAccount(Account account);
}
