package com.demo.reactive.presentation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.reactive.domain.model.Person;
import com.demo.reactive.domain.usecase.UseCasePerson;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private UseCasePerson useCase;

	@GetMapping
	public Flux<Person> allPeople() {
		return useCase.getAllPeople();
	}

	@GetMapping("/max-age")
	public Mono<Optional<Person>> maxAge() {
		return useCase.getPersonMaxAge();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Person> create(@RequestBody Person person) {
		return useCase.create(person);
	}

}
