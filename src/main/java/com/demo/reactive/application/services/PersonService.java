package com.demo.reactive.application.services;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.reactive.application.data.entities.PersonEntity;
import com.demo.reactive.application.data.repositories.PersonRepository;
import com.demo.reactive.domain.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public Flux<Person> getAllPeople() {
		return repository.findAll().map(e -> new Person(e.getName(), e.getCountry(), e.getCity(), e.getAge()));
	}

	public Mono<Person> getPersonMaxAge() {
		Optional<Person> mono = repository.findAll()
				.map(e -> new Person(e.getName(), e.getCountry(), e.getCity(), e.getAge()))
				.collect(Collectors.maxBy((o1, o2) -> o1.getAge() - o2.getAge())).block();
		return Mono.justOrEmpty(mono);
	}

	public Mono<PersonEntity> create(Person person) {
		return repository.save(new PersonEntity(person.getName(), person.getCountry(), person.getCity(), person.getAge()));
	}

}
