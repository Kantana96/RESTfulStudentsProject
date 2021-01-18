package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

public class PostStudent {
	@NotBlank(message = "First name is mandatory!")
	private String firstName;
	@NotBlank(message="Last name is mandatory!")
	private String lastName;
	private int age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
