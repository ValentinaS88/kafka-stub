package org.example.kafkastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRequest {

    @JsonProperty("msg_id")
    private String msgId;

    public MessageRequest() {}

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
