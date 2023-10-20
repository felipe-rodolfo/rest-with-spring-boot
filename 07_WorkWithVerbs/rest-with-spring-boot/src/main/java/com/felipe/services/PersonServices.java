package com.felipe.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.felipe.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

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
