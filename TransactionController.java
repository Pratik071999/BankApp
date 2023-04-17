package com.monocept.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.dto.request.TransactionRequest;
import com.monocept.dto.request.TransferRequest;
import com.monocept.serviceImpl.TransactionServiceImpl;


@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionService;
    
    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.deposit(transactionRequest);
    }
    
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.withdraw(transactionRequest);
    }
    
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest transferRequest) {
        return transactionService.transfer(transferRequest);
    }
    
}
