package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	@Autowired
	RestTemplate rt;

	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity getEmpInfo(@PathVariable("id")int empid) {
		ResponseEntity<String> resp = 
				rt.exchange("http://emp-service/find?empid=" + empid, HttpMethod.GET, null,
				String.class);
		return resp;
	}
}
