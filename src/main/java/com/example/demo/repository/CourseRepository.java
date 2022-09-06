package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByFeeLessThan(double fee) ;

}
