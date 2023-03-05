package com.demo.reactive.application.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "persons", schema="public")
public class PersonEntity {

	public PersonEntity() {
	}

	public PersonEntity(String name, String country, String city, Integer age) {
		this.name = name;
		this.country = country;
		this.city = city;
		this.age = age;
	}

	@Id
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private String country;
	@Column
	private String city;
	@Column
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
