package com.github.marquesbmc.model;

import java.time.LocalDate;

import javax.persistence.Column;

public class ClientDTO {
	
	@Column(length = 200)
	private String name;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	private Double balance;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
