package com.demo.reactive.domain.usecase;

import java.util.Optional;

import com.demo.reactive.domain.model.Person;
import com.demo.reactive.domain.rules.PersonRules;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UseCasePerson {

	private final PersonRules rules;

	public Flux<Person> getAllPeople() {
		return rules.getAllPeople();
	}

	public Mono<Optional<Person>> getPersonMaxAge() {
		return rules.getPersonMaxAge();
	}

	public Mono<Person> create(Person p) {
		return rules.create(p);
	}

}
