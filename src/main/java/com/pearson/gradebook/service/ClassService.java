package com.pearson.gradebook.service;

import com.pearson.gradebook.dto.ClassDto;
import com.pearson.gradebook.dto.UserDto;

public interface ClassService {

	ClassDto add(ClassDto classDto);

	UserDto admit(UserDto userDto);

}
