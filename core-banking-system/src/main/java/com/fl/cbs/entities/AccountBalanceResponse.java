package com.fl.cbs.entities;

public class AccountBalanceResponse {
    private double balance;

    public AccountBalanceResponse() {}
    public AccountBalanceResponse(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

