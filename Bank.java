package com.monocept.entities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long bankId;
	String bankName;
	String abbriviation;
	
	@OneToMany(mappedBy = "bank")
	@JsonManagedReference
	private List<Account> accounts;
}
