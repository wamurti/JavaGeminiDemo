package com.example.geminidemo.Model;

public class MessageToAiModel {
    String message;
    String receiver;
    String instructions;
    String context;


    public void setContext(String context) {
        this.context = context;
    }

    public MessageToAiModel(String message, String receiver, String instructions, String context) {
        this.message = message;
        this.receiver = receiver;
        this.instructions = instructions;
        this.context = context;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "MessageToAi{" +
                "message='" + message + '\'' +
                ", receiver='" + receiver + '\'' +
                ", instructions='" + instructions + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
