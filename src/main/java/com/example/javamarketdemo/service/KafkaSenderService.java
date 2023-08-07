package com.example.javamarketdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaSenderService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    String kafkaTopic = "basic-topic";
    

    public void sendMessage(String message) {
        kafkaTemplate.send(kafkaTopic, message);
    }
}
