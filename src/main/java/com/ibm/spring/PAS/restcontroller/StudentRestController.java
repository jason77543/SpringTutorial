package com.ibm.spring.PAS.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring.PAS.entity.Student;

@RestController
@RequestMapping(value = "/api")
public class StudentRestController {

	@GetMapping(value = "/students")
	public List<Student> getStudents (){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Jason","Huang"));
		students.add(new Student("Vicky","Lin"));
		return students;
	}
	
}
