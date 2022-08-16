package com.infy.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/employee")
public class EmployeController {

	@Autowired
	public RestTemplate restTemplate;
	
	public static final String EMPSERVICE = "empService";
	
	public static final String BASE_URL="http://localhost:8082/add/message";
	
	@GetMapping("/message")
	@CircuitBreaker(name=EMPSERVICE, fallbackMethod="addServiceFallBack")
	public String empMessage()
	{
		
		String addmsg = restTemplate.getForObject(BASE_URL,String.class);
		
		return "Employee Details from Employee MS  "+addmsg; 
	}	
	
	public String addServiceFallBack(Exception e)
	{
		return "This is fallback method for Employee Service ..";
	}
}
