package com.felipe.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.felipe.demo.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person create(Person person) {
		logger.info("Creating one person");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Update one person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person");
	}
	
	private Person mockPerson(int i) {
		logger.info("Finding all people!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setName("Person name " + i);
		person.setLastName("Person Second " + i);
		person.setAddress("Address " + i);
		person.setGender("Gender " + i);
		return person;
	}

	public Person findById(String id) {
		logger.info("Finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setName("Felipe");
		person.setLastName("Felipe Second");
		person.setAddress("Joao Pessoa - Paraíba - Brasil");
		person.setGender("Male");
		return person;
	}

}
