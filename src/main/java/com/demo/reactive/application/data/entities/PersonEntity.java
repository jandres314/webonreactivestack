package com.demo.reactive.application.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "persons", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PersonEntity {

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

}
