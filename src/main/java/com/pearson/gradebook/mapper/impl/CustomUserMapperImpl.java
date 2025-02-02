package com.pearson.gradebook.mapper.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.UserBaseDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.entity.Course;
import com.pearson.gradebook.entity.User;

@Controller
public class CustomUserMapperImpl {
	
	@Autowired
	private CustomCourseMapperImpl customCourseMapperImpl;
	
	@Autowired
	private CustomClassMapperImpl classMapperImpl;

	public UserDto entityToDto(User entity) {
		if (entity == null) {
			return null;
		}

		UserDto userDto = new UserDto();

		userDto.setId(entity.getId());
		userDto.setType(entity.getType());
		userDto.setUserClass(classMapperImpl.entityToDto(entity.getStudentClass()));
		List<Course> courses = entity.getCourses();
		if(courses != null) {
			List<CourseDto> courseDtos = courses.stream()
					.map(course -> customCourseMapperImpl.entityToDTO(course))
					.toList();
			userDto.setCourses(courseDtos);
		}
		
		return userDto;
	}

	public User dtoToEntity(UserDto dto) {
		if (dto == null) {
			return null;
		}

		User user = new User();

		user.setId(dto.getId());
		user.setType(dto.getType());
		List<CourseDto> courseDtos = dto.getCourses();
		if(courseDtos != null) {
			List<Course> courses = courseDtos.stream()
					.map(course -> customCourseMapperImpl.dtoToEntity(course))
					.toList();
			user.setCourses(courses);
		}
		return user;
	}
	
	public UserBaseDto entityToBaseDto(User entity) {
		UserBaseDto base = new UserBaseDto();
		base.setType(entity.getType());
		base.setId(entity.getId());
		return base;
	}
}
