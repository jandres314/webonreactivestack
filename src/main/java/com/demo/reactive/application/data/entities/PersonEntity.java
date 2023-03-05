package com.demo.reactive.application.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "persons", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
