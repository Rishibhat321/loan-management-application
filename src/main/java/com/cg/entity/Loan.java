package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private double loanAmount;
    private String status;      // status can be PENDING, APPROVED, REJECTED
    
    
    // No-args constructor
    public Loan() {}

    
    
    // All-args constructor
	public Loan(Long id, String applicantName, double loanAmount, String status) {
		super();
		this.id = id;
		this.applicantName = applicantName;
		this.loanAmount = loanAmount;
		this.status = status;
	}
	
	
	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
   
	
	

}
