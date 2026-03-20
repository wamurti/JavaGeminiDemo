package com.example.geminidemo;

import com.example.geminidemo.Model.MessageToAiModel;
import com.example.geminidemo.Model.PostModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    private final AiService aiService;

    public ChatController(ChatClient.Builder builder,AiService aiService) {
        this.aiService = aiService;
        this.chatClient = builder.build();
    }

    @GetMapping("/ai/generate")
    public String generate(@RequestParam(value = "message", defaultValue = "Berätta ett kort skämt om programmering") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    @PostMapping("/validate")
    public String processPost(@RequestBody PostModel incomingPost) {

        MessageToAiModel msg = aiService.mapPostToMessageToAi(incomingPost);
        aiService.setInstructions(msg,"Ditt jobb är släppa igenom eller blockera meddelanden. Svara enbart ok, annars blocked. Svara i json format! och om du blockerar meddelandet skicka med ett ord som beskriver varför i blockedReason");
        aiService.setContext(msg,"Släpp igenom allt som inte är uppenbart skräp (spam), obegripligt svammel eller grova personangrepp (könsord/hot osv), även om det är hårt och dömande.");

        System.out.println(msg);
        return chatClient.prompt()
                .user(msg.toString())
                .call()
                .content();
    }
}
