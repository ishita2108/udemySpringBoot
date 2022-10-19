package com.in28minutes.springboot.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@RequestMapping("hello-world")
	public String helloworld() {
		return "Hello World!!";
	}
	
	@RequestMapping("hello-world-bean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Hello World!!");
	}
	
	@RequestMapping("hello-world-path-param/{name}")
	public HelloWorldBean helloworldPathParam(@PathVariable String name) {
		return new HelloWorldBean("Hello World!! " + name);
	}
	
	@RequestMapping("hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean helloworldMultiplePathParam(@PathVariable String name,
			@PathVariable String message) {
		return new HelloWorldBean(message + " " + name);
	}

}
