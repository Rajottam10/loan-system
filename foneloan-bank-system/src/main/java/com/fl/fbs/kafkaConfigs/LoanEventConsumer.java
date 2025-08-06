package com.fl.fbs.kafkaConfigs;

import com.fl.fbs.entities.LoanRecord;
import com.fl.fbs.repositories.LoanRecordRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class LoanEventConsumer {

    private final LoanRecordRepository loanRecordRepository;

    public LoanEventConsumer(LoanRecordRepository loanRecordRepository) {
        this.loanRecordRepository = loanRecordRepository;
    }

    @Transactional
    @KafkaListener(topics = "loan-events", groupId = "foneloan-bank-consumer-group")
    public void listen(String message) {
        try {
            System.out.println("[Kafka Consumer] Received message: " + message);
            LoanRecord record = toLoanRecord(message);
            loanRecordRepository.save(record);
            System.out.println("[DB] Saved loan record for: "+record.getCustomerId());
        }catch (Exception e){
            System.err.println("[ERROR] Failed to save loan record"+ e.getMessage());
        }
    }

    public LoanRecord toLoanRecord(String message) {
        LoanRecord record = new LoanRecord();

        try {
            String lowerMessage = message.toLowerCase();

            String status = lowerMessage.contains("approved") ? "APPROVED" :
                    lowerMessage.contains("rejected") ? "REJECTED" : "UNKNOWN";

            String customerId = message.split("user")[1].split(" ")[1].trim();

            String amountPart = message.split("amount:")[1].trim();
            double amount = Double.parseDouble(amountPart);

            record.setCustomerId(customerId);
            record.setStatus(status);
            record.setApprovedAmount(amount);
            record.setMessage(message);
            record.setCreatedAt(LocalDateTime.now());

        } catch (Exception e) {
            System.err.println("[ERROR] Failed to parse message: " + e.getMessage());
            record.setMessage("[PARSE ERROR] " + message);
        }

        return record;
    }

}
