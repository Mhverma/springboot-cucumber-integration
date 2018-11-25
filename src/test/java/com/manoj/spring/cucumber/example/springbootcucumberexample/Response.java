package com.manoj.spring.cucumber.example.springbootcucumberexample;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;

import gherkin.deps.net.iharder.Base64.InputStream;

public class Response {

	 private final ClientHttpResponse restResponse;
	    private final String body;
	    
		public Response(ClientHttpResponse response) throws IOException {		
			this.restResponse = response;
			 final InputStream bodyInputStream = (InputStream) response.getBody();
		        final StringWriter stringWriter = new StringWriter();
		        IOUtils.copy(bodyInputStream, stringWriter);
		        this.body = stringWriter.toString();
		}

		/**
		 * @return the restResponse
		 */
		public ClientHttpResponse getRestResponse() {
			return restResponse;
		}

		/**
		 * @return the body
		 */
		public String getBody() {
			return body;
		}
	    
	   
}
