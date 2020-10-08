package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRestAPI {
private String title ="Hello , I am the Job Microservice";
	@Autowired
	private JobService jobService ;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title ;
	}
	
	@PutMapping(value ="/{id}" ,produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Job> updateJobEtat (@PathVariable(value ="id") int id ){
		return new ResponseEntity<>(jobService.updateJobEtat(id),HttpStatus.OK);
	}
}
