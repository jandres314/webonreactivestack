package com.demo.reactive.application.persitence;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.reactive.domain.model.Person;

@Repository
public class PersonRepository {

	public List<Person> allPerson() {
		return Arrays.asList(new Person("Jaime", "CO", "Pueblorrico", 35),
				new Person("Camila", "CO", "Pueblorrico", 29));
	}
}
