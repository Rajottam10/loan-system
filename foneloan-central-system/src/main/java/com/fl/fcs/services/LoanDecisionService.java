package com.fl.fcs.services;

import com.fl.fcs.dtos.AccountBalanceResponse;
import com.fl.fcs.dtos.LoanApprovedEvent;
import com.fl.fcs.dtos.LoanRequest;
import com.fl.fcs.dtos.LoanResponse;
import com.fl.fcs.kafkaconfigs.LoanEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

@Service
public class LoanDecisionService {

    private final RestClient restClient;
    private final LoanEventPublisher loanEventPublisher;

    public LoanDecisionService(RestClient.Builder restClientBuilder, LoanEventPublisher loanEventPublisher) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
        this.loanEventPublisher = loanEventPublisher;
    }

    @Transactional
    public LoanResponse evaluateLoanRequest(LoanRequest request) {

        AccountBalanceResponse balanceResponse = restClient.get()
                .uri("/accounts/{customerId}/balance", request.getCustomerId())
                .retrieve()
                .body(AccountBalanceResponse.class);

        double balance = balanceResponse.getBalance();
        double requestedAmount = request.getRequestedAmount();

        LoanResponse response = new LoanResponse();

        if (balance >= requestedAmount) {
            response.setStatus("APPROVED");
            response.setApprovedAmount(requestedAmount);
            response.setMessage("Loan approved based on available balance");
        } else {
            response.setStatus("REJECTED");
            response.setApprovedAmount(0);
            response.setMessage("Loan rejected due to insufficient balance");
        }

        if(response.getStatus()=="APPROVED") {
            LoanApprovedEvent event = new LoanApprovedEvent(request.getCustomerId(), response.getMessage(), request.getRequestedAmount());
            loanEventPublisher.publishLoanDecision(event);
        }
        return response;
    }
}

