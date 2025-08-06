package com.fl.cbs.services;

import com.fl.cbs.entities.Account;
import com.fl.cbs.exceptions.CustomerNotFound;
import com.fl.cbs.exceptions.ErrorResponse;
import com.fl.cbs.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;


@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public double getBalanceByCustomerId(String customerId) {
        Account account = accountRepository.findById(customerId)
                .orElseThrow(()-> new CustomerNotFound("The customer of id: "+customerId+ " wasn't found."));
        return account.getBalance();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public String customerSuggestion(Account account){
        if(account.getBalance() > 999.0){
            return "The account with the details \n"+account.toString()+ "\n is eligible to vote.";
        }
        return "The balance over Rs.999 is suggested for loan. ";
    }
}
