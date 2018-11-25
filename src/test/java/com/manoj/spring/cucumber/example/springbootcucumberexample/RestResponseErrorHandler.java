package com.manoj.spring.cucumber.example.springbootcucumberexample;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestResponseErrorHandler implements ResponseErrorHandler{
	 private Response results = null;
     private Boolean hadError = false;

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		results = new Response(response);
		
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		hadError = response.getRawStatusCode() >= 400;
		return hadError;
	}

	/**
	 * @return the results
	 */
	public Response getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(Response results) {
		this.results = results;
	}

	/**
	 * @return the hadError
	 */
	public Boolean getHadError() {
		return hadError;
	}

	/**
	 * @param hadError the hadError to set
	 */
	public void setHadError(Boolean hadError) {
		this.hadError = hadError;
	}

	
	
}
