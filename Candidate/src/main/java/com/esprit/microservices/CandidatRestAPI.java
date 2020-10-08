package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatRestAPI {
	private String title ="Hello , I am the candidate Microservice";
	
	@Autowired
	private CandidatService candidatService ;
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title ;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidat> createCandidat (@RequestBody Candidat candidat){
		return new ResponseEntity<>(candidatService.addCandidat(candidat),HttpStatus.OK);
	}
	
	@PutMapping(value ="/{id}" ,produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidat> updateCandidat (@PathVariable(value ="id") int id , @RequestBody Candidat candidat){
		return new ResponseEntity<>(candidatService.updateCandidat(id, candidat),HttpStatus.OK);
	}
	
	@DeleteMapping(value ="/{id}" ,produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deteleCandidat (@PathVariable(value ="id") int id){
		return new ResponseEntity<>(candidatService.deleteCandidat(id),HttpStatus.OK);
	}
	
	
	
}
