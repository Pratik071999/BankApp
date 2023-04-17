package com.monocept.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entities.Account;

public interface AccountRepository extends JpaRepository<Account , Long> {
	Optional<Account> findByAccountNo (Long accountNo);
	
}