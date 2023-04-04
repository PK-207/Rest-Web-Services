package com.in28minutes.rest.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Person {

	private final UUID id;
	@NotBlank(message = "Name should not be Blank")
	private final String name;

	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
