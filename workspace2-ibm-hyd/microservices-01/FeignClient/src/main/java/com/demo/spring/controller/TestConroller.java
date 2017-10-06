package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.client.EmpFeignClient;

@RestController
public class TestConroller {

	@Autowired
	private EmpFeignClient empService;
	@RequestMapping(path="/test/{id}")
	public String getData(@PathVariable("id")int empid){
		String resp=empService.getData(empid);
		return resp;
	}
}
