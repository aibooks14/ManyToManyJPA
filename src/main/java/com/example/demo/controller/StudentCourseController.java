package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	@PostMapping
	public Student saveStudentWithCourse(@RequestBody Student student) {
		return studentRepository.save(student) ;
	}
	
	@GetMapping
	public List<Student> findAllStudents(){
		return studentRepository.findAll() ;
	}
	
	@GetMapping("/{studentId}")
	public Student findStudent(@PathVariable Long studentId) {
		return studentRepository.findById(studentId).orElse(null) ;
	}
	
	
	@GetMapping("/find/{name}")
	public List<Student> findStudentsContainingByName(@PathVariable String name){
		return studentRepository.findByNameContaining(name) ;
	}
	
	@GetMapping("/search/{price}")
	public List<Course> findCourseLessThanPrice(@PathVariable double price){
		return courseRepository.findByFeeLessThan(price) ;
	}
	
}