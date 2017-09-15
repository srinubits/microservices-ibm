package com.demo.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/demo")
public class MyResource {

	@RequestMapping(path="/message",method=RequestMethod.GET)
	//http://localhost:8080/demo/message?name=Scott
	public String getMessage(@RequestParam("name")String n){
		return n+", Hello From Spring Microservice";
	}
}
