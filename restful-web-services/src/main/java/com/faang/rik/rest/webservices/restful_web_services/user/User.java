package com.faang.rik.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "app_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq")
	@SequenceGenerator(name = "my_entity_seq", sequenceName = "my_entity_sequence", initialValue = 10000, allocationSize = 1)
	private Long id;

	@Column
	@Size(min = 3,max = 20, message = "User name should be between 3 to 20")
	private String name;

	@Column(name = "date_of_birth")
	@Past(message = "Date of Birth should be in past")
	private LocalDate dob;

	public User() {
		super();
	}

	public User(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}

	public User(Long id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

}
