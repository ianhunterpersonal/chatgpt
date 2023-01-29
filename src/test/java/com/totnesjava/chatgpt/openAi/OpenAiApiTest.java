package com.totnesjava.chatgpt.openAi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.totnesjava.chatgpt.openai.OpenAiApi;
import com.totnesjava.chatgpt.openai.OpenAiResponse;

@ExtendWith(MockitoExtension.class)
class OpenAiApiTest {

	@Mock
	private RestTemplate restTemplate;

	private OpenAiApi sut;
	
	@BeforeEach
	protected void beforeEachTest() {
		sut = new OpenAiApi(restTemplate, "URL", "KEY");
	}
	
	@Test
	void generateText_validPrompt_returnsGeneratedText() {

		String prompt = "What is the meaning of life?";
		String expectedText = "The meaning of life is a philosophical question that has been debated throughout history.";

		when(restTemplate.postForObject(any(String.class), any(HttpEntity.class), eq(OpenAiResponse.class)))
				.thenReturn(new OpenAiResponse(expectedText));

		String generatedText = sut.generateText(prompt);

		assertEquals(expectedText, generatedText);
	}
}
