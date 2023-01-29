package com.totnesjava.chatgpt.openAi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.totnesjava.chatgpt.openai.OpenAIClient;
import com.totnesjava.chatgpt.openai.OpenAiTextGeneratorService;

@ExtendWith(MockitoExtension.class)
class OpenAiTextGeneratorServiceTest {

    @Mock
    private OpenAIClient openAiApi;

    @InjectMocks
    private OpenAiTextGeneratorService sut;

    @BeforeEach
    protected void beforeEachTest() {
    	sut = new OpenAiTextGeneratorService(openAiApi);
    }
    
    @Test
    void generateText_validPrompt_returnsGeneratedText() {
        String prompt = "What is the meaning of life?";
        String expectedText = "The meaning of life is a philosophical question that has been debated throughout history.";
        when(openAiApi.generateText(prompt)).thenReturn(expectedText);

        String generatedText = sut.generateText(prompt);

        assertEquals(expectedText, generatedText);
    }
}
