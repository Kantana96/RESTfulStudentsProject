package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class Student {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Min(value = 15)
	private int age;
	
	public Student() {
		super();
	}
	public Student(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
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
	@Override
	public String toString() {
		return "Student [Id="+id+",FirstName="+firstName+",LastName="+lastName+",Age="+age+"]";
	}
}
