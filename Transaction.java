package com.monocept.entities;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tID;
	private Float amount;
    @CreationTimestamp
    private LocalDateTime createdOn;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "senderAccID", referencedColumnName="accountNo")
  	@JsonBackReference
  	private Account account;
  	
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "reciverAccId", referencedColumnName="accountNo")
  	@JsonBackReference
  	private Account reciver;
  	
  	String status;
	
}
