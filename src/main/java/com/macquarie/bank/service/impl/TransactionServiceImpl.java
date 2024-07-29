package com.macquarie.bank.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.macquarie.bank.model.AccountTransaction;
import com.macquarie.bank.repository.TransactionRepository;
import com.macquarie.bank.service.TransactionService;

/**
 * Implementation of the TransactionService interface.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	private TransactionRepository transactionRepository;

	/**
	 * Retrieves transactions by account number.
	 *
	 * @param accountNumber the account number for which transactions are to be
	 *                      retrieved
	 * @return the list of transactions
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AccountTransaction> getTransactionsByAccountNumber(String accountNumber) {
		logger.info("Fetching transactions for account number: {}", accountNumber);

		List<AccountTransaction> transactions = transactionRepository.findByAccountNumber(accountNumber);

		if (transactions.isEmpty()) {
			logger.warn("No transactions found for account number: {}", accountNumber);
		} else {
			logger.info("Found {} transactions for account number: {}", transactions.size(), accountNumber);
		}

		return transactions;
	}

	/**
	 * Creates a new transaction.
	 *
	 * @param transaction the transaction to be created
	 * @return the created transaction
	 */

	@Override
	public AccountTransaction createTransaction(AccountTransaction transaction) {
		logger.info("Creating a new transaction: {}", transaction);

		AccountTransaction savedTransaction = transactionRepository.save(transaction);

		logger.info("Transaction created with ID: {}", savedTransaction.getId());

		return savedTransaction;
	}
}
