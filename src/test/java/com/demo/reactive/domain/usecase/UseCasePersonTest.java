package com.demo.reactive.domain.usecase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.reactive.domain.model.Person;
import com.demo.reactive.domain.rules.PersonRules;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class UseCasePersonTest {

	@InjectMocks
	private UseCasePerson useCase;

	@Mock
	private PersonRules rules;

	@Test
	public void getAllPeople() {
		Person person = new Person();
		when(rules.getAllPeople()).thenReturn(Flux.just(person));
		Flux<Person> flux = useCase.getAllPeople();
		StepVerifier.create(flux).expectSubscription().expectNext(person).expectNextCount(0).expectComplete().verify();
		verify(rules).getAllPeople();
	}

	@Test
	public void create() {
		when(rules.create(any(Person.class))).thenReturn(Mono.just(new Person()));
		Mono<Person> mono = useCase.create(new Person());
		StepVerifier.create(mono).expectSubscription().consumeNextWith(p -> {
			Assertions.assertNotNull(p);
		}).expectComplete().verify();
		verify(rules).create(any(Person.class));
	}
	
	@Test
	public void getPersonMaxAge() {
		Optional<Person> optional = Optional.of(new Person());
		when(rules.getPersonMaxAge()).thenReturn(Mono.just(optional));
		Mono<Optional<Person>> mono = useCase.getPersonMaxAge();
		StepVerifier.create(mono).expectSubscription().assertNext(op -> {
			Assertions.assertTrue(op.isPresent());
			Assertions.assertNotNull(op.get());			
		}).expectComplete().verify();
		verify(rules).getPersonMaxAge();
	}

}
