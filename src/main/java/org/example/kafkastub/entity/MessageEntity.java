package org.example.kafkastub.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "msg_id", nullable = false, unique = true)
    private String msgId;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    @Column(name = "method", nullable = false)
    private String method;

    @Column(name = "uri", nullable = false)
    private String uri;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;


    public MessageEntity() {}

    public MessageEntity(String msgId, String timestamp, String method, String uri) {
        this.msgId = msgId;
        this.timestamp = timestamp;
        this.method = method;
        this.uri = uri;
        this.createdAt = Instant.now();
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
