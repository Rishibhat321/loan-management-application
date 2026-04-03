package com.cg.exceptions;

public class DuplicateLoanApplicationException extends RuntimeException {
	
	
    public DuplicateLoanApplicationException(String msg) {
        super(msg);
    }
}