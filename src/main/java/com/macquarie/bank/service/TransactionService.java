package com.macquarie.bank.service;

import java.util.List;

import com.macquarie.bank.model.AccountTransaction;

/**
 * Service interface for managing transactions.
 */
public interface TransactionService {

    
    /**
     * Creates a new transaction.
     *
     * @param transaction the transaction to be created
     * @return the created transaction
     */
    AccountTransaction createTransaction(AccountTransaction transaction);
    /**
     * Retrieves transactions for a specific account.
     *
     * @param accountNumber 
     * @return a list of transactions
     */
	List<AccountTransaction> getTransactionsByAccountNumber(String accountNumber);
}
