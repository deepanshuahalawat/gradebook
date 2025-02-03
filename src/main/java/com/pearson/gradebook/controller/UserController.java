package com.pearson.gradebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.exception.customexception.UserNotFoundException;
import com.pearson.gradebook.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserController(UserService userServive) {
		this.userService = userServive;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
		logger.info("new user: "+userDto);
		UserDto savedUser =  userService.registerUser(userDto);
		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<UserDto> userEnrolledCourses(@PathVariable Long id){
		UserDto courses = userService.enrolledCourses(id);
		return new ResponseEntity<UserDto>(courses,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<UserDto>> allUsers(){
		List<UserDto> users = userService.allUsers();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long userId) throws UserNotFoundException{
		UserDto users = userService.getUser(userId);
		return new ResponseEntity<UserDto>(users, HttpStatus.OK);
	}
	
	
}
