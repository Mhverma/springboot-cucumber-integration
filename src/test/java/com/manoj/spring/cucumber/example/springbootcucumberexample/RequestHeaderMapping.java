package com.manoj.spring.cucumber.example.springbootcucumberexample;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;

public class RequestHeaderMapping implements RequestCallback{
	
	  final Map<String, String> requestHeaders;

	    private String body;
	    
	    

	public RequestHeaderMapping(Map<String, String> requestHeaders) {
			super();
			this.requestHeaders = requestHeaders;
		}



	@Override
	public void doWithRequest(ClientHttpRequest request) throws IOException {
		  final HttpHeaders clientHeaders = request.getHeaders();
	        for (final Map.Entry<String, String> entry : requestHeaders.entrySet()) {
	            clientHeaders.add(entry.getKey(), entry.getValue());
	        }
	        if (null != body) {
	            request.getBody().write(body.getBytes());
	        }
	}



	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	

}
