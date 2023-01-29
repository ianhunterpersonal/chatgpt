package com.totnesjava.chatgpt.openAi;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.totnesjava.chatgpt.openai.MainController;
import com.totnesjava.chatgpt.openai.OpenAIClient;

@WebMvcTest(MainController.class)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpenAIClient openAiClient;

    @Test
    void generateText_validPrompt_returnsGeneratedText() throws Exception {
        String prompt = "What is the meaning of life?";
        String generatedText = "The meaning of life is a philosophical question that has been debated throughout history.";
        when(openAiClient.generateText(anyString())).thenReturn(generatedText);

        mockMvc.perform(get("/generate-text").param("prompt", prompt))
                .andExpect(status().isOk())
                .andExpect(content().string(generatedText));
    }
}
