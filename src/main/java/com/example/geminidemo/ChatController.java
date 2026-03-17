package com.example.geminidemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    // Spring AI skapar automatiskt en ChatClient.Builder för oss
    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/ai/generate")
    public String generate(@RequestParam(value = "message", defaultValue = "Berätta ett kort skämt om programmering") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
