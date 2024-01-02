package com.spring.implementation.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.implementation.model.Person;

@Repository
public interface PersonRepository {

	List<Person> findAll();
	void save(Person person);
}
