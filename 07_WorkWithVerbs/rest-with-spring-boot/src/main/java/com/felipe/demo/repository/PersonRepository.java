package com.felipe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
