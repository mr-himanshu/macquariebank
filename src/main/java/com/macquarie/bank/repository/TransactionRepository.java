package com.macquarie.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macquarie.bank.model.AccountTransaction;

/**
 * Repository interface for Transaction entities.
 */
public interface TransactionRepository extends JpaRepository<AccountTransaction, Long> {
  
    /**
     * Finds transactions by account number.
     *
     * @param accountNumber the account number
     * @return a list of transactions
     */
    List<AccountTransaction> findByAccountNumber(String accountNumber);
    
    
}
