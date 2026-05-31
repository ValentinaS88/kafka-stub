package org.example.kafkastub.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.kafkastub.model.KafkaMessage;
import org.example.kafkastub.model.MessageRequest;
import org.example.kafkastub.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/post-message")
    public ResponseEntity<String> postMessage(@RequestBody MessageRequest request,
                                              HttpServletRequest httpRequest) {
        try {
            String timestamp = String.valueOf(System.currentTimeMillis());
            String method = httpRequest.getMethod();
            String uri = httpRequest.getRequestURI();

            KafkaMessage kafkaMessage = new KafkaMessage(
                    request.getMsg_id(),
                    timestamp,
                    method,
                    uri
            );

            producerService.sendMessage(kafkaMessage);
            return ResponseEntity.ok("OK");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message to Kafka: " + e.getMessage());
        }
    }
}
