package com.totnesjava.chatgpt.openai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final OpenAIClient openAIClient;

    public MainController(OpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    @GetMapping("/generate-text")
    public String generateText() {
        return openAIClient.generateText("What is the meaning of life?");
    }
}
