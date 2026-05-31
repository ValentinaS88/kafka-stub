package org.example.kafkastub.service;

import org.springframework.stereotype.Service;
import org.example.kafkastub.model.KafkaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;


@Service
public class KafkaProducerService {

    @Value("${kafka.topic.posted-messages}")
    private String topic;

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(KafkaMessage message) throws Exception {
        kafkaTemplate.send(topic,message).get();
    }


}
