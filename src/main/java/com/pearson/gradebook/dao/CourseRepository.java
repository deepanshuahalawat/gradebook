package com.pearson.gradebook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pearson.gradebook.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
}
