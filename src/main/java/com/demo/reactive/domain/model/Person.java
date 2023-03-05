package com.demo.reactive.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private long id;
	private String name;
	private String country;
	private String city;
	private int age;

}
