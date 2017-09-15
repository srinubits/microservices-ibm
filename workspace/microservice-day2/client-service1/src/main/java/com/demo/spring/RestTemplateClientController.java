package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateClientController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(path="/testclient/{name}")
	public String getData(@PathVariable("name")String name) {

		ResponseEntity<String> resp = restTemplate.
				getForEntity("http://test-service/demo/message?name=" + name,
				String.class);
		return resp.getBody();
	}
}
