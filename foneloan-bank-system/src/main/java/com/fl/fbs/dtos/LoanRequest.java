package com.fl.fbs.dtos;

public class LoanRequest {
    private String customerId;
    private double requestedAmount;

    public LoanRequest(String customerId, double requestedAmount) {
        this.customerId = customerId;
        this.requestedAmount = requestedAmount;
    }

    public LoanRequest() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
}
