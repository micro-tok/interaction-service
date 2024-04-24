package com.example.interaction_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageSender {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaMessageSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Message sent to Kafka topic " + topic + ": " + message);
    }
}
