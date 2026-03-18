package com.example.geminidemo;

public class MessageModel {
    String message;
    String receiver;

    public MessageModel(String message, String receiver) {
        this.message = message;
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}


