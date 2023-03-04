package com.demo.reactive.domain.model;

public class Person {

	private String name;
	private String country;
	private String city;
	private int age;
	
	public Person(String name, String country, String city, int age) {
		this.name = name;
		this.country = country;
		this.city = city;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
