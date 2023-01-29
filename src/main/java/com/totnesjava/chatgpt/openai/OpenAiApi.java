package com.totnesjava.chatgpt.openai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAiApi {

	@Autowired
	private final RestTemplate restTemplate;

	private String openAiApiUrl;

	private String openAiApiKey;

	public OpenAiApi(RestTemplate restTemplate,
			@Value("${openai.api.url:https://api.openai.com/v1/engines/davinci/completions}") String url,
			@Value("${openai.api.key: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}") String apiKey) {
		this.restTemplate = restTemplate;
		openAiApiUrl = url;
		openAiApiKey = apiKey;
	}

	public String generateText(String prompt) {

		OpenAiRequest request = new OpenAiRequest(prompt); // Build the request body

		HttpHeaders headers = new HttpHeaders(); // Build the headers
		headers.set("Authorization", "Bearer " + openAiApiKey);
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Build the request
		HttpEntity<OpenAiRequest> httpEntity = new HttpEntity<>(request, headers);

		// Call the OpenAI API
		try {
			OpenAiResponse response = restTemplate.postForObject(openAiApiUrl, httpEntity, OpenAiResponse.class);
			// Return the generated text
			return response.getText();
		} catch (Throwable thr) {
			return "Cannot contact OpenAI Prompt: '" + prompt.strip().trim() + "'\n" + thr.toString();
		}
	}
}
