package com.monocept.entities;

import java.time.LocalDateTime;
import java.util.List;


import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNo;
	private Float amount;
    
    // Tell us whether the account is active or frozen
    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;
    
    // Stores when the account was created
    @CreationTimestamp
    private LocalDateTime createdOn;

    //foreign key
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "customerId", referencedColumnName="userId")
  	@JsonBackReference
  	private User user;
  	
    //foreign key
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "bankId", referencedColumnName="bankId")
  	@JsonBackReference
  	private Bank bank;
  	
  	
	@OneToMany(mappedBy = "account")
	@JsonManagedReference
	private List<Transaction> transfer;
	
	@OneToMany(mappedBy = "reciver")
	@JsonManagedReference
	private List<Transaction> recived;
}
