package com.demo.reactive.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private long id;
	private String name;
	private String country;
	private String city;
	private int age;

}
