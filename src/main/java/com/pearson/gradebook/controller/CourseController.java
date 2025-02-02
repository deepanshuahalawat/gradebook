package com.pearson.gradebook.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.CourseRosterDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	private CourseService courseService;
	
	
	private Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping("/register")
	public ResponseEntity<CourseDto> registerCourse(@RequestBody CourseDto courseDto){
		logger.info(""+courseDto);
		CourseDto courseDtoResponse = courseService.register(courseDto);
		return new ResponseEntity<CourseDto>(courseDtoResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<CourseDto>> list(){
		List<CourseDto> courseDtos = courseService.list();
		return new ResponseEntity<List<CourseDto>>(courseDtos,HttpStatus.OK);
	}
	
	@PutMapping("/enroll")
	public ResponseEntity<UserDto> enroll(@RequestBody UserDto userDto){
		logger.info("user enroll: "+userDto);
		UserDto enrolledUser = courseService.enrollStudent(userDto);
		return new ResponseEntity<UserDto>(enrolledUser, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/roster/{courseId}")
	public ResponseEntity<CourseRosterDto> list(@PathVariable Long courseId){
		logger.info("Course id: "+courseId);
		CourseRosterDto roster = courseService.courseRoster(courseId);
		return new ResponseEntity<CourseRosterDto>(roster, HttpStatus.OK);
	}
	
	
	
}
