package com.pearson.gradebook.dto;

import java.util.List;

import org.apache.catalina.User;

import lombok.Data;

@Data
public class CourseRosterDto extends CourseDto{
	
	List<UserBaseDto> roster;
	
}
