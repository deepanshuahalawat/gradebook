package com.pearson.gradebook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.gradebook.dto.ClassDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.service.ClassService;

@RestController
@RequestMapping("/api/class")
public class ClassController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private ClassService classService;
	
	public ClassController(ClassService classService) {
		this.classService = classService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<ClassDto> add(@RequestBody ClassDto classDto) {
		logger.info("new class: "+classDto);
		ClassDto dto = classService.add(classDto);
		return new ResponseEntity<ClassDto>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping("/admit")
	public ResponseEntity<UserDto> add(@RequestBody UserDto userDto) {
		logger.info("admit user: "+userDto);
		UserDto dto = classService.admit(userDto);
		return new ResponseEntity<UserDto>(dto, HttpStatus.CREATED);
	}
	
}
