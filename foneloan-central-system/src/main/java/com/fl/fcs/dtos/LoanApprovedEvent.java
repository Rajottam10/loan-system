package com.fl.fcs.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanApprovedEvent {
    private final String userId;
    private final String message;
    private final double amount;

    public LoanApprovedEvent(String userId, String message, double amount) {
        this.userId = userId;
        this.message = message;
        this.amount = amount;
    }

}

