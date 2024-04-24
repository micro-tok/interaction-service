package com.example.interaction_service.config;//package com.example.interaction_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Component
public class Producer {
    @Autowired()
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME = "twmjkjhb-notification-service";
    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.println("Message " + message +
                " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }

}