package com.cg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/loan-api")
public class LoanApiController {

    @GetMapping("/work")
    public String loan() {
        return "Loan API is working!";
    }
    
}
