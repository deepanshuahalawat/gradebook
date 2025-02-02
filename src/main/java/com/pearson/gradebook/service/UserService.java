package com.pearson.gradebook.service;

import java.util.List;

import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.UserDto;

public interface UserService {
	
	UserDto registerUser(UserDto userDto);
	
	UserDto enrolledCourses(Long userId);
	
	List<UserDto> allUsers();
	
	UserDto getUser(Long userId);
}
