package com.demo.spring.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmpService {

	@RequestMapping(path="/find",produces="application/json",method=RequestMethod.GET)
	public String getData(@RequestParam("empid")int empid);
}
