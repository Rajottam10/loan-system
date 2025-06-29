package com.fl.fbs.controllers;

import com.fl.fbs.dtos.LoanRequest;
import com.fl.fbs.dtos.LoanResponse;
import com.fl.fbs.services.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan-requests")
public class LoanRequestController {

    private final LoanRequestService loanRequestService;

    @Autowired
    public LoanRequestController(LoanRequestService loanRequestService) {
        this.loanRequestService = loanRequestService;
    }

    @PostMapping
    public LoanResponse requestLoan(@RequestBody LoanRequest loanRequest) {
        return loanRequestService.forwardRequestToCentral(loanRequest);
    }
}

