package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.dto.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	public Student findByFirstName(String firstName);
	public Student findByLastName(String lastName);
}
