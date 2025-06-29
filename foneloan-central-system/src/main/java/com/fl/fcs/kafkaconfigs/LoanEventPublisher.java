package com.fl.fcs.kafkaconfigs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoanEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public LoanEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishLoanDecision(String userId, String status, double amount) {
        String message = "Loan " + status + " for user " + userId + " amount: " + amount;
        kafkaTemplate.send("loan-events", message);
        System.out.println("[KAFKA] Sent: " + message);
    }
}

