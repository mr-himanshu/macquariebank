package com.macquarie.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.macquarie.bank.model.Account;
import com.macquarie.bank.repository.AccountRepository;
import com.macquarie.bank.service.AccountService;

/**
 * Implementation of AccountService interface.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    
    /**
     * Constructor-based dependency injection.
     *
     * @param accountRepository the AccountRepository
     */
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Creates a new account.
     *
     * @param account the account to be created
     * @return the created account
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountById(Long id) {
        return null;
    }
}

