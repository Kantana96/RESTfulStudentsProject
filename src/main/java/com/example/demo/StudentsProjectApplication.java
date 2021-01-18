package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostStudent;
import com.example.demo.dto.Student;

@RestController
@SpringBootApplication
public class StudentsProjectApplication implements CommandLineRunner{
	@Autowired
	private StudentRepository studentRepository;
	
	@CrossOrigin
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/students")
	public ResponseEntity<Student> postStudent(@Valid @RequestBody PostStudent student) {
		Student stud = new Student();
		stud.setFirstName(student.getFirstName());
		stud.setLastName(student.getLastName());
		stud.setAge(student.getAge());
		studentRepository.save(stud);
		System.out.println(stud);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") String id,@Valid @RequestBody Student student) {
		Optional<Student> stud = studentRepository.findById(id);
		if(stud.isPresent()) {
			Student _student = stud.get();
			_student.setFirstName(student.getFirstName());
			_student.setLastName(student.getLastName());
			_student.setAge(student.getAge());
			studentRepository.save(_student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@CrossOrigin
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") String id, @Valid @RequestBody Student student){
		try {
			studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/students")
	public ResponseEntity<HttpStatus> deleteAllStudents(){
		try {
			studentRepository.deleteAll();
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudentsProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		studentRepository.deleteAll();
		studentRepository.save(new Student("Kanat","Urazaliyev",24));
		studentRepository.save(new Student("Erkebulan","Urazaliyev",17));
		studentRepository.save(new Student("Ayghanim","Urazaliyeva",20));
	}

}
