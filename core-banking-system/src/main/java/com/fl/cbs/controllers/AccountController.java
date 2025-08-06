package com.fl.cbs.controllers;

import com.fl.cbs.entities.Account;
import com.fl.cbs.entities.AccountBalanceResponse;
import com.fl.cbs.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{customerId}/balance")
    public AccountBalanceResponse getCustomer(@PathVariable String customerId) {
        double balance = accountService.getBalanceByCustomerId(customerId);
        return new AccountBalanceResponse(balance);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody @Valid Account account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }
}

