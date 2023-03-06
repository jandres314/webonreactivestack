package com.demo.reactive.presentation;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.demo.reactive.domain.model.Person;
import com.demo.reactive.domain.rules.PersonRules;
import com.demo.reactive.domain.usecase.UseCasePerson;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {ControllerPerson.class, UseCasePerson.class, PersonRules.class })
@WebFluxTest(ControllerPerson.class)
public class ControllerPersonTest {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private UseCasePerson useCase;

	@Test
    public void allPeople() {
    	when(useCase.getAllPeople()).thenReturn(Flux.just(new Person()));
    	webTestClient.get().uri("/person").exchange().expectStatus().isOk()
    	.expectBody(Person[].class).value(p -> {
    		Assertions.assertNotNull(p[0]);
    	});
    	verify(useCase).getAllPeople();
    }
	
	@Test
    public void maxAge() {
		Optional<Person> optional = Optional.of(new Person(10L, "Rosita", "CO", "Pueblorrico", 76));
    	when(useCase.getPersonMaxAge()).thenReturn(Mono.just(optional));
    	webTestClient.get().uri("/person/max-age").exchange().expectStatus().isOk()
    	.expectBody(Optional.class).value(op -> {
    		Assertions.assertTrue(op.isPresent());
    		boolean instance = op.get() instanceof Map;
    		Assertions.assertTrue(instance);
    	});
    	verify(useCase).getPersonMaxAge();
    }

}
