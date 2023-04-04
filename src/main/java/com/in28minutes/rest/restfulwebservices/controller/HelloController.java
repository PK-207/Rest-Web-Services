package com.in28minutes.rest.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello-world")
	public String getHello() {
		System.out.println("inside Controller");
		return "Hello World !";
	}
}
