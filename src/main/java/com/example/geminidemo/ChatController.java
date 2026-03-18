package com.example.geminidemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatClient chatClient;

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

    @PostMapping("/process")
    public String processPost(@RequestBody MessageModel incomingPost) {
        // Hämta befintlig content och lägg till din textsnutt
        String updatedContent = " - Ditt jobb är att tolka detta meddelande som är riktat till "+incomingPost.getReceiver()+ " genom att avgöra om det är snällt eller elakt, är det elakt svara enbart med blocked, annars svara med godkänd. Meddelande: " +incomingPost.getMessage();

        // Uppdatera objektet
        incomingPost.setMessage(updatedContent);

        // Returnera objektet (Spring gör om det till JSON automatiskt)
        return chatClient.prompt()
                .user(updatedContent)
                .call()
                .content();
    }
}
