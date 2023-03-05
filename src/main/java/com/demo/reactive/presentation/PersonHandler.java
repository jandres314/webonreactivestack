package com.demo.reactive.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.reactive.application.services.PersonService;
import com.demo.reactive.domain.model.Person;

import reactor.core.publisher.Mono;

@Component
public class PersonHandler {

	@Autowired
	private PersonService service;

	public Mono<ServerResponse> listPeople(final ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.getAllPeople(), Person.class);
	}

	public Mono<ServerResponse> maxAge(final ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.getPersonMaxAge(),
				Person.class);
	}
	
	public Mono<ServerResponse> create(final ServerRequest request) {
		Person person = request.bodyToMono(Person.class).block();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.create(person),
				Person.class);
	}

}
