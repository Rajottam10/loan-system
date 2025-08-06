package com.fl.cbs.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    @NotBlank(message = "the customerId can't be null and should have atleast a white character")
    private String customerId;
    @NotNull(message = "the account balance cannot be null")
    private double balance;
    @Email
    private String email;

    public Account() {
    }

    public Account(String customerId, double balance, String email) {
        this.customerId = customerId;
        this.balance = balance;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}

