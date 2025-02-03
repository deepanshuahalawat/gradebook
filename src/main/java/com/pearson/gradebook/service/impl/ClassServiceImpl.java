package com.pearson.gradebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearson.gradebook.dao.ClassRepository;
import com.pearson.gradebook.dao.UserRepository;
import com.pearson.gradebook.dto.ClassDto;
import com.pearson.gradebook.dto.UserDto;
import com.pearson.gradebook.entity.SchoolClass;
import com.pearson.gradebook.entity.User;
import com.pearson.gradebook.mapper.impl.CustomClassMapperImpl;
import com.pearson.gradebook.mapper.impl.CustomUserMapperImpl;
import com.pearson.gradebook.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{
	
	private ClassRepository classRepository;
	private CustomClassMapperImpl classMapperImpl;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomUserMapperImpl customUserMapperImpl;
	
	@Autowired
	public ClassServiceImpl(ClassRepository classRepository, CustomClassMapperImpl classMapperImpl) {
		this.classRepository = classRepository;
		this.classMapperImpl = classMapperImpl;
	}
	
	@Override
	public ClassDto add(ClassDto classDto) {
		SchoolClass schoolClass = classMapperImpl.dtoToEntity(classDto);
		SchoolClass savedSchoolClass = classRepository.save(schoolClass);
		return classMapperImpl.entityToDto(savedSchoolClass);
	}

	@Override
	public UserDto admit(UserDto userDto) {
		if(userDto != null) {
			User user = userRepository.findById(userDto.getId()).get();
			if(user != null) {
				Long classId = userDto.getUserClass().getId();
				SchoolClass schoolClass = classRepository.findById(classId).get();
				user.setStudentClass(schoolClass);
				User savedUser = userRepository.save(user);
				return customUserMapperImpl.entityToDto(savedUser);
			}
		}
		return null;
	}
	
	
	
}
