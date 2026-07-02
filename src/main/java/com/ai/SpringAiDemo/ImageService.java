package com.ai.SpringAiDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ChatClient chatClient;

    public ImageService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateImage(String prompt) {
        String asciiPrompt = """
        Draw a single ASCII cat.
        
        Return exactly one ASCII drawing.
        Do not repeat it.
        Do not create additional shapes.
        Do not add text.
        """;



        return chatClient.prompt(asciiPrompt)
                .call()
                .content();
    }
}