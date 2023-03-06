package com.demo.reactive.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.demo.reactive.domain.rules.PersonRules;

public class UseCaseConfigurationTest {
	
	private final UseCaseConfiguration configuration = new UseCaseConfiguration();
	
	@Test
	public void useCasePerson() {
		Assertions.assertNotNull(configuration.useCasePerson(Mockito.mock(PersonRules.class)));
	}

}
