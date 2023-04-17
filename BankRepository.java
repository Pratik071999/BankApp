package com.monocept.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.entities.Bank;
@Repository
public interface BankRepository extends JpaRepository<Bank , Integer> {
	Optional<Bank> findByBankName (String bankName);
	Optional<Bank> findByBankId (Long bankId);
}

