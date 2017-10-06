package com.demo.spring.service;

import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Emp;

@RestController
public class MyRestService {

	static HashMap<Integer, Emp> empDb = new HashMap<>();
	static {
		empDb.put(100, new Emp(100, "Scott", "Hyderabad", 35000));
		empDb.put(101, new Emp(101, "James", "Bangalore", 55000));
		empDb.put(102, new Emp(102, "Ketan", "Bangalore", 45000));
		empDb.put(103, new Emp(103, "Raju", "Hyderabad", 65000));
		empDb.put(104, new Emp(104, "Srinivas", "Hyderabad", 35000));
	}

	@RequestMapping(path = "/message", method = RequestMethod.GET)
	public String getMessage() {
		return "Hello from Spring REST";
	}

	@RequestMapping(path = "/find", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity findEmp(@RequestParam("empid")int id) {
		if (empDb.containsKey(id)) {
			Emp e = empDb.get(id);
			return ResponseEntity.ok(e);
		} else {
			return ResponseEntity.ok("{\"Status\":\"Not Found\"}");
		}
	}
}
