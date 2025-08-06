package com.fl.fcs.kafkaconfigs;

import com.fl.fcs.dtos.LoanApprovedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class LoanEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public LoanEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void publishLoanDecision(LoanApprovedEvent event) {
        String message = "Loan " + event.getMessage() + " for user " + event.getUserId() + " amount: " + event.getAmount();
        kafkaTemplate.send("loan-events", message);
        System.out.println("[KAFKA-ASYNC] Sent: " + message);
    }
}

