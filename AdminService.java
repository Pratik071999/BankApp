package com.monocept.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.monocept.dto.request.AccountRequest;
import com.monocept.dto.request.CreateBank;
import com.monocept.dto.request.RegisterRequest;
import com.monocept.dto.response.TransactionDetail;


public interface AdminService {
	
	ResponseEntity<String> registerUser(RegisterRequest request);
	
	ResponseEntity<String> createAcc(AccountRequest request);
	
	ResponseEntity<String> createBank(CreateBank request);
	
	List<TransactionDetail> getAllTransactions();
	
	ResponseEntity<?> registerAdmin(RegisterRequest request);
}
