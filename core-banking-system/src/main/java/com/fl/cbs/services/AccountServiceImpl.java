package com.fl.cbs.services;

import com.fl.cbs.entities.Account;
import com.fl.cbs.repositories.AccountRepository;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public double getBalanceByCustomerId(String customerId) {
        Account account = accountRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("The customer of id: "+customerId+ " wasn't found."));
        return account.getBalance();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
