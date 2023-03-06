package com.demo.reactive.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.reactive.domain.rules.PersonRules;
import com.demo.reactive.domain.usecase.UseCasePerson;

@Configuration
public class UseCaseConfiguration {

	@Bean
	UseCasePerson useCasePerson(PersonRules rules) {
		return new UseCasePerson(rules);
	}

}
