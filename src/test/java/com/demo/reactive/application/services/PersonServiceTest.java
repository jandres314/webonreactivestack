package com.demo.reactive.application.services;

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

import com.demo.reactive.application.data.entities.PersonEntity;
import com.demo.reactive.application.data.repositories.PersonRepository;
import com.demo.reactive.domain.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@InjectMocks
	private PersonService service;

	@Mock
	private PersonRepository repository;

	@Test
	public void getAllPeople() {
		when(repository.findAll()).thenReturn(getBaseFlux());
		Flux<Person> flux = service.getAllPeople();
		StepVerifier.create(flux).expectSubscription().expectNextCount(2L).expectComplete().verify();
		verify(repository).findAll();
	}

	@Test
	public void create() {
		when(repository.save(any(PersonEntity.class))).thenReturn(Mono.just(new PersonEntity(0L, "jj", "co", "med", 10)));
		Mono<Person> mono = service.create(new Person());
		StepVerifier.create(mono).expectSubscription().assertNext(p -> Assertions.assertNotNull(p)).expectComplete().verify();
		verify(repository).save(any(PersonEntity.class));
	}
	
	@Test
	public void getPersonMaxAge() {
		when(repository.findAll()).thenReturn(getBaseFlux());
		Mono<Optional<Person>> mono = service.getPersonMaxAge();
		StepVerifier.create(mono).expectSubscription().assertNext(p -> {
			Assertions.assertTrue(p.isPresent());
			Assertions.assertEquals("Jaime", p.get().getName());
		}).expectComplete().verify();
		verify(repository).findAll();
	}
	
	@Test
	public void getEmptyPersonMaxAge() {
		when(repository.findAll()).thenReturn(Flux.empty());
		Mono<Optional<Person>> mono = service.getPersonMaxAge();
		StepVerifier.create(mono).expectSubscription().assertNext(op -> {
			Assertions.assertNotNull(op);			
		}).expectComplete().verify();
		verify(repository).findAll();
	}

	private Flux<PersonEntity> getBaseFlux() {
		return Flux.just(new PersonEntity(1L, "Jaime", "CO", "Pueblorrico", 35),
				new PersonEntity(1L, "Camila", "CO", "Pueblorrico", 29));
	}

}
