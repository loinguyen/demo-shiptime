package com.shiptime.demo.dto;

import java.io.Serializable;
import java.util.List;

public class ErrorMessageDTO implements Serializable {
    Boolean success;
    List<String> messages;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
