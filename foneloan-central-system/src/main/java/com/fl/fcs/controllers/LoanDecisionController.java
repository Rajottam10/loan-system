package com.fl.fcs.controllers;

import com.fl.fcs.dtos.LoanRequest;
import com.fl.fcs.dtos.LoanResponse;
import com.fl.fcs.services.LoanDecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan-decisions")
public class LoanDecisionController {

    private final LoanDecisionService loanDecisionService;

    @Autowired
    public LoanDecisionController(LoanDecisionService loanDecisionService) {
        this.loanDecisionService = loanDecisionService;
    }

    @PostMapping
    public LoanResponse decide(@RequestBody LoanRequest request) {
        return loanDecisionService.evaluateLoanRequest(request);
    }
}

