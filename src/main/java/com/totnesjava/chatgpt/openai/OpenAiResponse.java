package com.totnesjava.chatgpt.openai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class OpenAiResponse {
    private String text;
}

