package com.pearson.gradebook.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto extends UserBaseDto{
	
	ClassDto userClass;
	List<CourseDto> courses;
	
}
