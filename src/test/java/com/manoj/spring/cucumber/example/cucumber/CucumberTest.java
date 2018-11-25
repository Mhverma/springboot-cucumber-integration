package com.manoj.spring.cucumber.example.cucumber;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", glue="com.manoj.spring.cucumber.example.cucumber")
public class CucumberTest {

}
