package com.pearson.gradebook.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearson.gradebook.dao.CourseRepository;
import com.pearson.gradebook.dao.UserRepository;
import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.CourseRosterDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.entity.Assesment;
import com.pearson.gradebook.entity.Assignment;
import com.pearson.gradebook.entity.Course;
import com.pearson.gradebook.entity.User;
import com.pearson.gradebook.mapper.impl.CustomCourseMapperImpl;
import com.pearson.gradebook.mapper.impl.CustomUserMapperImpl;
import com.pearson.gradebook.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	Logger logger = LoggerFactory.getLogger(CourseService.class);

	@Autowired
	CustomCourseMapperImpl customCourseMapperImpl;
	
	@Autowired
	CustomUserMapperImpl customUserMapperImpl;

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public CourseDto register(CourseDto courseDto) {
		
		Course course = customCourseMapperImpl.dtoToEntity(courseDto);
		List<Assignment> assignments = course.getAssignments();
		if (assignments != null) {
			assignments.forEach(a -> a.setCourse(course));
			assignments.forEach((a) -> {
				List<Assesment> assesments = a.getAssesments();
				if (assesments != null) {
					assesments.forEach(assisment -> assisment.setAssignment(a));
				}
			});
		}
		logger.info("course: {}" + course);
		Course savedCourse = courseRepository.save(course);
		return customCourseMapperImpl.entityToDTO(savedCourse);
	}

	@Override
	public UserDto enrollStudent(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = null;
		if(userDto != null && userDto.getCourses() != null) {
			List<CourseDto> courseDtos = userDto.getCourses();
			user = userRepository.findById(userDto.getId()).get();
			logger.info("user: "+user);
			if(user != null) {
				List<Course> courses = courseDtos.stream()
					.map(courseDto -> courseRepository.findById(courseDto.getId()).get())
					.toList();
				logger.info("courses details: "+courses);
				
				List<Course> existingCourses = user.getCourses();
				existingCourses.addAll(courses);
				
				for(Course course: existingCourses) {
					List<User> existingUsers = course.getRoster();
					existingUsers.add(user);
					List<User> updatedUsers = existingUsers.stream().distinct().collect(Collectors.toList());
					course.setRoster(updatedUsers);
					courseRepository.save(course);
				}
				
				
				return customUserMapperImpl.entityToDto(user);
			}
		}else {
			logger.debug("Null userDto or courseDto");
		}
		return null;
	}

	@Override
	public CourseRosterDto courseRoster(Long courseId) {
		Course course = courseRepository.findById(courseId).get();
		return customCourseMapperImpl.entityToRosterDTO(course);
	}

	@Override
	public List<CourseDto> courseStructure(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> list() {
		// TODO Auto-generated method stub
		List<Course> courseList = courseRepository.findAll();
		return courseList.stream()
		.map(entity -> customCourseMapperImpl.entityToDTO(entity))
		.toList();
	}

}
