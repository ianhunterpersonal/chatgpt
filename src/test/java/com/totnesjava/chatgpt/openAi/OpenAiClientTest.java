package com.totnesjava.chatgpt.openAi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.totnesjava.chatgpt.openai.OpenAIClient;
import com.totnesjava.chatgpt.openai.OpenAiApi;

@ExtendWith(MockitoExtension.class)
class OpenAIClientTest {

    @Mock
    private OpenAiApi openAiApi;

    private OpenAIClient sut;
    
	@BeforeEach
	protected void beforeEachTest() {
		sut = new OpenAIClient(openAiApi);
	}

    @Test
    public void generateText_validPrompt_returnsGeneratedText() {
    	
        String prompt = "What is the meaning of life?";
        String expectedText = "The meaning of life is a philosophical question that has been debated throughout history.";
        when(openAiApi.generateText(prompt)).thenReturn(expectedText);

        String generatedText = sut.generateText(prompt);

        assertEquals(expectedText, generatedText);
    }
}

