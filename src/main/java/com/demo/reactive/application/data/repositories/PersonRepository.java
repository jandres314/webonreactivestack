package com.demo.reactive.application.data.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.demo.reactive.application.data.entities.PersonEntity;


public interface PersonRepository extends ReactiveCrudRepository<PersonEntity, Long> {
	
}
