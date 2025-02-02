package com.pearson.gradebook.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearson.gradebook.controller.UserController;
import com.pearson.gradebook.dao.UserDao;
import com.pearson.gradebook.dto.CourseDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.entity.User;
import com.pearson.gradebook.mapper.UserMapper;
import com.pearson.gradebook.mapper.impl.CustomUserMapperImpl;
import com.pearson.gradebook.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserDao userRepository;
	private CustomUserMapperImpl customUserMapper;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserServiceImpl(UserDao userDao, CustomUserMapperImpl customUserMapper) {
		this.userRepository = userDao;
		this.customUserMapper = customUserMapper;
	}
	
	@Override
	public UserDto registerUser(UserDto userDto) {
		User user = customUserMapper.dtoToEntity(userDto);
		User newUser = userRepository.save(user);
		return customUserMapper.entityToDto(newUser);
	}

	@Override
	public UserDto enrolledCourses(Long userId) {
		User user = userRepository.findById(userId).get();
		logger.info("user: "+user);
		return customUserMapper.entityToDto(user);
	}

	@Override
	public List<UserDto> allUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = users.stream()
				.map(user -> customUserMapper.entityToDto(user))
				.toList();
		return userDtos;
	}
	
	public UserDto getUser(Long userId) {
		User user = userRepository.findById(userId).get();
		return customUserMapper.entityToDto(user);
	}

}
