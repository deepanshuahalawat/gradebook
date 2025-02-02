package com.pearson.gradebook.dto;

import lombok.Data;

@Data
public class ClassCourseScoreDto extends ClassScoreDto {

	private CourseBaseDto course;
}
