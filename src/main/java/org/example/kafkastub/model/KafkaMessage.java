package org.example.kafkastub.model;

public class KafkaMessage {
    private String msg_id;
    private String timestamp;
    private String method;
    private String uri;

    public KafkaMessage() {}

    public KafkaMessage(String msg_id, String timestamp, String method, String uri) {
        this.msg_id = msg_id;
        this.timestamp = timestamp;
        this.method = method;
        this.uri = uri;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
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
}
