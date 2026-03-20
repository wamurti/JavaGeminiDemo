package com.example.geminidemo;

import com.example.geminidemo.Model.MessageToAiModel;
import com.example.geminidemo.Model.PostModel;
import org.springframework.stereotype.Service;

@Service
public class AiService {
    MessageToAiModel mapPostToMessageToAi(PostModel postModel){
        return new MessageToAiModel(postModel.getMessage(), postModel.getReceiver(),"","");
    }
    public void setInstructions(MessageToAiModel model, String instruction){
        model.setInstructions(instruction);
    }
    public void setContext(MessageToAiModel model, String context){
        model.setContext(context);
    }
}
