package com.fl.cbs.services;

import com.fl.cbs.entities.Account;

import java.util.List;

public interface AccountService {
    double getBalanceByCustomerId(String customerId);
    Account createAccount(Account account);
}
