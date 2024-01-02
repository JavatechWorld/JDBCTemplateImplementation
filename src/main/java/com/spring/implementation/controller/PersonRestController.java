package com.spring.implementation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.implementation.model.Person;
import com.spring.implementation.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonRestController {
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
		personRepository.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
