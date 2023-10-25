package com.felipe.demo.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.demo.exceptions.ResourceNotFoundException;
import com.felipe.demo.model.Person;
import com.felipe.demo.repository.PersonRepository;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Creating one person");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		var entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setName(person.getName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
	
	public Person findById(Long id) {
		logger.info("Finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setName("Felipe");
		person.setLastName("Felipe Second");
		person.setAddress("Joao Pessoa - Paraíba - Brasil");
		person.setGender("Male");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}

}
