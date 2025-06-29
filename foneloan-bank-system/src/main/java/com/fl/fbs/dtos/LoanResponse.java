package com.fl.fbs.dtos;

public class LoanResponse {
    private String status;
    private double approvedAmount;
    private String message;

    public LoanResponse(){}

    public LoanResponse(String status, double approvedAmount, String message) {
        this.status = status;
        this.approvedAmount = approvedAmount;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
