package com.pearson.gradebook.dto;

import java.util.List;

import lombok.Data;

@Data
public class CourseDto {
	private Long id;
	private String name;
	private List<AssignmentDto> assignments;
	
	
}
