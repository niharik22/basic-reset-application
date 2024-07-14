package com.faang.rik.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World, Ur looking at the smartest coder.";
	}	
	
	@GetMapping(path = "/hello-world/bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World, Ur looking at the smartest coder.");
	}
	
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		String message = String.format("Hello %s, Ur looking at the smartest coder.", name);
		return new HelloWorldBean(message);
	}
}
