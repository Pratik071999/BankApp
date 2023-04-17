package com.monocept.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.entities.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction , Integer>{

}
