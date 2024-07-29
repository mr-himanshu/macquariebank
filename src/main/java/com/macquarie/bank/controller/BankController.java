package com.macquarie.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macquarie.bank.model.Account;
import com.macquarie.bank.model.AccountTransaction;
import com.macquarie.bank.service.AccountService;
import com.macquarie.bank.service.TransactionService;
import com.macquarie.bank.validation.AccountNumberValidation;

@RestController
@RequestMapping("/api")
public class BankController {
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);

	
	private AccountService accountService;

	
	private TransactionService accountTransactionService;

	
	private AccountNumberValidation accountNumberValidation;

	
	
	@Autowired
	public BankController(AccountService accountService, TransactionService accountTransactionService,
			AccountNumberValidation accountNumberValidation) {
		super();
		this.accountService = accountService;
		this.accountTransactionService = accountTransactionService;
		this.accountNumberValidation = accountNumberValidation;
	}

	// Endpoint to get all accounts
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		logger.info("Received request to get all accounts.");
		List<Account> accounts = accountService.getAllAccounts();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@GetMapping("/accounts/{accountNumber}/transactions")
	public ResponseEntity<List<AccountTransaction>> getTransactionsByAccountNumber(@PathVariable String accountNumber) {
		logger.info("Received request to get transactions for account number: {}", accountNumber);
		accountNumberValidation.validateAccountNumber(accountNumber); // Validate account number
		List<AccountTransaction> transactions = accountTransactionService.getTransactionsByAccountNumber(accountNumber);
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	// Endpoint to create a new account
	@PostMapping("/createaccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		logger.info("Received request to create a new account: {}", account);

		// Validate account number length
		accountNumberValidation.validateAccountNumber(account.getAccountNumber());

		// Create account using service
		Account createdAccount = accountService.createAccount(account);

		logger.info("Account created with number: {}", createdAccount.getAccountNumber());

		return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
	}


	// Endpoint to create a new transaction
	@PostMapping("/transactions")
	public ResponseEntity<AccountTransaction> createTransaction(@RequestBody AccountTransaction transaction) {
		logger.info("Received request to create a new transaction: {}", transaction);

		// Create transaction using service
		AccountTransaction createdTransaction = accountTransactionService.createTransaction(transaction);

		logger.info("Transaction created with ID: {}", createdTransaction.getId());

		return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
}
	}
