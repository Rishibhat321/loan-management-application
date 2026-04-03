package com.cg.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Loan;
import com.cg.exceptions.InvalidLoanAmountException;
import com.cg.exceptions.DuplicateLoanApplicationException;
import com.cg.exceptions.LoanNotFoundException;
import com.cg.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepo;
    

    @Override
    public Loan createLoan(Loan loan) {

       
        if (loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 5000000) {
            throw new InvalidLoanAmountException("Loan amount must be between 1 and 5000000");
        }

       
        loanRepo.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING")
                .ifPresent(existing -> {
                    throw new DuplicateLoanApplicationException("User already has a PENDING loan");
                });

        loan.setStatus("PENDING");

        return loanRepo.save(loan);
    }
    
    
    @Override
    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {


    Optional<Loan> optLoan = loanRepo.findById(id);
		
		if(optLoan.isPresent())  {
			return optLoan.get();
		}
		
		
		throw new LoanNotFoundException("Loan not found with ID: " + id);
		
    }

   
    
    @Override
    public Loan updateLoanStatus(Long id, String status) {

        Loan loan = loanRepo.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found"));

        loan.setStatus(status.toUpperCase());

        return loanRepo.save(loan);
    }
    
    
}