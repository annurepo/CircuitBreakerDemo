package com.infy.add.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

	@GetMapping("/message")
	public String addMessage()
	{
		return "Address Details from Address MS"; 
	}	
}