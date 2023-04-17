package com.monocept.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.monocept.dto.request.TransactionRequest;
import com.monocept.dto.request.TransferRequest;
import com.monocept.entities.Account;
import com.monocept.entities.Transaction;
import com.monocept.entities.TransactionType;
import com.monocept.repo.AccountRepository;
import com.monocept.repo.TransactionRepository;
import com.monocept.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private AccountRepository accountRepo;
    
    @Override
	public ResponseEntity<String> deposit(TransactionRequest transactionRequest) {
        Account account = accountRepo.findByAccountNo(transactionRequest.getAccountId()).orElse(null);
        Float currentBalance = account.getAmount();
        Float depositAmount = transactionRequest.getAmount();
        Float updatedBalance = currentBalance + depositAmount;
        account.setAmount(updatedBalance);
        accountRepo.save(account);
        Transaction transaction = new Transaction();
        transaction.setAmount(depositAmount);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAccount(account);
        transaction.setStatus("Success");
        transactionRepository.save(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body("Transaction commit successfully");
    }
    


	@Override
	public ResponseEntity<String> withdraw(TransactionRequest transactionRequest) {
        Account account = accountRepo.findByAccountNo(transactionRequest.getAccountId()).orElse(null);
        Float currentBalance = account.getAmount();
        Float withdrawalAmount = transactionRequest.getAmount();
        if (withdrawalAmount > currentBalance) {
        	return ResponseEntity.status(HttpStatus.CREATED).body("Transaction failed, Insufficient Funds");
        }
        Float updatedBalance = currentBalance - withdrawalAmount;
        account.setAmount(updatedBalance);
        accountRepo.save(account);
        Transaction transaction = new Transaction();
        transaction.setAmount(withdrawalAmount);
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setAccount(account);
        transaction.setStatus("Success");
        transactionRepository.save(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body("Transaction commit succesfully");
	}

	@Override
	public ResponseEntity<String> transfer(TransferRequest transferRequest) {
        Account senderAccount = accountRepo.findByAccountNo(transferRequest.getSenderAccountId()).orElse(null);
        Account receiverAccount = accountRepo.findByAccountNo(transferRequest.getReceiverAccountId()).orElse(null);
        Float currentSenderBalance = senderAccount.getAmount();
        Float transferAmount = transferRequest.getAmount();
        if (transferAmount > currentSenderBalance) {
        	return ResponseEntity.status(HttpStatus.CREATED).body("Transaction failed, Insufficient Funds");
        }
        Float updatedSenderBalance = currentSenderBalance - transferAmount;
        senderAccount.setAmount(updatedSenderBalance);
        accountRepo.save(senderAccount);
        Float currentReceiverBalance = receiverAccount.getAmount();
        Float updatedReceiverBalance = currentReceiverBalance + transferAmount;
        receiverAccount.setAmount(updatedReceiverBalance);
        accountRepo.save(receiverAccount);
        Transaction transaction = new Transaction();
        transaction.setAmount(transferAmount);
        transaction.setTransactionType(TransactionType.TRANSFER);
        transaction.setAccount(senderAccount);
        transaction.setReciver(receiverAccount);
        transaction.setStatus("Success");
        transactionRepository.save(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body("Transfer commit successfully");
	}
}