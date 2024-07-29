package com.macquarie.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquarie.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
   
	
	
}
