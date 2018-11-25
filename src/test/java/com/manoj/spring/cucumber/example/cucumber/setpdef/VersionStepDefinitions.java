package com.manoj.spring.cucumber.example.cucumber.setpdef;

import org.springframework.http.HttpStatus;

import com.manoj.spring.cucumber.example.springbootcucumberexample.SpringIntegrationTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VersionStepDefinitions extends SpringIntegrationTest{

	  @When("^the client calls /version$")
	    public void the_client_issues_GET_version() throws Throwable {
	        executeGet("http://localhost:8080/rest/version");
	    }

	    @Then("^the client receives status code of (\\d+)$")
	    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
	        final HttpStatus currentStatusCode = latestResponse.getRestResponse().getStatusCode();
	        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
	    }

	    @And("^the client receives server version (.+)$")
	    public void the_client_receives_server_version_body(String version) throws Throwable {
	        assertThat(latestResponse.getBody(), is(version));
	    }
}
