package org.example.kafkastub.service;

import jakarta.transaction.Transactional;
import org.example.kafkastub.entity.MessageEntity;
import org.example.kafkastub.model.KafkaMessage;
import org.example.kafkastub.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private MessageRepository messageRepository;

    @KafkaListener(topics = "postedmessages", groupId = "my-group")
    @Transactional
    public void consume(KafkaMessage message) {
        MessageEntity entity = new MessageEntity(
                message.getMsgId(),
                message.getTimestamp(),
                message.getMethod(),
                message.getUri()
        );

        messageRepository.save(entity);
    }

}
