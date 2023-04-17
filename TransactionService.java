package com.monocept.service;

import org.springframework.http.ResponseEntity;

import com.monocept.dto.request.TransactionRequest;
import com.monocept.dto.request.TransferRequest;

public interface TransactionService {
    ResponseEntity<String> deposit(TransactionRequest transactionRequest);
    ResponseEntity<String> withdraw(TransactionRequest transactionRequest);
    ResponseEntity<String> transfer(TransferRequest transferRequest);
    
}
