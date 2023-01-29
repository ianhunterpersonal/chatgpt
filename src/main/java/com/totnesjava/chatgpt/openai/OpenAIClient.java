package com.totnesjava.chatgpt.openai;


import org.springframework.stereotype.Service;

@Service
public class OpenAIClient {

	private OpenAiApi openAiApi;

    public OpenAIClient(OpenAiApi openAiApi) {
        this.openAiApi = openAiApi;
    }

    public String generateText(String prompt) {
        return openAiApi.generateText(prompt);
    }
}
