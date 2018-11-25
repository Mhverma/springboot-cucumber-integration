package com.manoj.spring.cucumber.example.springbootcucumberexample;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes=SpringBootCucumberExampleApplication.class)
@WebAppConfiguration
public class SpringIntegrationTest {

	protected static Response latestResponse = null;

	@Autowired
	protected RestTemplate restTemplate;
	
	protected void executeGet(String url) throws IOException {
		final Map<String, String> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		final RequestHeaderMapping headerMapping = new RequestHeaderMapping(headers);
		final RestResponseErrorHandler errorHandler = new RestResponseErrorHandler();

		restTemplate.setErrorHandler(errorHandler);
		latestResponse = restTemplate.execute(url, HttpMethod.GET, headerMapping, response -> {
			if (errorHandler.getHadError()) {
				return (errorHandler.getResults());
			} else {
				return (new Response(response));
			}
		});
	}
	
	

}
