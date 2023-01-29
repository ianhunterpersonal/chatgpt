package com.totnesjava.chatgpt.openai;

import org.springframework.stereotype.Service;

@Service
public class OpenAiTextGeneratorService {

    private final OpenAIClient openAiClient;

    public OpenAiTextGeneratorService(OpenAIClient openAiClient) {
        this.openAiClient = openAiClient;
    }

    public String generateText(String prompt) {
        return openAiClient.generateText(prompt);
    }
}
