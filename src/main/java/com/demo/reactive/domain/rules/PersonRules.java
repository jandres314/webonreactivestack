package com.demo.reactive.domain.rules;

import java.util.Optional;

import com.demo.reactive.domain.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRules {
	
	Flux<Person> getAllPeople();
	
	Mono<Optional<Person>> getPersonMaxAge();
	
	Mono<Person> create(Person p);

}
