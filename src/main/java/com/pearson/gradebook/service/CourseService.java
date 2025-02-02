package com.pearson.gradebook.service;

import java.util.List;

import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.CourseRosterDto;
import com.pearson.gradebook.dto.UserDto;

public interface CourseService {
	
	CourseDto register(CourseDto courseDto);
	
	List<CourseDto> list();
	
	UserDto enrollStudent(UserDto studentDto);
	
	CourseRosterDto courseRoster(Long courseId);
	
	List<CourseDto> courseStructure(Long courseId);
	
	
}
