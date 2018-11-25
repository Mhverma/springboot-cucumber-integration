package com.manoj.spring.cucumber.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class VersionAppController {
	@Autowired
	private RestTemplate restTemapalte;

	@GetMapping("/version")
	public String getVersion(){
		return "1.0";
	}
}
