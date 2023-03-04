package com.demo.reactive.application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.reactive.application.persitence.PersonRepository;
import com.demo.reactive.domain.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Flux<Person> getAllPeople() {
		return Flux.fromStream(repository.allPerson().stream());
	}
	
	public Mono<Person> getPersonMaxAge() {
		Optional<Person> maxAge = repository.allPerson().stream().max((p1, p2) -> p1.getAge() - p2.getAge());
		return Mono.justOrEmpty(maxAge);
	}

}
