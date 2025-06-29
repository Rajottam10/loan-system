package com.fl.fbs.kafkaConfigs;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LoanEventConsumer {

    @KafkaListener(topics = "loan-events", groupId = "foneloan-bank-consumer-group")
    public void listen(String message) {
        System.out.println("[Kafka Consumer] Received message: " + message);
    }
}
